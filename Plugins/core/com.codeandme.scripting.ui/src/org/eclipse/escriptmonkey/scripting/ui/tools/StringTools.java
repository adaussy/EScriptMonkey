/*******************************************************************************
 * Copyright (c) 2013 Christian Pontesegger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christian Pontesegger - initial API and implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.ui.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.XMLMemento;

/**
 * Helper class for string manipulations.
 */
public final class StringTools {

    /** Default line break character. */
    public static final String LINE_DELIMITER = System.getProperty(Platform.PREF_LINE_SEPARATOR);

    /** Regex to match urls. Taken from http://stackoverflow.com/questions/163360/regular-expresion-to-match-urls-java */
    public static final String REGEX_URL = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    /** Regex to match urls. Includes project:// and workspace:// */
    public static final String EXTENDED_REGEX_URL = "\\b(https?|ftp|file|project|workspace)://[-a-zA-Z0-9+&@#/%?=~_|!:,.; ]*[-a-zA-Z0-9+&@#/%=~_|]";

    /**
     * Hidden constructor.
     */
    @Deprecated
    private StringTools() {
    }

    /**
     * Create a string by repeating a character. A negative value for <i>length</i> will return an empty string.
     * 
     * @param c
     *            character to use
     * @param length
     *            amount of times
     * @return string with <code>length</code> characters
     */
    public static String getString(final char c, final int length) {
        if (length < 0)
            return "";

        final char[] chars = new char[length];
        Arrays.fill(chars, c);

        return new String(chars);
    }

    /**
     * Format a text to a paragraph. Automatically wraps lines, allows to indent the whole paragraph and separately the first line.
     * 
     * @param text
     *            text to format
     * @param firstIndent
     *            first line indent in characters
     * @param paragraphIndent
     *            paragraph indent in characters
     * @param lineLength
     *            maximum line length
     * @return formatted text
     */
    public static String formatText(final String text, final int firstIndent, final int paragraphIndent, final int lineLength) {
        final StringBuffer result = new StringBuffer();

        if (text != null) {
            final List<String> tokens = new LinkedList<String>(Arrays.asList(text.split("\\r?\\n")));
            int indent = firstIndent;
            while (!tokens.isEmpty()) {
                final String[] data = splitOnce(tokens.remove(0), lineLength - indent);

                result.append(getString(' ', indent));
                result.append(data[0]);
                result.append(LINE_DELIMITER);

                if (!data[1].isEmpty())
                    tokens.add(0, data[1]);

                indent = paragraphIndent;
            }
        }

        return result.toString();
    }

    /**
     * Splits a text after a given amount of characters. <code>length</code> denotes the maximum length for a line. The method will search for a delimiter
     * before that character and split the lines there.
     * 
     * @param text
     *            text to split
     * @param length
     *            amount of maximum characters to split
     * @return array with 2 elements: first line and the rest of the input text
     */
    public static String[] splitOnce(String text, final int length) {
        text = text.trim();

        // search for a line break
        final int lineBreak = text.indexOf(LINE_DELIMITER);
        if ((lineBreak >= 0) && (lineBreak <= length))
            return (new String[] { text.substring(0, lineBreak), text.substring(lineBreak + LINE_DELIMITER.length()) });

        if (text.length() > length) {
            // search for a words ending
            int pos = length;
            while (pos > 0) {
                if (Character.isWhitespace(text.charAt(pos)))
                    return new String[] { text.substring(0, pos).trim(), text.substring(pos + 1).trim() };

                pos--;
            }

            // fallback, cannot find any delimiter, make a hard linebreak
            return new String[] { text.substring(0, length), text.substring(length) };

        } else
            return new String[] { text, "" };
    }

    /**
     * Trim left. Trims start of text.
     * 
     * @param text
     *            text to trim
     * @return left trimmed text
     */
    public static String ltrim(final String text) {
        int i = 0;
        while ((i < text.length()) && Character.isWhitespace(text.charAt(i)))
            i++;

        return text.substring(i);
    }

    /**
     * Trim right. Trims end of text.
     * 
     * @param text
     *            text to trim
     * @return right trimmed text
     */
    public static String rtrim(final String text) {
        int i = text.length() - 1;
        while ((i >= 0) && Character.isWhitespace(text.charAt(i)))
            i--;

        return text.substring(0, i + 1);
    }

    /**
     * Counts how much characters of 2 texts match. Counts from the first character on until the first mismatch.
     * 
     * @param text1
     *            first text
     * @param text2
     *            second text
     * @return amount of start characters matching in both texts
     */
    public static int countEqualStart(final String text1, final String text2) {
        int equal = 0;
        while ((text1.length() > equal) && (text2.length() > equal) && (text1.charAt(equal) == text2.charAt(equal)))
            equal++;

        return equal;
    }

    /**
     * Indent a text. Works on multi line texts too.
     * 
     * @param text
     *            text to indent
     * @param indentation
     *            indentation to use
     * @return indented text
     */
    public static String indent(final String text, final String indentation) {
        if (text != null) {
            String result = text.replaceAll("\n", "\n" + indentation);
            if (result.endsWith("\n" + indentation))
                result = result.substring(0, result.length() - indentation.length());

            return indentation + result;
        }

        return indentation;
    }

    /**
     * Right pad text. Append characters to a text up to a given total text length.
     * 
     * @param text
     *            text to pad
     * @param c
     *            padding character
     * @param length
     *            expected totel text length
     * @return padded text
     */
    public static String rpad(final String text, final char c, final int length) {
        assert (text != null) : "text not defined";

        if (text.length() < length)
            return text + getString(c, length - text.length());

        return text;
    }

    /**
     * Remove occurrences of a given substring from a text.
     * 
     * @param text
     *            text holding data
     * @param needle
     *            substring to discard
     * @return stripped string
     */
    public static String strip(final String text, final String needle) {
        assert (text != null) : "text not defined";
        assert (needle != null) : "needle not defined";

        return text.replaceAll(Pattern.quote(needle), "");
    }

    /**
     * Convert an input stream to a string.
     * 
     * @param stream
     *            input string to read from
     * @return string containing stream data
     * @throws IOException
     *             thrown on problems with input stream
     */
    public static String toString(final InputStream stream) throws IOException {
        return toString(new InputStreamReader(stream));
    }

    /**
     * Read characters from a {@link Reader} and return its string representation. Can be used to convert an {@link InputStream} to a string.
     * 
     * @param reader
     *            reader to read from
     * @return string content of reader
     * @throws IOException
     *             when reader is not accessible
     */
    public static String toString(final Reader reader) throws IOException {
        final StringBuffer out = new StringBuffer();

        final char[] buffer = new char[1024];
        int bytes = 0;
        do {
            bytes = reader.read(buffer);
            if (bytes > 0)
                out.append(buffer, 0, bytes);
        } while (bytes != -1);

        return out.toString();
    }

    /**
     * Find start position of a given line number within a text.
     * 
     * @param data
     *            text to scan
     * @param lineNumber
     *            number of line we are looking for
     * @return pos >= 0 when line exists or -1
     */
    public static int getStartOfLinePosition(final String data, int lineNumber) {
        if (lineNumber < 1)
            return -1;

        if (lineNumber == 1)
            return 0;

        int pos = 0;
        while ((lineNumber-- > 1) && (pos != -1))
            pos = data.indexOf('\n', ++pos);

        return (pos != -1) ? pos + 1 : pos;
    }

    /**
     * Truncates a given string at a given amount of characters. If a text is truncated, it is appended with "...". The whole returned text will be <=
     * <i>length</i> characters. When truncation is necessary we will try to truncated after a full word.
     * 
     * @param text
     *            text to truncate
     * @param length
     *            max. amount of characters to be returned
     * @return
     */
    public static String truncate(final String text, final int length) {
        assert (text != null) : "Invalid <null> input value";

        if (text.length() <= length)
            return text;

        final String output = text.substring(0, 27);
        // TODO we could check for more delimiters here
        final int pos = output.lastIndexOf(' ');
        if (pos >= 18)
            return output.substring(0, pos) + "...";

        return output + "...";
    }

    /**
     * @param errorInputStream
     * @return
     * @throws IOException
     */
    public static String readAvailable(final InputStream stream) throws IOException {
        final StringBuffer data = new StringBuffer();
        final byte[] buffer = new byte[1024];

        while (stream.available() > 0) {
            final int bytes = stream.read(buffer);
            if (bytes > 0)
                data.append(new String(buffer, 0, bytes));
        }

        return data.toString();
    }

    /**
     * Get the XML text representing an {@link XMLMemento}.
     * 
     * @param memento
     *            memento to convert
     * @return string representation
     * @throws IOException
     *             if there is a problem serializing the document to the stream.
     */
    public static String toString(final XMLMemento memento) throws IOException {
        final StringWriter writer = new StringWriter();
        memento.save(writer);

        return writer.toString();
    }

    public static String toString(final File file) throws IOException {
        return toString(new FileInputStream(file));
    }

    /**
     * Read content of a file into a string.
     * 
     * @param file
     *            file to read from
     * @return file content
     * @throws IOException
     *             thrown on problems reading file
     * @throws CoreException
     *             thrown on problems accessing file
     */
    public static String toString(final IFile file) throws IOException, CoreException {
        return toString(file.getContents());
    }

    /**
     * Takes a string and inserts a space after each 2 characters. No space is inserted before the first and after the last character.
     * 
     * @param text
     *            test to augment
     * @return delimited text
     */
    public static String toDelimitedString(final String text) {
        final StringBuffer buffer = new StringBuffer(text);
        for (int i = text.length() - 2; i > 0; i = i - 2) {
            buffer.insert(i, ' ');
        }
        return buffer.toString();
    }

    private static final Pattern TIMING_PATTERN = Pattern.compile("(\\d+)\\s*([uµmn]?s)?");

    /**
     * Takes a string containing a number and a time unit and converts it to nanoseconds. The parser accepts ms (milli seconds), us/µs (micro seconds), ns (nano
     * seconds) and s (seconds). If no unit is provided the number is parsed and returned directly. This method does not parse negative values.
     * 
     * @param value
     *            string containing timing information
     * @return converted value in nanoseconds or -1.
     */
    public static long toNanoSeconds(final String value) {

        final Matcher matcher = TIMING_PATTERN.matcher(value.trim());
        if (matcher.matches()) {
            String timeInfo = matcher.group(1);
            String unitInfo = matcher.group(2);

            long result;
            try {
                result = Long.parseLong(timeInfo);

                if (("us".equals(unitInfo)) || ("µs".equals(unitInfo)))
                    return result * 1000;

                else if ("ms".equals(unitInfo))
                    return result * 1000 * 1000;

                else if ("s".equals(unitInfo))
                    return result * 1000 * 1000 * 1000;

                else if (unitInfo == null)
                    // no valid unit info
                    return result;

            } catch (final RuntimeException e) {
                // could not parse number part, should not happen as long as
                // regex is correct
                throw new RuntimeException("Invalid timing format");
            }
        }

        return -1;
    }

    /**
     * Concatenate elements of a String array using a dedicated delimiter.
     * 
     * @param tokens
     * @param delimiter
     * @return concatenated string
     */
    public static String join(final String[] tokens, final String delimiter) {
        StringBuffer buffer = new StringBuffer();

        for (String token : tokens) {
            buffer.append(token);
            buffer.append(delimiter);
        }

        if (buffer.length() > delimiter.length())
            buffer.delete(buffer.length() - delimiter.length(), buffer.length());

        return buffer.toString();
    }
}
