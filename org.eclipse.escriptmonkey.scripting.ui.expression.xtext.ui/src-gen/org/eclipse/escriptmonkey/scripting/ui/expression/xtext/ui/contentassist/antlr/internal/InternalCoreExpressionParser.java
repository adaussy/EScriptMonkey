/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.escriptmonkey.scripting.ui.expression.xtext.services.CoreExpressionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCoreExpressionParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'and'", "'or'", "'activeContexts'", "'activeEditor'", "'activeEditorId'", "'activePartId'", "'activeSite'", "'selection'", "'['", "']'", "'InstanceOf'", "'And'", "'{'", "'}'", "','", "'Or'", "'Not'", "'Iterable'", "'With'", "'AdaptTo'", "'Equal'", "'ifEmpty'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalCoreExpressionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCoreExpressionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCoreExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g"; }


     
     	private CoreExpressionGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(CoreExpressionGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleRoot"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:60:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:61:1: ( ruleRoot EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:62:1: ruleRoot EOF
            {
             before(grammarAccess.getRootRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot61);
            ruleRoot();

            state._fsp--;

             after(grammarAccess.getRootRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:69:1: ruleRoot : ( ( rule__Root__Group__0 ) ) ;
    public final void ruleRoot() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:73:2: ( ( ( rule__Root__Group__0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:74:1: ( ( rule__Root__Group__0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:74:1: ( ( rule__Root__Group__0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:75:1: ( rule__Root__Group__0 )
            {
             before(grammarAccess.getRootAccess().getGroup()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:76:1: ( rule__Root__Group__0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:76:2: rule__Root__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__0_in_ruleRoot94);
            rule__Root__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:88:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:89:1: ( ruleExpression EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:90:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression121);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:97:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:101:2: ( ( ( rule__Expression__Alternatives ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:102:1: ( ( rule__Expression__Alternatives ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:102:1: ( ( rule__Expression__Alternatives ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:103:1: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:104:1: ( rule__Expression__Alternatives )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:104:2: rule__Expression__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Expression__Alternatives_in_ruleExpression154);
            rule__Expression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleInstanceExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:118:1: entryRuleInstanceExpression : ruleInstanceExpression EOF ;
    public final void entryRuleInstanceExpression() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:119:1: ( ruleInstanceExpression EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:120:1: ruleInstanceExpression EOF
            {
             before(grammarAccess.getInstanceExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInstanceExpression_in_entryRuleInstanceExpression183);
            ruleInstanceExpression();

            state._fsp--;

             after(grammarAccess.getInstanceExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInstanceExpression190); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInstanceExpression"


    // $ANTLR start "ruleInstanceExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:127:1: ruleInstanceExpression : ( ( rule__InstanceExpression__Group__0 ) ) ;
    public final void ruleInstanceExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:131:2: ( ( ( rule__InstanceExpression__Group__0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:132:1: ( ( rule__InstanceExpression__Group__0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:132:1: ( ( rule__InstanceExpression__Group__0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:133:1: ( rule__InstanceExpression__Group__0 )
            {
             before(grammarAccess.getInstanceExpressionAccess().getGroup()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:134:1: ( rule__InstanceExpression__Group__0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:134:2: rule__InstanceExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__InstanceExpression__Group__0_in_ruleInstanceExpression216);
            rule__InstanceExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInstanceExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstanceExpression"


    // $ANTLR start "entryRuleAndExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:146:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:147:1: ( ruleAndExpression EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:148:1: ruleAndExpression EOF
            {
             before(grammarAccess.getAndExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAndExpression_in_entryRuleAndExpression243);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAndExpression250); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:155:1: ruleAndExpression : ( ( rule__AndExpression__Group__0 ) ) ;
    public final void ruleAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:159:2: ( ( ( rule__AndExpression__Group__0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:160:1: ( ( rule__AndExpression__Group__0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:160:1: ( ( rule__AndExpression__Group__0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:161:1: ( rule__AndExpression__Group__0 )
            {
             before(grammarAccess.getAndExpressionAccess().getGroup()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:162:1: ( rule__AndExpression__Group__0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:162:2: rule__AndExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group__0_in_ruleAndExpression276);
            rule__AndExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleOrExpresison"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:174:1: entryRuleOrExpresison : ruleOrExpresison EOF ;
    public final void entryRuleOrExpresison() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:175:1: ( ruleOrExpresison EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:176:1: ruleOrExpresison EOF
            {
             before(grammarAccess.getOrExpresisonRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOrExpresison_in_entryRuleOrExpresison303);
            ruleOrExpresison();

            state._fsp--;

             after(grammarAccess.getOrExpresisonRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOrExpresison310); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrExpresison"


    // $ANTLR start "ruleOrExpresison"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:183:1: ruleOrExpresison : ( ( rule__OrExpresison__Group__0 ) ) ;
    public final void ruleOrExpresison() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:187:2: ( ( ( rule__OrExpresison__Group__0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:188:1: ( ( rule__OrExpresison__Group__0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:188:1: ( ( rule__OrExpresison__Group__0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:189:1: ( rule__OrExpresison__Group__0 )
            {
             before(grammarAccess.getOrExpresisonAccess().getGroup()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:190:1: ( rule__OrExpresison__Group__0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:190:2: rule__OrExpresison__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group__0_in_ruleOrExpresison336);
            rule__OrExpresison__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrExpresisonAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrExpresison"


    // $ANTLR start "entryRuleNotExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:202:1: entryRuleNotExpression : ruleNotExpression EOF ;
    public final void entryRuleNotExpression() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:203:1: ( ruleNotExpression EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:204:1: ruleNotExpression EOF
            {
             before(grammarAccess.getNotExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNotExpression_in_entryRuleNotExpression363);
            ruleNotExpression();

            state._fsp--;

             after(grammarAccess.getNotExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNotExpression370); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNotExpression"


    // $ANTLR start "ruleNotExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:211:1: ruleNotExpression : ( ( rule__NotExpression__Group__0 ) ) ;
    public final void ruleNotExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:215:2: ( ( ( rule__NotExpression__Group__0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:216:1: ( ( rule__NotExpression__Group__0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:216:1: ( ( rule__NotExpression__Group__0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:217:1: ( rule__NotExpression__Group__0 )
            {
             before(grammarAccess.getNotExpressionAccess().getGroup()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:218:1: ( rule__NotExpression__Group__0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:218:2: rule__NotExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group__0_in_ruleNotExpression396);
            rule__NotExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNotExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNotExpression"


    // $ANTLR start "entryRuleIterableExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:230:1: entryRuleIterableExpression : ruleIterableExpression EOF ;
    public final void entryRuleIterableExpression() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:231:1: ( ruleIterableExpression EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:232:1: ruleIterableExpression EOF
            {
             before(grammarAccess.getIterableExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIterableExpression_in_entryRuleIterableExpression423);
            ruleIterableExpression();

            state._fsp--;

             after(grammarAccess.getIterableExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIterableExpression430); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIterableExpression"


    // $ANTLR start "ruleIterableExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:239:1: ruleIterableExpression : ( ( rule__IterableExpression__Group__0 ) ) ;
    public final void ruleIterableExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:243:2: ( ( ( rule__IterableExpression__Group__0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:244:1: ( ( rule__IterableExpression__Group__0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:244:1: ( ( rule__IterableExpression__Group__0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:245:1: ( rule__IterableExpression__Group__0 )
            {
             before(grammarAccess.getIterableExpressionAccess().getGroup()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:246:1: ( rule__IterableExpression__Group__0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:246:2: rule__IterableExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__0_in_ruleIterableExpression456);
            rule__IterableExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIterableExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIterableExpression"


    // $ANTLR start "entryRuleWithExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:258:1: entryRuleWithExpression : ruleWithExpression EOF ;
    public final void entryRuleWithExpression() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:259:1: ( ruleWithExpression EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:260:1: ruleWithExpression EOF
            {
             before(grammarAccess.getWithExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWithExpression_in_entryRuleWithExpression483);
            ruleWithExpression();

            state._fsp--;

             after(grammarAccess.getWithExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWithExpression490); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWithExpression"


    // $ANTLR start "ruleWithExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:267:1: ruleWithExpression : ( ( rule__WithExpression__Group__0 ) ) ;
    public final void ruleWithExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:271:2: ( ( ( rule__WithExpression__Group__0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:272:1: ( ( rule__WithExpression__Group__0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:272:1: ( ( rule__WithExpression__Group__0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:273:1: ( rule__WithExpression__Group__0 )
            {
             before(grammarAccess.getWithExpressionAccess().getGroup()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:274:1: ( rule__WithExpression__Group__0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:274:2: rule__WithExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group__0_in_ruleWithExpression516);
            rule__WithExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWithExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWithExpression"


    // $ANTLR start "entryRuleAdaptExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:286:1: entryRuleAdaptExpression : ruleAdaptExpression EOF ;
    public final void entryRuleAdaptExpression() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:287:1: ( ruleAdaptExpression EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:288:1: ruleAdaptExpression EOF
            {
             before(grammarAccess.getAdaptExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAdaptExpression_in_entryRuleAdaptExpression543);
            ruleAdaptExpression();

            state._fsp--;

             after(grammarAccess.getAdaptExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAdaptExpression550); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAdaptExpression"


    // $ANTLR start "ruleAdaptExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:295:1: ruleAdaptExpression : ( ( rule__AdaptExpression__Group__0 ) ) ;
    public final void ruleAdaptExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:299:2: ( ( ( rule__AdaptExpression__Group__0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:300:1: ( ( rule__AdaptExpression__Group__0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:300:1: ( ( rule__AdaptExpression__Group__0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:301:1: ( rule__AdaptExpression__Group__0 )
            {
             before(grammarAccess.getAdaptExpressionAccess().getGroup()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:302:1: ( rule__AdaptExpression__Group__0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:302:2: rule__AdaptExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group__0_in_ruleAdaptExpression576);
            rule__AdaptExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAdaptExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdaptExpression"


    // $ANTLR start "entryRuleEqualExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:314:1: entryRuleEqualExpression : ruleEqualExpression EOF ;
    public final void entryRuleEqualExpression() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:315:1: ( ruleEqualExpression EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:316:1: ruleEqualExpression EOF
            {
             before(grammarAccess.getEqualExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEqualExpression_in_entryRuleEqualExpression603);
            ruleEqualExpression();

            state._fsp--;

             after(grammarAccess.getEqualExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEqualExpression610); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEqualExpression"


    // $ANTLR start "ruleEqualExpression"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:323:1: ruleEqualExpression : ( ( rule__EqualExpression__Group__0 ) ) ;
    public final void ruleEqualExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:327:2: ( ( ( rule__EqualExpression__Group__0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:328:1: ( ( rule__EqualExpression__Group__0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:328:1: ( ( rule__EqualExpression__Group__0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:329:1: ( rule__EqualExpression__Group__0 )
            {
             before(grammarAccess.getEqualExpressionAccess().getGroup()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:330:1: ( rule__EqualExpression__Group__0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:330:2: rule__EqualExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EqualExpression__Group__0_in_ruleEqualExpression636);
            rule__EqualExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEqualExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEqualExpression"


    // $ANTLR start "entryRuleOperator"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:342:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:343:1: ( ruleOperator EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:344:1: ruleOperator EOF
            {
             before(grammarAccess.getOperatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_entryRuleOperator663);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getOperatorRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperator670); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:351:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:355:2: ( ( ( rule__Operator__Alternatives ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:356:1: ( ( rule__Operator__Alternatives ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:356:1: ( ( rule__Operator__Alternatives ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:357:1: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:358:1: ( rule__Operator__Alternatives )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:358:2: rule__Operator__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Operator__Alternatives_in_ruleOperator696);
            rule__Operator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleVariable"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:372:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:373:1: ( ruleVariable EOF )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:374:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_entryRuleVariable725);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariable732); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:381:1: ruleVariable : ( ( rule__Variable__Alternatives ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:385:2: ( ( ( rule__Variable__Alternatives ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:386:1: ( ( rule__Variable__Alternatives ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:386:1: ( ( rule__Variable__Alternatives ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:387:1: ( rule__Variable__Alternatives )
            {
             before(grammarAccess.getVariableAccess().getAlternatives()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:388:1: ( rule__Variable__Alternatives )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:388:2: rule__Variable__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__Alternatives_in_ruleVariable758);
            rule__Variable__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "rule__Expression__Alternatives"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:400:1: rule__Expression__Alternatives : ( ( ruleInstanceExpression ) | ( ruleAndExpression ) | ( ruleOrExpresison ) | ( ruleNotExpression ) | ( ruleIterableExpression ) | ( ruleWithExpression ) | ( ruleAdaptExpression ) | ( ruleEqualExpression ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:404:1: ( ( ruleInstanceExpression ) | ( ruleAndExpression ) | ( ruleOrExpresison ) | ( ruleNotExpression ) | ( ruleIterableExpression ) | ( ruleWithExpression ) | ( ruleAdaptExpression ) | ( ruleEqualExpression ) )
            int alt1=8;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt1=1;
                }
                break;
            case 22:
                {
                alt1=2;
                }
                break;
            case 26:
                {
                alt1=3;
                }
                break;
            case 27:
                {
                alt1=4;
                }
                break;
            case 28:
            case 32:
                {
                alt1=5;
                }
                break;
            case 29:
                {
                alt1=6;
                }
                break;
            case 30:
                {
                alt1=7;
                }
                break;
            case 31:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:405:1: ( ruleInstanceExpression )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:405:1: ( ruleInstanceExpression )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:406:1: ruleInstanceExpression
                    {
                     before(grammarAccess.getExpressionAccess().getInstanceExpressionParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleInstanceExpression_in_rule__Expression__Alternatives794);
                    ruleInstanceExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getInstanceExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:411:6: ( ruleAndExpression )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:411:6: ( ruleAndExpression )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:412:1: ruleAndExpression
                    {
                     before(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAndExpression_in_rule__Expression__Alternatives811);
                    ruleAndExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:417:6: ( ruleOrExpresison )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:417:6: ( ruleOrExpresison )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:418:1: ruleOrExpresison
                    {
                     before(grammarAccess.getExpressionAccess().getOrExpresisonParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleOrExpresison_in_rule__Expression__Alternatives828);
                    ruleOrExpresison();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getOrExpresisonParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:423:6: ( ruleNotExpression )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:423:6: ( ruleNotExpression )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:424:1: ruleNotExpression
                    {
                     before(grammarAccess.getExpressionAccess().getNotExpressionParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleNotExpression_in_rule__Expression__Alternatives845);
                    ruleNotExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getNotExpressionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:429:6: ( ruleIterableExpression )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:429:6: ( ruleIterableExpression )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:430:1: ruleIterableExpression
                    {
                     before(grammarAccess.getExpressionAccess().getIterableExpressionParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_ruleIterableExpression_in_rule__Expression__Alternatives862);
                    ruleIterableExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getIterableExpressionParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:435:6: ( ruleWithExpression )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:435:6: ( ruleWithExpression )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:436:1: ruleWithExpression
                    {
                     before(grammarAccess.getExpressionAccess().getWithExpressionParserRuleCall_5()); 
                    pushFollow(FollowSets000.FOLLOW_ruleWithExpression_in_rule__Expression__Alternatives879);
                    ruleWithExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getWithExpressionParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:441:6: ( ruleAdaptExpression )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:441:6: ( ruleAdaptExpression )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:442:1: ruleAdaptExpression
                    {
                     before(grammarAccess.getExpressionAccess().getAdaptExpressionParserRuleCall_6()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAdaptExpression_in_rule__Expression__Alternatives896);
                    ruleAdaptExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getAdaptExpressionParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:447:6: ( ruleEqualExpression )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:447:6: ( ruleEqualExpression )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:448:1: ruleEqualExpression
                    {
                     before(grammarAccess.getExpressionAccess().getEqualExpressionParserRuleCall_7()); 
                    pushFollow(FollowSets000.FOLLOW_ruleEqualExpression_in_rule__Expression__Alternatives913);
                    ruleEqualExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getEqualExpressionParserRuleCall_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Alternatives"


    // $ANTLR start "rule__Operator__Alternatives"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:459:1: rule__Operator__Alternatives : ( ( 'and' ) | ( 'or' ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:463:1: ( ( 'and' ) | ( 'or' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:464:1: ( 'and' )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:464:1: ( 'and' )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:465:1: 'and'
                    {
                     before(grammarAccess.getOperatorAccess().getAndKeyword_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Operator__Alternatives947); 
                     after(grammarAccess.getOperatorAccess().getAndKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:472:6: ( 'or' )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:472:6: ( 'or' )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:473:1: 'or'
                    {
                     before(grammarAccess.getOperatorAccess().getOrKeyword_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Operator__Alternatives967); 
                     after(grammarAccess.getOperatorAccess().getOrKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__Alternatives"


    // $ANTLR start "rule__Variable__Alternatives"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:486:1: rule__Variable__Alternatives : ( ( 'activeContexts' ) | ( 'activeEditor' ) | ( 'activeEditorId' ) | ( 'activePartId' ) | ( 'activeSite' ) | ( 'selection' ) );
    public final void rule__Variable__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:490:1: ( ( 'activeContexts' ) | ( 'activeEditor' ) | ( 'activeEditorId' ) | ( 'activePartId' ) | ( 'activeSite' ) | ( 'selection' ) )
            int alt3=6;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 14:
                {
                alt3=2;
                }
                break;
            case 15:
                {
                alt3=3;
                }
                break;
            case 16:
                {
                alt3=4;
                }
                break;
            case 17:
                {
                alt3=5;
                }
                break;
            case 18:
                {
                alt3=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:491:1: ( 'activeContexts' )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:491:1: ( 'activeContexts' )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:492:1: 'activeContexts'
                    {
                     before(grammarAccess.getVariableAccess().getActiveContextsKeyword_0()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__Variable__Alternatives1003); 
                     after(grammarAccess.getVariableAccess().getActiveContextsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:499:6: ( 'activeEditor' )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:499:6: ( 'activeEditor' )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:500:1: 'activeEditor'
                    {
                     before(grammarAccess.getVariableAccess().getActiveEditorKeyword_1()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Variable__Alternatives1023); 
                     after(grammarAccess.getVariableAccess().getActiveEditorKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:507:6: ( 'activeEditorId' )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:507:6: ( 'activeEditorId' )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:508:1: 'activeEditorId'
                    {
                     before(grammarAccess.getVariableAccess().getActiveEditorIdKeyword_2()); 
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Variable__Alternatives1043); 
                     after(grammarAccess.getVariableAccess().getActiveEditorIdKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:515:6: ( 'activePartId' )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:515:6: ( 'activePartId' )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:516:1: 'activePartId'
                    {
                     before(grammarAccess.getVariableAccess().getActivePartIdKeyword_3()); 
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__Variable__Alternatives1063); 
                     after(grammarAccess.getVariableAccess().getActivePartIdKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:523:6: ( 'activeSite' )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:523:6: ( 'activeSite' )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:524:1: 'activeSite'
                    {
                     before(grammarAccess.getVariableAccess().getActiveSiteKeyword_4()); 
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__Variable__Alternatives1083); 
                     after(grammarAccess.getVariableAccess().getActiveSiteKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:531:6: ( 'selection' )
                    {
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:531:6: ( 'selection' )
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:532:1: 'selection'
                    {
                     before(grammarAccess.getVariableAccess().getSelectionKeyword_5()); 
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__Variable__Alternatives1103); 
                     after(grammarAccess.getVariableAccess().getSelectionKeyword_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Alternatives"


    // $ANTLR start "rule__Root__Group__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:546:1: rule__Root__Group__0 : rule__Root__Group__0__Impl rule__Root__Group__1 ;
    public final void rule__Root__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:550:1: ( rule__Root__Group__0__Impl rule__Root__Group__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:551:2: rule__Root__Group__0__Impl rule__Root__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__0__Impl_in_rule__Root__Group__01135);
            rule__Root__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__1_in_rule__Root__Group__01138);
            rule__Root__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__0"


    // $ANTLR start "rule__Root__Group__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:558:1: rule__Root__Group__0__Impl : ( '[' ) ;
    public final void rule__Root__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:562:1: ( ( '[' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:563:1: ( '[' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:563:1: ( '[' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:564:1: '['
            {
             before(grammarAccess.getRootAccess().getLeftSquareBracketKeyword_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Root__Group__0__Impl1166); 
             after(grammarAccess.getRootAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__0__Impl"


    // $ANTLR start "rule__Root__Group__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:577:1: rule__Root__Group__1 : rule__Root__Group__1__Impl rule__Root__Group__2 ;
    public final void rule__Root__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:581:1: ( rule__Root__Group__1__Impl rule__Root__Group__2 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:582:2: rule__Root__Group__1__Impl rule__Root__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__1__Impl_in_rule__Root__Group__11197);
            rule__Root__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__2_in_rule__Root__Group__11200);
            rule__Root__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__1"


    // $ANTLR start "rule__Root__Group__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:589:1: rule__Root__Group__1__Impl : ( ( rule__Root__ExpressionAssignment_1 ) ) ;
    public final void rule__Root__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:593:1: ( ( ( rule__Root__ExpressionAssignment_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:594:1: ( ( rule__Root__ExpressionAssignment_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:594:1: ( ( rule__Root__ExpressionAssignment_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:595:1: ( rule__Root__ExpressionAssignment_1 )
            {
             before(grammarAccess.getRootAccess().getExpressionAssignment_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:596:1: ( rule__Root__ExpressionAssignment_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:596:2: rule__Root__ExpressionAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__ExpressionAssignment_1_in_rule__Root__Group__1__Impl1227);
            rule__Root__ExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRootAccess().getExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__1__Impl"


    // $ANTLR start "rule__Root__Group__2"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:606:1: rule__Root__Group__2 : rule__Root__Group__2__Impl ;
    public final void rule__Root__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:610:1: ( rule__Root__Group__2__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:611:2: rule__Root__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Root__Group__2__Impl_in_rule__Root__Group__21257);
            rule__Root__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__2"


    // $ANTLR start "rule__Root__Group__2__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:617:1: rule__Root__Group__2__Impl : ( ']' ) ;
    public final void rule__Root__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:621:1: ( ( ']' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:622:1: ( ']' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:622:1: ( ']' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:623:1: ']'
            {
             before(grammarAccess.getRootAccess().getRightSquareBracketKeyword_2()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Root__Group__2__Impl1285); 
             after(grammarAccess.getRootAccess().getRightSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__Group__2__Impl"


    // $ANTLR start "rule__InstanceExpression__Group__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:642:1: rule__InstanceExpression__Group__0 : rule__InstanceExpression__Group__0__Impl rule__InstanceExpression__Group__1 ;
    public final void rule__InstanceExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:646:1: ( rule__InstanceExpression__Group__0__Impl rule__InstanceExpression__Group__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:647:2: rule__InstanceExpression__Group__0__Impl rule__InstanceExpression__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__InstanceExpression__Group__0__Impl_in_rule__InstanceExpression__Group__01322);
            rule__InstanceExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InstanceExpression__Group__1_in_rule__InstanceExpression__Group__01325);
            rule__InstanceExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceExpression__Group__0"


    // $ANTLR start "rule__InstanceExpression__Group__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:654:1: rule__InstanceExpression__Group__0__Impl : ( 'InstanceOf' ) ;
    public final void rule__InstanceExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:658:1: ( ( 'InstanceOf' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:659:1: ( 'InstanceOf' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:659:1: ( 'InstanceOf' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:660:1: 'InstanceOf'
            {
             before(grammarAccess.getInstanceExpressionAccess().getInstanceOfKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__InstanceExpression__Group__0__Impl1353); 
             after(grammarAccess.getInstanceExpressionAccess().getInstanceOfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceExpression__Group__0__Impl"


    // $ANTLR start "rule__InstanceExpression__Group__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:673:1: rule__InstanceExpression__Group__1 : rule__InstanceExpression__Group__1__Impl ;
    public final void rule__InstanceExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:677:1: ( rule__InstanceExpression__Group__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:678:2: rule__InstanceExpression__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__InstanceExpression__Group__1__Impl_in_rule__InstanceExpression__Group__11384);
            rule__InstanceExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceExpression__Group__1"


    // $ANTLR start "rule__InstanceExpression__Group__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:684:1: rule__InstanceExpression__Group__1__Impl : ( ( rule__InstanceExpression__ValueAssignment_1 ) ) ;
    public final void rule__InstanceExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:688:1: ( ( ( rule__InstanceExpression__ValueAssignment_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:689:1: ( ( rule__InstanceExpression__ValueAssignment_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:689:1: ( ( rule__InstanceExpression__ValueAssignment_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:690:1: ( rule__InstanceExpression__ValueAssignment_1 )
            {
             before(grammarAccess.getInstanceExpressionAccess().getValueAssignment_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:691:1: ( rule__InstanceExpression__ValueAssignment_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:691:2: rule__InstanceExpression__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__InstanceExpression__ValueAssignment_1_in_rule__InstanceExpression__Group__1__Impl1411);
            rule__InstanceExpression__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getInstanceExpressionAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceExpression__Group__1__Impl"


    // $ANTLR start "rule__AndExpression__Group__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:705:1: rule__AndExpression__Group__0 : rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 ;
    public final void rule__AndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:709:1: ( rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:710:2: rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group__0__Impl_in_rule__AndExpression__Group__01445);
            rule__AndExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group__1_in_rule__AndExpression__Group__01448);
            rule__AndExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0"


    // $ANTLR start "rule__AndExpression__Group__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:717:1: rule__AndExpression__Group__0__Impl : ( () ) ;
    public final void rule__AndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:721:1: ( ( () ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:722:1: ( () )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:722:1: ( () )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:723:1: ()
            {
             before(grammarAccess.getAndExpressionAccess().getAndExpressionAction_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:724:1: ()
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:726:1: 
            {
            }

             after(grammarAccess.getAndExpressionAccess().getAndExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0__Impl"


    // $ANTLR start "rule__AndExpression__Group__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:736:1: rule__AndExpression__Group__1 : rule__AndExpression__Group__1__Impl rule__AndExpression__Group__2 ;
    public final void rule__AndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:740:1: ( rule__AndExpression__Group__1__Impl rule__AndExpression__Group__2 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:741:2: rule__AndExpression__Group__1__Impl rule__AndExpression__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group__1__Impl_in_rule__AndExpression__Group__11506);
            rule__AndExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group__2_in_rule__AndExpression__Group__11509);
            rule__AndExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1"


    // $ANTLR start "rule__AndExpression__Group__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:748:1: rule__AndExpression__Group__1__Impl : ( 'And' ) ;
    public final void rule__AndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:752:1: ( ( 'And' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:753:1: ( 'And' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:753:1: ( 'And' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:754:1: 'And'
            {
             before(grammarAccess.getAndExpressionAccess().getAndKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__AndExpression__Group__1__Impl1537); 
             after(grammarAccess.getAndExpressionAccess().getAndKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1__Impl"


    // $ANTLR start "rule__AndExpression__Group__2"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:767:1: rule__AndExpression__Group__2 : rule__AndExpression__Group__2__Impl rule__AndExpression__Group__3 ;
    public final void rule__AndExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:771:1: ( rule__AndExpression__Group__2__Impl rule__AndExpression__Group__3 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:772:2: rule__AndExpression__Group__2__Impl rule__AndExpression__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group__2__Impl_in_rule__AndExpression__Group__21568);
            rule__AndExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group__3_in_rule__AndExpression__Group__21571);
            rule__AndExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__2"


    // $ANTLR start "rule__AndExpression__Group__2__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:779:1: rule__AndExpression__Group__2__Impl : ( '{' ) ;
    public final void rule__AndExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:783:1: ( ( '{' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:784:1: ( '{' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:784:1: ( '{' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:785:1: '{'
            {
             before(grammarAccess.getAndExpressionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__AndExpression__Group__2__Impl1599); 
             after(grammarAccess.getAndExpressionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__2__Impl"


    // $ANTLR start "rule__AndExpression__Group__3"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:798:1: rule__AndExpression__Group__3 : rule__AndExpression__Group__3__Impl rule__AndExpression__Group__4 ;
    public final void rule__AndExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:802:1: ( rule__AndExpression__Group__3__Impl rule__AndExpression__Group__4 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:803:2: rule__AndExpression__Group__3__Impl rule__AndExpression__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group__3__Impl_in_rule__AndExpression__Group__31630);
            rule__AndExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group__4_in_rule__AndExpression__Group__31633);
            rule__AndExpression__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__3"


    // $ANTLR start "rule__AndExpression__Group__3__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:810:1: rule__AndExpression__Group__3__Impl : ( ( rule__AndExpression__Group_3__0 )? ) ;
    public final void rule__AndExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:814:1: ( ( ( rule__AndExpression__Group_3__0 )? ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:815:1: ( ( rule__AndExpression__Group_3__0 )? )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:815:1: ( ( rule__AndExpression__Group_3__0 )? )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:816:1: ( rule__AndExpression__Group_3__0 )?
            {
             before(grammarAccess.getAndExpressionAccess().getGroup_3()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:817:1: ( rule__AndExpression__Group_3__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=21 && LA4_0<=22)||(LA4_0>=26 && LA4_0<=32)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:817:2: rule__AndExpression__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group_3__0_in_rule__AndExpression__Group__3__Impl1660);
                    rule__AndExpression__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAndExpressionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__3__Impl"


    // $ANTLR start "rule__AndExpression__Group__4"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:827:1: rule__AndExpression__Group__4 : rule__AndExpression__Group__4__Impl ;
    public final void rule__AndExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:831:1: ( rule__AndExpression__Group__4__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:832:2: rule__AndExpression__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group__4__Impl_in_rule__AndExpression__Group__41691);
            rule__AndExpression__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__4"


    // $ANTLR start "rule__AndExpression__Group__4__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:838:1: rule__AndExpression__Group__4__Impl : ( '}' ) ;
    public final void rule__AndExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:842:1: ( ( '}' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:843:1: ( '}' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:843:1: ( '}' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:844:1: '}'
            {
             before(grammarAccess.getAndExpressionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__AndExpression__Group__4__Impl1719); 
             after(grammarAccess.getAndExpressionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__4__Impl"


    // $ANTLR start "rule__AndExpression__Group_3__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:867:1: rule__AndExpression__Group_3__0 : rule__AndExpression__Group_3__0__Impl rule__AndExpression__Group_3__1 ;
    public final void rule__AndExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:871:1: ( rule__AndExpression__Group_3__0__Impl rule__AndExpression__Group_3__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:872:2: rule__AndExpression__Group_3__0__Impl rule__AndExpression__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group_3__0__Impl_in_rule__AndExpression__Group_3__01760);
            rule__AndExpression__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group_3__1_in_rule__AndExpression__Group_3__01763);
            rule__AndExpression__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_3__0"


    // $ANTLR start "rule__AndExpression__Group_3__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:879:1: rule__AndExpression__Group_3__0__Impl : ( ( rule__AndExpression__ExpressionsAssignment_3_0 ) ) ;
    public final void rule__AndExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:883:1: ( ( ( rule__AndExpression__ExpressionsAssignment_3_0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:884:1: ( ( rule__AndExpression__ExpressionsAssignment_3_0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:884:1: ( ( rule__AndExpression__ExpressionsAssignment_3_0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:885:1: ( rule__AndExpression__ExpressionsAssignment_3_0 )
            {
             before(grammarAccess.getAndExpressionAccess().getExpressionsAssignment_3_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:886:1: ( rule__AndExpression__ExpressionsAssignment_3_0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:886:2: rule__AndExpression__ExpressionsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__ExpressionsAssignment_3_0_in_rule__AndExpression__Group_3__0__Impl1790);
            rule__AndExpression__ExpressionsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getExpressionsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_3__0__Impl"


    // $ANTLR start "rule__AndExpression__Group_3__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:896:1: rule__AndExpression__Group_3__1 : rule__AndExpression__Group_3__1__Impl ;
    public final void rule__AndExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:900:1: ( rule__AndExpression__Group_3__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:901:2: rule__AndExpression__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group_3__1__Impl_in_rule__AndExpression__Group_3__11820);
            rule__AndExpression__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_3__1"


    // $ANTLR start "rule__AndExpression__Group_3__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:907:1: rule__AndExpression__Group_3__1__Impl : ( ( rule__AndExpression__Group_3_1__0 )* ) ;
    public final void rule__AndExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:911:1: ( ( ( rule__AndExpression__Group_3_1__0 )* ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:912:1: ( ( rule__AndExpression__Group_3_1__0 )* )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:912:1: ( ( rule__AndExpression__Group_3_1__0 )* )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:913:1: ( rule__AndExpression__Group_3_1__0 )*
            {
             before(grammarAccess.getAndExpressionAccess().getGroup_3_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:914:1: ( rule__AndExpression__Group_3_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==25) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:914:2: rule__AndExpression__Group_3_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group_3_1__0_in_rule__AndExpression__Group_3__1__Impl1847);
            	    rule__AndExpression__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getAndExpressionAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_3__1__Impl"


    // $ANTLR start "rule__AndExpression__Group_3_1__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:928:1: rule__AndExpression__Group_3_1__0 : rule__AndExpression__Group_3_1__0__Impl rule__AndExpression__Group_3_1__1 ;
    public final void rule__AndExpression__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:932:1: ( rule__AndExpression__Group_3_1__0__Impl rule__AndExpression__Group_3_1__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:933:2: rule__AndExpression__Group_3_1__0__Impl rule__AndExpression__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group_3_1__0__Impl_in_rule__AndExpression__Group_3_1__01882);
            rule__AndExpression__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group_3_1__1_in_rule__AndExpression__Group_3_1__01885);
            rule__AndExpression__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_3_1__0"


    // $ANTLR start "rule__AndExpression__Group_3_1__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:940:1: rule__AndExpression__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__AndExpression__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:944:1: ( ( ',' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:945:1: ( ',' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:945:1: ( ',' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:946:1: ','
            {
             before(grammarAccess.getAndExpressionAccess().getCommaKeyword_3_1_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__AndExpression__Group_3_1__0__Impl1913); 
             after(grammarAccess.getAndExpressionAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_3_1__0__Impl"


    // $ANTLR start "rule__AndExpression__Group_3_1__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:959:1: rule__AndExpression__Group_3_1__1 : rule__AndExpression__Group_3_1__1__Impl ;
    public final void rule__AndExpression__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:963:1: ( rule__AndExpression__Group_3_1__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:964:2: rule__AndExpression__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__Group_3_1__1__Impl_in_rule__AndExpression__Group_3_1__11944);
            rule__AndExpression__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_3_1__1"


    // $ANTLR start "rule__AndExpression__Group_3_1__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:970:1: rule__AndExpression__Group_3_1__1__Impl : ( ( rule__AndExpression__ExpressionsAssignment_3_1_1 ) ) ;
    public final void rule__AndExpression__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:974:1: ( ( ( rule__AndExpression__ExpressionsAssignment_3_1_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:975:1: ( ( rule__AndExpression__ExpressionsAssignment_3_1_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:975:1: ( ( rule__AndExpression__ExpressionsAssignment_3_1_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:976:1: ( rule__AndExpression__ExpressionsAssignment_3_1_1 )
            {
             before(grammarAccess.getAndExpressionAccess().getExpressionsAssignment_3_1_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:977:1: ( rule__AndExpression__ExpressionsAssignment_3_1_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:977:2: rule__AndExpression__ExpressionsAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AndExpression__ExpressionsAssignment_3_1_1_in_rule__AndExpression__Group_3_1__1__Impl1971);
            rule__AndExpression__ExpressionsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getExpressionsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_3_1__1__Impl"


    // $ANTLR start "rule__OrExpresison__Group__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:991:1: rule__OrExpresison__Group__0 : rule__OrExpresison__Group__0__Impl rule__OrExpresison__Group__1 ;
    public final void rule__OrExpresison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:995:1: ( rule__OrExpresison__Group__0__Impl rule__OrExpresison__Group__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:996:2: rule__OrExpresison__Group__0__Impl rule__OrExpresison__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group__0__Impl_in_rule__OrExpresison__Group__02005);
            rule__OrExpresison__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group__1_in_rule__OrExpresison__Group__02008);
            rule__OrExpresison__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group__0"


    // $ANTLR start "rule__OrExpresison__Group__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1003:1: rule__OrExpresison__Group__0__Impl : ( () ) ;
    public final void rule__OrExpresison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1007:1: ( ( () ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1008:1: ( () )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1008:1: ( () )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1009:1: ()
            {
             before(grammarAccess.getOrExpresisonAccess().getOrExpresisonAction_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1010:1: ()
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1012:1: 
            {
            }

             after(grammarAccess.getOrExpresisonAccess().getOrExpresisonAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group__0__Impl"


    // $ANTLR start "rule__OrExpresison__Group__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1022:1: rule__OrExpresison__Group__1 : rule__OrExpresison__Group__1__Impl rule__OrExpresison__Group__2 ;
    public final void rule__OrExpresison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1026:1: ( rule__OrExpresison__Group__1__Impl rule__OrExpresison__Group__2 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1027:2: rule__OrExpresison__Group__1__Impl rule__OrExpresison__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group__1__Impl_in_rule__OrExpresison__Group__12066);
            rule__OrExpresison__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group__2_in_rule__OrExpresison__Group__12069);
            rule__OrExpresison__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group__1"


    // $ANTLR start "rule__OrExpresison__Group__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1034:1: rule__OrExpresison__Group__1__Impl : ( 'Or' ) ;
    public final void rule__OrExpresison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1038:1: ( ( 'Or' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1039:1: ( 'Or' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1039:1: ( 'Or' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1040:1: 'Or'
            {
             before(grammarAccess.getOrExpresisonAccess().getOrKeyword_1()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__OrExpresison__Group__1__Impl2097); 
             after(grammarAccess.getOrExpresisonAccess().getOrKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group__1__Impl"


    // $ANTLR start "rule__OrExpresison__Group__2"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1053:1: rule__OrExpresison__Group__2 : rule__OrExpresison__Group__2__Impl rule__OrExpresison__Group__3 ;
    public final void rule__OrExpresison__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1057:1: ( rule__OrExpresison__Group__2__Impl rule__OrExpresison__Group__3 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1058:2: rule__OrExpresison__Group__2__Impl rule__OrExpresison__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group__2__Impl_in_rule__OrExpresison__Group__22128);
            rule__OrExpresison__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group__3_in_rule__OrExpresison__Group__22131);
            rule__OrExpresison__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group__2"


    // $ANTLR start "rule__OrExpresison__Group__2__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1065:1: rule__OrExpresison__Group__2__Impl : ( '{' ) ;
    public final void rule__OrExpresison__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1069:1: ( ( '{' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1070:1: ( '{' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1070:1: ( '{' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1071:1: '{'
            {
             before(grammarAccess.getOrExpresisonAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__OrExpresison__Group__2__Impl2159); 
             after(grammarAccess.getOrExpresisonAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group__2__Impl"


    // $ANTLR start "rule__OrExpresison__Group__3"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1084:1: rule__OrExpresison__Group__3 : rule__OrExpresison__Group__3__Impl rule__OrExpresison__Group__4 ;
    public final void rule__OrExpresison__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1088:1: ( rule__OrExpresison__Group__3__Impl rule__OrExpresison__Group__4 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1089:2: rule__OrExpresison__Group__3__Impl rule__OrExpresison__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group__3__Impl_in_rule__OrExpresison__Group__32190);
            rule__OrExpresison__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group__4_in_rule__OrExpresison__Group__32193);
            rule__OrExpresison__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group__3"


    // $ANTLR start "rule__OrExpresison__Group__3__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1096:1: rule__OrExpresison__Group__3__Impl : ( ( rule__OrExpresison__Group_3__0 )? ) ;
    public final void rule__OrExpresison__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1100:1: ( ( ( rule__OrExpresison__Group_3__0 )? ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1101:1: ( ( rule__OrExpresison__Group_3__0 )? )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1101:1: ( ( rule__OrExpresison__Group_3__0 )? )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1102:1: ( rule__OrExpresison__Group_3__0 )?
            {
             before(grammarAccess.getOrExpresisonAccess().getGroup_3()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1103:1: ( rule__OrExpresison__Group_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=21 && LA6_0<=22)||(LA6_0>=26 && LA6_0<=32)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1103:2: rule__OrExpresison__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group_3__0_in_rule__OrExpresison__Group__3__Impl2220);
                    rule__OrExpresison__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOrExpresisonAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group__3__Impl"


    // $ANTLR start "rule__OrExpresison__Group__4"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1113:1: rule__OrExpresison__Group__4 : rule__OrExpresison__Group__4__Impl ;
    public final void rule__OrExpresison__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1117:1: ( rule__OrExpresison__Group__4__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1118:2: rule__OrExpresison__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group__4__Impl_in_rule__OrExpresison__Group__42251);
            rule__OrExpresison__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group__4"


    // $ANTLR start "rule__OrExpresison__Group__4__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1124:1: rule__OrExpresison__Group__4__Impl : ( '}' ) ;
    public final void rule__OrExpresison__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1128:1: ( ( '}' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1129:1: ( '}' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1129:1: ( '}' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1130:1: '}'
            {
             before(grammarAccess.getOrExpresisonAccess().getRightCurlyBracketKeyword_4()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__OrExpresison__Group__4__Impl2279); 
             after(grammarAccess.getOrExpresisonAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group__4__Impl"


    // $ANTLR start "rule__OrExpresison__Group_3__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1153:1: rule__OrExpresison__Group_3__0 : rule__OrExpresison__Group_3__0__Impl rule__OrExpresison__Group_3__1 ;
    public final void rule__OrExpresison__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1157:1: ( rule__OrExpresison__Group_3__0__Impl rule__OrExpresison__Group_3__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1158:2: rule__OrExpresison__Group_3__0__Impl rule__OrExpresison__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group_3__0__Impl_in_rule__OrExpresison__Group_3__02320);
            rule__OrExpresison__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group_3__1_in_rule__OrExpresison__Group_3__02323);
            rule__OrExpresison__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group_3__0"


    // $ANTLR start "rule__OrExpresison__Group_3__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1165:1: rule__OrExpresison__Group_3__0__Impl : ( ( rule__OrExpresison__ExpressionsAssignment_3_0 ) ) ;
    public final void rule__OrExpresison__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1169:1: ( ( ( rule__OrExpresison__ExpressionsAssignment_3_0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1170:1: ( ( rule__OrExpresison__ExpressionsAssignment_3_0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1170:1: ( ( rule__OrExpresison__ExpressionsAssignment_3_0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1171:1: ( rule__OrExpresison__ExpressionsAssignment_3_0 )
            {
             before(grammarAccess.getOrExpresisonAccess().getExpressionsAssignment_3_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1172:1: ( rule__OrExpresison__ExpressionsAssignment_3_0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1172:2: rule__OrExpresison__ExpressionsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__ExpressionsAssignment_3_0_in_rule__OrExpresison__Group_3__0__Impl2350);
            rule__OrExpresison__ExpressionsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getOrExpresisonAccess().getExpressionsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group_3__0__Impl"


    // $ANTLR start "rule__OrExpresison__Group_3__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1182:1: rule__OrExpresison__Group_3__1 : rule__OrExpresison__Group_3__1__Impl ;
    public final void rule__OrExpresison__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1186:1: ( rule__OrExpresison__Group_3__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1187:2: rule__OrExpresison__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group_3__1__Impl_in_rule__OrExpresison__Group_3__12380);
            rule__OrExpresison__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group_3__1"


    // $ANTLR start "rule__OrExpresison__Group_3__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1193:1: rule__OrExpresison__Group_3__1__Impl : ( ( rule__OrExpresison__Group_3_1__0 )* ) ;
    public final void rule__OrExpresison__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1197:1: ( ( ( rule__OrExpresison__Group_3_1__0 )* ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1198:1: ( ( rule__OrExpresison__Group_3_1__0 )* )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1198:1: ( ( rule__OrExpresison__Group_3_1__0 )* )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1199:1: ( rule__OrExpresison__Group_3_1__0 )*
            {
             before(grammarAccess.getOrExpresisonAccess().getGroup_3_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1200:1: ( rule__OrExpresison__Group_3_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1200:2: rule__OrExpresison__Group_3_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group_3_1__0_in_rule__OrExpresison__Group_3__1__Impl2407);
            	    rule__OrExpresison__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getOrExpresisonAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group_3__1__Impl"


    // $ANTLR start "rule__OrExpresison__Group_3_1__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1214:1: rule__OrExpresison__Group_3_1__0 : rule__OrExpresison__Group_3_1__0__Impl rule__OrExpresison__Group_3_1__1 ;
    public final void rule__OrExpresison__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1218:1: ( rule__OrExpresison__Group_3_1__0__Impl rule__OrExpresison__Group_3_1__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1219:2: rule__OrExpresison__Group_3_1__0__Impl rule__OrExpresison__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group_3_1__0__Impl_in_rule__OrExpresison__Group_3_1__02442);
            rule__OrExpresison__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group_3_1__1_in_rule__OrExpresison__Group_3_1__02445);
            rule__OrExpresison__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group_3_1__0"


    // $ANTLR start "rule__OrExpresison__Group_3_1__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1226:1: rule__OrExpresison__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__OrExpresison__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1230:1: ( ( ',' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1231:1: ( ',' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1231:1: ( ',' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1232:1: ','
            {
             before(grammarAccess.getOrExpresisonAccess().getCommaKeyword_3_1_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__OrExpresison__Group_3_1__0__Impl2473); 
             after(grammarAccess.getOrExpresisonAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group_3_1__0__Impl"


    // $ANTLR start "rule__OrExpresison__Group_3_1__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1245:1: rule__OrExpresison__Group_3_1__1 : rule__OrExpresison__Group_3_1__1__Impl ;
    public final void rule__OrExpresison__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1249:1: ( rule__OrExpresison__Group_3_1__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1250:2: rule__OrExpresison__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__Group_3_1__1__Impl_in_rule__OrExpresison__Group_3_1__12504);
            rule__OrExpresison__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group_3_1__1"


    // $ANTLR start "rule__OrExpresison__Group_3_1__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1256:1: rule__OrExpresison__Group_3_1__1__Impl : ( ( rule__OrExpresison__ExpressionsAssignment_3_1_1 ) ) ;
    public final void rule__OrExpresison__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1260:1: ( ( ( rule__OrExpresison__ExpressionsAssignment_3_1_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1261:1: ( ( rule__OrExpresison__ExpressionsAssignment_3_1_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1261:1: ( ( rule__OrExpresison__ExpressionsAssignment_3_1_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1262:1: ( rule__OrExpresison__ExpressionsAssignment_3_1_1 )
            {
             before(grammarAccess.getOrExpresisonAccess().getExpressionsAssignment_3_1_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1263:1: ( rule__OrExpresison__ExpressionsAssignment_3_1_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1263:2: rule__OrExpresison__ExpressionsAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__OrExpresison__ExpressionsAssignment_3_1_1_in_rule__OrExpresison__Group_3_1__1__Impl2531);
            rule__OrExpresison__ExpressionsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getOrExpresisonAccess().getExpressionsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__Group_3_1__1__Impl"


    // $ANTLR start "rule__NotExpression__Group__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1277:1: rule__NotExpression__Group__0 : rule__NotExpression__Group__0__Impl rule__NotExpression__Group__1 ;
    public final void rule__NotExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1281:1: ( rule__NotExpression__Group__0__Impl rule__NotExpression__Group__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1282:2: rule__NotExpression__Group__0__Impl rule__NotExpression__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group__0__Impl_in_rule__NotExpression__Group__02565);
            rule__NotExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group__1_in_rule__NotExpression__Group__02568);
            rule__NotExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group__0"


    // $ANTLR start "rule__NotExpression__Group__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1289:1: rule__NotExpression__Group__0__Impl : ( () ) ;
    public final void rule__NotExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1293:1: ( ( () ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1294:1: ( () )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1294:1: ( () )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1295:1: ()
            {
             before(grammarAccess.getNotExpressionAccess().getNotExpressionAction_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1296:1: ()
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1298:1: 
            {
            }

             after(grammarAccess.getNotExpressionAccess().getNotExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group__0__Impl"


    // $ANTLR start "rule__NotExpression__Group__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1308:1: rule__NotExpression__Group__1 : rule__NotExpression__Group__1__Impl rule__NotExpression__Group__2 ;
    public final void rule__NotExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1312:1: ( rule__NotExpression__Group__1__Impl rule__NotExpression__Group__2 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1313:2: rule__NotExpression__Group__1__Impl rule__NotExpression__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group__1__Impl_in_rule__NotExpression__Group__12626);
            rule__NotExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group__2_in_rule__NotExpression__Group__12629);
            rule__NotExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group__1"


    // $ANTLR start "rule__NotExpression__Group__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1320:1: rule__NotExpression__Group__1__Impl : ( 'Not' ) ;
    public final void rule__NotExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1324:1: ( ( 'Not' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1325:1: ( 'Not' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1325:1: ( 'Not' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1326:1: 'Not'
            {
             before(grammarAccess.getNotExpressionAccess().getNotKeyword_1()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__NotExpression__Group__1__Impl2657); 
             after(grammarAccess.getNotExpressionAccess().getNotKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group__1__Impl"


    // $ANTLR start "rule__NotExpression__Group__2"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1339:1: rule__NotExpression__Group__2 : rule__NotExpression__Group__2__Impl rule__NotExpression__Group__3 ;
    public final void rule__NotExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1343:1: ( rule__NotExpression__Group__2__Impl rule__NotExpression__Group__3 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1344:2: rule__NotExpression__Group__2__Impl rule__NotExpression__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group__2__Impl_in_rule__NotExpression__Group__22688);
            rule__NotExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group__3_in_rule__NotExpression__Group__22691);
            rule__NotExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group__2"


    // $ANTLR start "rule__NotExpression__Group__2__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1351:1: rule__NotExpression__Group__2__Impl : ( '{' ) ;
    public final void rule__NotExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1355:1: ( ( '{' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1356:1: ( '{' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1356:1: ( '{' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1357:1: '{'
            {
             before(grammarAccess.getNotExpressionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__NotExpression__Group__2__Impl2719); 
             after(grammarAccess.getNotExpressionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group__2__Impl"


    // $ANTLR start "rule__NotExpression__Group__3"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1370:1: rule__NotExpression__Group__3 : rule__NotExpression__Group__3__Impl rule__NotExpression__Group__4 ;
    public final void rule__NotExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1374:1: ( rule__NotExpression__Group__3__Impl rule__NotExpression__Group__4 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1375:2: rule__NotExpression__Group__3__Impl rule__NotExpression__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group__3__Impl_in_rule__NotExpression__Group__32750);
            rule__NotExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group__4_in_rule__NotExpression__Group__32753);
            rule__NotExpression__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group__3"


    // $ANTLR start "rule__NotExpression__Group__3__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1382:1: rule__NotExpression__Group__3__Impl : ( ( rule__NotExpression__Group_3__0 )? ) ;
    public final void rule__NotExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1386:1: ( ( ( rule__NotExpression__Group_3__0 )? ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1387:1: ( ( rule__NotExpression__Group_3__0 )? )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1387:1: ( ( rule__NotExpression__Group_3__0 )? )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1388:1: ( rule__NotExpression__Group_3__0 )?
            {
             before(grammarAccess.getNotExpressionAccess().getGroup_3()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1389:1: ( rule__NotExpression__Group_3__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=21 && LA8_0<=22)||(LA8_0>=26 && LA8_0<=32)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1389:2: rule__NotExpression__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group_3__0_in_rule__NotExpression__Group__3__Impl2780);
                    rule__NotExpression__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNotExpressionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group__3__Impl"


    // $ANTLR start "rule__NotExpression__Group__4"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1399:1: rule__NotExpression__Group__4 : rule__NotExpression__Group__4__Impl ;
    public final void rule__NotExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1403:1: ( rule__NotExpression__Group__4__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1404:2: rule__NotExpression__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group__4__Impl_in_rule__NotExpression__Group__42811);
            rule__NotExpression__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group__4"


    // $ANTLR start "rule__NotExpression__Group__4__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1410:1: rule__NotExpression__Group__4__Impl : ( '}' ) ;
    public final void rule__NotExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1414:1: ( ( '}' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1415:1: ( '}' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1415:1: ( '}' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1416:1: '}'
            {
             before(grammarAccess.getNotExpressionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__NotExpression__Group__4__Impl2839); 
             after(grammarAccess.getNotExpressionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group__4__Impl"


    // $ANTLR start "rule__NotExpression__Group_3__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1439:1: rule__NotExpression__Group_3__0 : rule__NotExpression__Group_3__0__Impl rule__NotExpression__Group_3__1 ;
    public final void rule__NotExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1443:1: ( rule__NotExpression__Group_3__0__Impl rule__NotExpression__Group_3__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1444:2: rule__NotExpression__Group_3__0__Impl rule__NotExpression__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group_3__0__Impl_in_rule__NotExpression__Group_3__02880);
            rule__NotExpression__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group_3__1_in_rule__NotExpression__Group_3__02883);
            rule__NotExpression__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_3__0"


    // $ANTLR start "rule__NotExpression__Group_3__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1451:1: rule__NotExpression__Group_3__0__Impl : ( ( rule__NotExpression__ExpressionsAssignment_3_0 ) ) ;
    public final void rule__NotExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1455:1: ( ( ( rule__NotExpression__ExpressionsAssignment_3_0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1456:1: ( ( rule__NotExpression__ExpressionsAssignment_3_0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1456:1: ( ( rule__NotExpression__ExpressionsAssignment_3_0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1457:1: ( rule__NotExpression__ExpressionsAssignment_3_0 )
            {
             before(grammarAccess.getNotExpressionAccess().getExpressionsAssignment_3_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1458:1: ( rule__NotExpression__ExpressionsAssignment_3_0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1458:2: rule__NotExpression__ExpressionsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__ExpressionsAssignment_3_0_in_rule__NotExpression__Group_3__0__Impl2910);
            rule__NotExpression__ExpressionsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getNotExpressionAccess().getExpressionsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_3__0__Impl"


    // $ANTLR start "rule__NotExpression__Group_3__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1468:1: rule__NotExpression__Group_3__1 : rule__NotExpression__Group_3__1__Impl ;
    public final void rule__NotExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1472:1: ( rule__NotExpression__Group_3__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1473:2: rule__NotExpression__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group_3__1__Impl_in_rule__NotExpression__Group_3__12940);
            rule__NotExpression__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_3__1"


    // $ANTLR start "rule__NotExpression__Group_3__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1479:1: rule__NotExpression__Group_3__1__Impl : ( ( rule__NotExpression__Group_3_1__0 )* ) ;
    public final void rule__NotExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1483:1: ( ( ( rule__NotExpression__Group_3_1__0 )* ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1484:1: ( ( rule__NotExpression__Group_3_1__0 )* )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1484:1: ( ( rule__NotExpression__Group_3_1__0 )* )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1485:1: ( rule__NotExpression__Group_3_1__0 )*
            {
             before(grammarAccess.getNotExpressionAccess().getGroup_3_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1486:1: ( rule__NotExpression__Group_3_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1486:2: rule__NotExpression__Group_3_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group_3_1__0_in_rule__NotExpression__Group_3__1__Impl2967);
            	    rule__NotExpression__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getNotExpressionAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_3__1__Impl"


    // $ANTLR start "rule__NotExpression__Group_3_1__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1500:1: rule__NotExpression__Group_3_1__0 : rule__NotExpression__Group_3_1__0__Impl rule__NotExpression__Group_3_1__1 ;
    public final void rule__NotExpression__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1504:1: ( rule__NotExpression__Group_3_1__0__Impl rule__NotExpression__Group_3_1__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1505:2: rule__NotExpression__Group_3_1__0__Impl rule__NotExpression__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group_3_1__0__Impl_in_rule__NotExpression__Group_3_1__03002);
            rule__NotExpression__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group_3_1__1_in_rule__NotExpression__Group_3_1__03005);
            rule__NotExpression__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_3_1__0"


    // $ANTLR start "rule__NotExpression__Group_3_1__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1512:1: rule__NotExpression__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__NotExpression__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1516:1: ( ( ',' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1517:1: ( ',' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1517:1: ( ',' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1518:1: ','
            {
             before(grammarAccess.getNotExpressionAccess().getCommaKeyword_3_1_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__NotExpression__Group_3_1__0__Impl3033); 
             after(grammarAccess.getNotExpressionAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_3_1__0__Impl"


    // $ANTLR start "rule__NotExpression__Group_3_1__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1531:1: rule__NotExpression__Group_3_1__1 : rule__NotExpression__Group_3_1__1__Impl ;
    public final void rule__NotExpression__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1535:1: ( rule__NotExpression__Group_3_1__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1536:2: rule__NotExpression__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__Group_3_1__1__Impl_in_rule__NotExpression__Group_3_1__13064);
            rule__NotExpression__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_3_1__1"


    // $ANTLR start "rule__NotExpression__Group_3_1__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1542:1: rule__NotExpression__Group_3_1__1__Impl : ( ( rule__NotExpression__ExpressionsAssignment_3_1_1 ) ) ;
    public final void rule__NotExpression__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1546:1: ( ( ( rule__NotExpression__ExpressionsAssignment_3_1_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1547:1: ( ( rule__NotExpression__ExpressionsAssignment_3_1_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1547:1: ( ( rule__NotExpression__ExpressionsAssignment_3_1_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1548:1: ( rule__NotExpression__ExpressionsAssignment_3_1_1 )
            {
             before(grammarAccess.getNotExpressionAccess().getExpressionsAssignment_3_1_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1549:1: ( rule__NotExpression__ExpressionsAssignment_3_1_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1549:2: rule__NotExpression__ExpressionsAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__NotExpression__ExpressionsAssignment_3_1_1_in_rule__NotExpression__Group_3_1__1__Impl3091);
            rule__NotExpression__ExpressionsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNotExpressionAccess().getExpressionsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__Group_3_1__1__Impl"


    // $ANTLR start "rule__IterableExpression__Group__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1563:1: rule__IterableExpression__Group__0 : rule__IterableExpression__Group__0__Impl rule__IterableExpression__Group__1 ;
    public final void rule__IterableExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1567:1: ( rule__IterableExpression__Group__0__Impl rule__IterableExpression__Group__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1568:2: rule__IterableExpression__Group__0__Impl rule__IterableExpression__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__0__Impl_in_rule__IterableExpression__Group__03125);
            rule__IterableExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__1_in_rule__IterableExpression__Group__03128);
            rule__IterableExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__0"


    // $ANTLR start "rule__IterableExpression__Group__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1575:1: rule__IterableExpression__Group__0__Impl : ( () ) ;
    public final void rule__IterableExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1579:1: ( ( () ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1580:1: ( () )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1580:1: ( () )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1581:1: ()
            {
             before(grammarAccess.getIterableExpressionAccess().getIterableExpressionAction_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1582:1: ()
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1584:1: 
            {
            }

             after(grammarAccess.getIterableExpressionAccess().getIterableExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__0__Impl"


    // $ANTLR start "rule__IterableExpression__Group__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1594:1: rule__IterableExpression__Group__1 : rule__IterableExpression__Group__1__Impl rule__IterableExpression__Group__2 ;
    public final void rule__IterableExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1598:1: ( rule__IterableExpression__Group__1__Impl rule__IterableExpression__Group__2 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1599:2: rule__IterableExpression__Group__1__Impl rule__IterableExpression__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__1__Impl_in_rule__IterableExpression__Group__13186);
            rule__IterableExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__2_in_rule__IterableExpression__Group__13189);
            rule__IterableExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__1"


    // $ANTLR start "rule__IterableExpression__Group__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1606:1: rule__IterableExpression__Group__1__Impl : ( ( rule__IterableExpression__IfEmptyAssignment_1 )? ) ;
    public final void rule__IterableExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1610:1: ( ( ( rule__IterableExpression__IfEmptyAssignment_1 )? ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1611:1: ( ( rule__IterableExpression__IfEmptyAssignment_1 )? )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1611:1: ( ( rule__IterableExpression__IfEmptyAssignment_1 )? )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1612:1: ( rule__IterableExpression__IfEmptyAssignment_1 )?
            {
             before(grammarAccess.getIterableExpressionAccess().getIfEmptyAssignment_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1613:1: ( rule__IterableExpression__IfEmptyAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==32) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1613:2: rule__IterableExpression__IfEmptyAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__IfEmptyAssignment_1_in_rule__IterableExpression__Group__1__Impl3216);
                    rule__IterableExpression__IfEmptyAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIterableExpressionAccess().getIfEmptyAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__1__Impl"


    // $ANTLR start "rule__IterableExpression__Group__2"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1623:1: rule__IterableExpression__Group__2 : rule__IterableExpression__Group__2__Impl rule__IterableExpression__Group__3 ;
    public final void rule__IterableExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1627:1: ( rule__IterableExpression__Group__2__Impl rule__IterableExpression__Group__3 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1628:2: rule__IterableExpression__Group__2__Impl rule__IterableExpression__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__2__Impl_in_rule__IterableExpression__Group__23247);
            rule__IterableExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__3_in_rule__IterableExpression__Group__23250);
            rule__IterableExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__2"


    // $ANTLR start "rule__IterableExpression__Group__2__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1635:1: rule__IterableExpression__Group__2__Impl : ( 'Iterable' ) ;
    public final void rule__IterableExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1639:1: ( ( 'Iterable' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1640:1: ( 'Iterable' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1640:1: ( 'Iterable' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1641:1: 'Iterable'
            {
             before(grammarAccess.getIterableExpressionAccess().getIterableKeyword_2()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__IterableExpression__Group__2__Impl3278); 
             after(grammarAccess.getIterableExpressionAccess().getIterableKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__2__Impl"


    // $ANTLR start "rule__IterableExpression__Group__3"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1654:1: rule__IterableExpression__Group__3 : rule__IterableExpression__Group__3__Impl rule__IterableExpression__Group__4 ;
    public final void rule__IterableExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1658:1: ( rule__IterableExpression__Group__3__Impl rule__IterableExpression__Group__4 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1659:2: rule__IterableExpression__Group__3__Impl rule__IterableExpression__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__3__Impl_in_rule__IterableExpression__Group__33309);
            rule__IterableExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__4_in_rule__IterableExpression__Group__33312);
            rule__IterableExpression__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__3"


    // $ANTLR start "rule__IterableExpression__Group__3__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1666:1: rule__IterableExpression__Group__3__Impl : ( ( rule__IterableExpression__OperandAssignment_3 )? ) ;
    public final void rule__IterableExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1670:1: ( ( ( rule__IterableExpression__OperandAssignment_3 )? ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1671:1: ( ( rule__IterableExpression__OperandAssignment_3 )? )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1671:1: ( ( rule__IterableExpression__OperandAssignment_3 )? )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1672:1: ( rule__IterableExpression__OperandAssignment_3 )?
            {
             before(grammarAccess.getIterableExpressionAccess().getOperandAssignment_3()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1673:1: ( rule__IterableExpression__OperandAssignment_3 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=11 && LA11_0<=12)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1673:2: rule__IterableExpression__OperandAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__OperandAssignment_3_in_rule__IterableExpression__Group__3__Impl3339);
                    rule__IterableExpression__OperandAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIterableExpressionAccess().getOperandAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__3__Impl"


    // $ANTLR start "rule__IterableExpression__Group__4"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1683:1: rule__IterableExpression__Group__4 : rule__IterableExpression__Group__4__Impl rule__IterableExpression__Group__5 ;
    public final void rule__IterableExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1687:1: ( rule__IterableExpression__Group__4__Impl rule__IterableExpression__Group__5 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1688:2: rule__IterableExpression__Group__4__Impl rule__IterableExpression__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__4__Impl_in_rule__IterableExpression__Group__43370);
            rule__IterableExpression__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__5_in_rule__IterableExpression__Group__43373);
            rule__IterableExpression__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__4"


    // $ANTLR start "rule__IterableExpression__Group__4__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1695:1: rule__IterableExpression__Group__4__Impl : ( '{' ) ;
    public final void rule__IterableExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1699:1: ( ( '{' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1700:1: ( '{' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1700:1: ( '{' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1701:1: '{'
            {
             before(grammarAccess.getIterableExpressionAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__IterableExpression__Group__4__Impl3401); 
             after(grammarAccess.getIterableExpressionAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__4__Impl"


    // $ANTLR start "rule__IterableExpression__Group__5"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1714:1: rule__IterableExpression__Group__5 : rule__IterableExpression__Group__5__Impl rule__IterableExpression__Group__6 ;
    public final void rule__IterableExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1718:1: ( rule__IterableExpression__Group__5__Impl rule__IterableExpression__Group__6 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1719:2: rule__IterableExpression__Group__5__Impl rule__IterableExpression__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__5__Impl_in_rule__IterableExpression__Group__53432);
            rule__IterableExpression__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__6_in_rule__IterableExpression__Group__53435);
            rule__IterableExpression__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__5"


    // $ANTLR start "rule__IterableExpression__Group__5__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1726:1: rule__IterableExpression__Group__5__Impl : ( ( rule__IterableExpression__Group_5__0 )? ) ;
    public final void rule__IterableExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1730:1: ( ( ( rule__IterableExpression__Group_5__0 )? ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1731:1: ( ( rule__IterableExpression__Group_5__0 )? )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1731:1: ( ( rule__IterableExpression__Group_5__0 )? )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1732:1: ( rule__IterableExpression__Group_5__0 )?
            {
             before(grammarAccess.getIterableExpressionAccess().getGroup_5()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1733:1: ( rule__IterableExpression__Group_5__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=21 && LA12_0<=22)||(LA12_0>=26 && LA12_0<=32)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1733:2: rule__IterableExpression__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group_5__0_in_rule__IterableExpression__Group__5__Impl3462);
                    rule__IterableExpression__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIterableExpressionAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__5__Impl"


    // $ANTLR start "rule__IterableExpression__Group__6"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1743:1: rule__IterableExpression__Group__6 : rule__IterableExpression__Group__6__Impl ;
    public final void rule__IterableExpression__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1747:1: ( rule__IterableExpression__Group__6__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1748:2: rule__IterableExpression__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group__6__Impl_in_rule__IterableExpression__Group__63493);
            rule__IterableExpression__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__6"


    // $ANTLR start "rule__IterableExpression__Group__6__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1754:1: rule__IterableExpression__Group__6__Impl : ( '}' ) ;
    public final void rule__IterableExpression__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1758:1: ( ( '}' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1759:1: ( '}' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1759:1: ( '}' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1760:1: '}'
            {
             before(grammarAccess.getIterableExpressionAccess().getRightCurlyBracketKeyword_6()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__IterableExpression__Group__6__Impl3521); 
             after(grammarAccess.getIterableExpressionAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group__6__Impl"


    // $ANTLR start "rule__IterableExpression__Group_5__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1787:1: rule__IterableExpression__Group_5__0 : rule__IterableExpression__Group_5__0__Impl rule__IterableExpression__Group_5__1 ;
    public final void rule__IterableExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1791:1: ( rule__IterableExpression__Group_5__0__Impl rule__IterableExpression__Group_5__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1792:2: rule__IterableExpression__Group_5__0__Impl rule__IterableExpression__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group_5__0__Impl_in_rule__IterableExpression__Group_5__03566);
            rule__IterableExpression__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group_5__1_in_rule__IterableExpression__Group_5__03569);
            rule__IterableExpression__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group_5__0"


    // $ANTLR start "rule__IterableExpression__Group_5__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1799:1: rule__IterableExpression__Group_5__0__Impl : ( ( rule__IterableExpression__ExpressionsAssignment_5_0 ) ) ;
    public final void rule__IterableExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1803:1: ( ( ( rule__IterableExpression__ExpressionsAssignment_5_0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1804:1: ( ( rule__IterableExpression__ExpressionsAssignment_5_0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1804:1: ( ( rule__IterableExpression__ExpressionsAssignment_5_0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1805:1: ( rule__IterableExpression__ExpressionsAssignment_5_0 )
            {
             before(grammarAccess.getIterableExpressionAccess().getExpressionsAssignment_5_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1806:1: ( rule__IterableExpression__ExpressionsAssignment_5_0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1806:2: rule__IterableExpression__ExpressionsAssignment_5_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__ExpressionsAssignment_5_0_in_rule__IterableExpression__Group_5__0__Impl3596);
            rule__IterableExpression__ExpressionsAssignment_5_0();

            state._fsp--;


            }

             after(grammarAccess.getIterableExpressionAccess().getExpressionsAssignment_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group_5__0__Impl"


    // $ANTLR start "rule__IterableExpression__Group_5__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1816:1: rule__IterableExpression__Group_5__1 : rule__IterableExpression__Group_5__1__Impl ;
    public final void rule__IterableExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1820:1: ( rule__IterableExpression__Group_5__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1821:2: rule__IterableExpression__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group_5__1__Impl_in_rule__IterableExpression__Group_5__13626);
            rule__IterableExpression__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group_5__1"


    // $ANTLR start "rule__IterableExpression__Group_5__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1827:1: rule__IterableExpression__Group_5__1__Impl : ( ( rule__IterableExpression__Group_5_1__0 )* ) ;
    public final void rule__IterableExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1831:1: ( ( ( rule__IterableExpression__Group_5_1__0 )* ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1832:1: ( ( rule__IterableExpression__Group_5_1__0 )* )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1832:1: ( ( rule__IterableExpression__Group_5_1__0 )* )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1833:1: ( rule__IterableExpression__Group_5_1__0 )*
            {
             before(grammarAccess.getIterableExpressionAccess().getGroup_5_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1834:1: ( rule__IterableExpression__Group_5_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==25) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1834:2: rule__IterableExpression__Group_5_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group_5_1__0_in_rule__IterableExpression__Group_5__1__Impl3653);
            	    rule__IterableExpression__Group_5_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getIterableExpressionAccess().getGroup_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group_5__1__Impl"


    // $ANTLR start "rule__IterableExpression__Group_5_1__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1848:1: rule__IterableExpression__Group_5_1__0 : rule__IterableExpression__Group_5_1__0__Impl rule__IterableExpression__Group_5_1__1 ;
    public final void rule__IterableExpression__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1852:1: ( rule__IterableExpression__Group_5_1__0__Impl rule__IterableExpression__Group_5_1__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1853:2: rule__IterableExpression__Group_5_1__0__Impl rule__IterableExpression__Group_5_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group_5_1__0__Impl_in_rule__IterableExpression__Group_5_1__03688);
            rule__IterableExpression__Group_5_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group_5_1__1_in_rule__IterableExpression__Group_5_1__03691);
            rule__IterableExpression__Group_5_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group_5_1__0"


    // $ANTLR start "rule__IterableExpression__Group_5_1__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1860:1: rule__IterableExpression__Group_5_1__0__Impl : ( ',' ) ;
    public final void rule__IterableExpression__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1864:1: ( ( ',' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1865:1: ( ',' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1865:1: ( ',' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1866:1: ','
            {
             before(grammarAccess.getIterableExpressionAccess().getCommaKeyword_5_1_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__IterableExpression__Group_5_1__0__Impl3719); 
             after(grammarAccess.getIterableExpressionAccess().getCommaKeyword_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group_5_1__0__Impl"


    // $ANTLR start "rule__IterableExpression__Group_5_1__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1879:1: rule__IterableExpression__Group_5_1__1 : rule__IterableExpression__Group_5_1__1__Impl ;
    public final void rule__IterableExpression__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1883:1: ( rule__IterableExpression__Group_5_1__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1884:2: rule__IterableExpression__Group_5_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__Group_5_1__1__Impl_in_rule__IterableExpression__Group_5_1__13750);
            rule__IterableExpression__Group_5_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group_5_1__1"


    // $ANTLR start "rule__IterableExpression__Group_5_1__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1890:1: rule__IterableExpression__Group_5_1__1__Impl : ( ( rule__IterableExpression__ExpressionsAssignment_5_1_1 ) ) ;
    public final void rule__IterableExpression__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1894:1: ( ( ( rule__IterableExpression__ExpressionsAssignment_5_1_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1895:1: ( ( rule__IterableExpression__ExpressionsAssignment_5_1_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1895:1: ( ( rule__IterableExpression__ExpressionsAssignment_5_1_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1896:1: ( rule__IterableExpression__ExpressionsAssignment_5_1_1 )
            {
             before(grammarAccess.getIterableExpressionAccess().getExpressionsAssignment_5_1_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1897:1: ( rule__IterableExpression__ExpressionsAssignment_5_1_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1897:2: rule__IterableExpression__ExpressionsAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__IterableExpression__ExpressionsAssignment_5_1_1_in_rule__IterableExpression__Group_5_1__1__Impl3777);
            rule__IterableExpression__ExpressionsAssignment_5_1_1();

            state._fsp--;


            }

             after(grammarAccess.getIterableExpressionAccess().getExpressionsAssignment_5_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__Group_5_1__1__Impl"


    // $ANTLR start "rule__WithExpression__Group__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1911:1: rule__WithExpression__Group__0 : rule__WithExpression__Group__0__Impl rule__WithExpression__Group__1 ;
    public final void rule__WithExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1915:1: ( rule__WithExpression__Group__0__Impl rule__WithExpression__Group__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1916:2: rule__WithExpression__Group__0__Impl rule__WithExpression__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group__0__Impl_in_rule__WithExpression__Group__03811);
            rule__WithExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group__1_in_rule__WithExpression__Group__03814);
            rule__WithExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group__0"


    // $ANTLR start "rule__WithExpression__Group__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1923:1: rule__WithExpression__Group__0__Impl : ( 'With' ) ;
    public final void rule__WithExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1927:1: ( ( 'With' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1928:1: ( 'With' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1928:1: ( 'With' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1929:1: 'With'
            {
             before(grammarAccess.getWithExpressionAccess().getWithKeyword_0()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__WithExpression__Group__0__Impl3842); 
             after(grammarAccess.getWithExpressionAccess().getWithKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group__0__Impl"


    // $ANTLR start "rule__WithExpression__Group__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1942:1: rule__WithExpression__Group__1 : rule__WithExpression__Group__1__Impl rule__WithExpression__Group__2 ;
    public final void rule__WithExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1946:1: ( rule__WithExpression__Group__1__Impl rule__WithExpression__Group__2 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1947:2: rule__WithExpression__Group__1__Impl rule__WithExpression__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group__1__Impl_in_rule__WithExpression__Group__13873);
            rule__WithExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group__2_in_rule__WithExpression__Group__13876);
            rule__WithExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group__1"


    // $ANTLR start "rule__WithExpression__Group__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1954:1: rule__WithExpression__Group__1__Impl : ( ( rule__WithExpression__VariableAssignment_1 ) ) ;
    public final void rule__WithExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1958:1: ( ( ( rule__WithExpression__VariableAssignment_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1959:1: ( ( rule__WithExpression__VariableAssignment_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1959:1: ( ( rule__WithExpression__VariableAssignment_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1960:1: ( rule__WithExpression__VariableAssignment_1 )
            {
             before(grammarAccess.getWithExpressionAccess().getVariableAssignment_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1961:1: ( rule__WithExpression__VariableAssignment_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1961:2: rule__WithExpression__VariableAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__VariableAssignment_1_in_rule__WithExpression__Group__1__Impl3903);
            rule__WithExpression__VariableAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWithExpressionAccess().getVariableAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group__1__Impl"


    // $ANTLR start "rule__WithExpression__Group__2"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1971:1: rule__WithExpression__Group__2 : rule__WithExpression__Group__2__Impl rule__WithExpression__Group__3 ;
    public final void rule__WithExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1975:1: ( rule__WithExpression__Group__2__Impl rule__WithExpression__Group__3 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1976:2: rule__WithExpression__Group__2__Impl rule__WithExpression__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group__2__Impl_in_rule__WithExpression__Group__23933);
            rule__WithExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group__3_in_rule__WithExpression__Group__23936);
            rule__WithExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group__2"


    // $ANTLR start "rule__WithExpression__Group__2__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1983:1: rule__WithExpression__Group__2__Impl : ( '{' ) ;
    public final void rule__WithExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1987:1: ( ( '{' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1988:1: ( '{' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1988:1: ( '{' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:1989:1: '{'
            {
             before(grammarAccess.getWithExpressionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__WithExpression__Group__2__Impl3964); 
             after(grammarAccess.getWithExpressionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group__2__Impl"


    // $ANTLR start "rule__WithExpression__Group__3"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2002:1: rule__WithExpression__Group__3 : rule__WithExpression__Group__3__Impl rule__WithExpression__Group__4 ;
    public final void rule__WithExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2006:1: ( rule__WithExpression__Group__3__Impl rule__WithExpression__Group__4 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2007:2: rule__WithExpression__Group__3__Impl rule__WithExpression__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group__3__Impl_in_rule__WithExpression__Group__33995);
            rule__WithExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group__4_in_rule__WithExpression__Group__33998);
            rule__WithExpression__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group__3"


    // $ANTLR start "rule__WithExpression__Group__3__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2014:1: rule__WithExpression__Group__3__Impl : ( ( rule__WithExpression__Group_3__0 )? ) ;
    public final void rule__WithExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2018:1: ( ( ( rule__WithExpression__Group_3__0 )? ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2019:1: ( ( rule__WithExpression__Group_3__0 )? )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2019:1: ( ( rule__WithExpression__Group_3__0 )? )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2020:1: ( rule__WithExpression__Group_3__0 )?
            {
             before(grammarAccess.getWithExpressionAccess().getGroup_3()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2021:1: ( rule__WithExpression__Group_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=21 && LA14_0<=22)||(LA14_0>=26 && LA14_0<=32)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2021:2: rule__WithExpression__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group_3__0_in_rule__WithExpression__Group__3__Impl4025);
                    rule__WithExpression__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getWithExpressionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group__3__Impl"


    // $ANTLR start "rule__WithExpression__Group__4"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2031:1: rule__WithExpression__Group__4 : rule__WithExpression__Group__4__Impl ;
    public final void rule__WithExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2035:1: ( rule__WithExpression__Group__4__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2036:2: rule__WithExpression__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group__4__Impl_in_rule__WithExpression__Group__44056);
            rule__WithExpression__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group__4"


    // $ANTLR start "rule__WithExpression__Group__4__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2042:1: rule__WithExpression__Group__4__Impl : ( '}' ) ;
    public final void rule__WithExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2046:1: ( ( '}' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2047:1: ( '}' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2047:1: ( '}' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2048:1: '}'
            {
             before(grammarAccess.getWithExpressionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__WithExpression__Group__4__Impl4084); 
             after(grammarAccess.getWithExpressionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group__4__Impl"


    // $ANTLR start "rule__WithExpression__Group_3__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2071:1: rule__WithExpression__Group_3__0 : rule__WithExpression__Group_3__0__Impl rule__WithExpression__Group_3__1 ;
    public final void rule__WithExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2075:1: ( rule__WithExpression__Group_3__0__Impl rule__WithExpression__Group_3__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2076:2: rule__WithExpression__Group_3__0__Impl rule__WithExpression__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group_3__0__Impl_in_rule__WithExpression__Group_3__04125);
            rule__WithExpression__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group_3__1_in_rule__WithExpression__Group_3__04128);
            rule__WithExpression__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group_3__0"


    // $ANTLR start "rule__WithExpression__Group_3__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2083:1: rule__WithExpression__Group_3__0__Impl : ( ( rule__WithExpression__ExpressionsAssignment_3_0 ) ) ;
    public final void rule__WithExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2087:1: ( ( ( rule__WithExpression__ExpressionsAssignment_3_0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2088:1: ( ( rule__WithExpression__ExpressionsAssignment_3_0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2088:1: ( ( rule__WithExpression__ExpressionsAssignment_3_0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2089:1: ( rule__WithExpression__ExpressionsAssignment_3_0 )
            {
             before(grammarAccess.getWithExpressionAccess().getExpressionsAssignment_3_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2090:1: ( rule__WithExpression__ExpressionsAssignment_3_0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2090:2: rule__WithExpression__ExpressionsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__ExpressionsAssignment_3_0_in_rule__WithExpression__Group_3__0__Impl4155);
            rule__WithExpression__ExpressionsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getWithExpressionAccess().getExpressionsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group_3__0__Impl"


    // $ANTLR start "rule__WithExpression__Group_3__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2100:1: rule__WithExpression__Group_3__1 : rule__WithExpression__Group_3__1__Impl ;
    public final void rule__WithExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2104:1: ( rule__WithExpression__Group_3__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2105:2: rule__WithExpression__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group_3__1__Impl_in_rule__WithExpression__Group_3__14185);
            rule__WithExpression__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group_3__1"


    // $ANTLR start "rule__WithExpression__Group_3__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2111:1: rule__WithExpression__Group_3__1__Impl : ( ( rule__WithExpression__Group_3_1__0 )* ) ;
    public final void rule__WithExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2115:1: ( ( ( rule__WithExpression__Group_3_1__0 )* ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2116:1: ( ( rule__WithExpression__Group_3_1__0 )* )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2116:1: ( ( rule__WithExpression__Group_3_1__0 )* )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2117:1: ( rule__WithExpression__Group_3_1__0 )*
            {
             before(grammarAccess.getWithExpressionAccess().getGroup_3_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2118:1: ( rule__WithExpression__Group_3_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==25) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2118:2: rule__WithExpression__Group_3_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group_3_1__0_in_rule__WithExpression__Group_3__1__Impl4212);
            	    rule__WithExpression__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getWithExpressionAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group_3__1__Impl"


    // $ANTLR start "rule__WithExpression__Group_3_1__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2132:1: rule__WithExpression__Group_3_1__0 : rule__WithExpression__Group_3_1__0__Impl rule__WithExpression__Group_3_1__1 ;
    public final void rule__WithExpression__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2136:1: ( rule__WithExpression__Group_3_1__0__Impl rule__WithExpression__Group_3_1__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2137:2: rule__WithExpression__Group_3_1__0__Impl rule__WithExpression__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group_3_1__0__Impl_in_rule__WithExpression__Group_3_1__04247);
            rule__WithExpression__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group_3_1__1_in_rule__WithExpression__Group_3_1__04250);
            rule__WithExpression__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group_3_1__0"


    // $ANTLR start "rule__WithExpression__Group_3_1__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2144:1: rule__WithExpression__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__WithExpression__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2148:1: ( ( ',' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2149:1: ( ',' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2149:1: ( ',' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2150:1: ','
            {
             before(grammarAccess.getWithExpressionAccess().getCommaKeyword_3_1_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__WithExpression__Group_3_1__0__Impl4278); 
             after(grammarAccess.getWithExpressionAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group_3_1__0__Impl"


    // $ANTLR start "rule__WithExpression__Group_3_1__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2163:1: rule__WithExpression__Group_3_1__1 : rule__WithExpression__Group_3_1__1__Impl ;
    public final void rule__WithExpression__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2167:1: ( rule__WithExpression__Group_3_1__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2168:2: rule__WithExpression__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__Group_3_1__1__Impl_in_rule__WithExpression__Group_3_1__14309);
            rule__WithExpression__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group_3_1__1"


    // $ANTLR start "rule__WithExpression__Group_3_1__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2174:1: rule__WithExpression__Group_3_1__1__Impl : ( ( rule__WithExpression__ExpressionsAssignment_3_1_1 ) ) ;
    public final void rule__WithExpression__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2178:1: ( ( ( rule__WithExpression__ExpressionsAssignment_3_1_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2179:1: ( ( rule__WithExpression__ExpressionsAssignment_3_1_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2179:1: ( ( rule__WithExpression__ExpressionsAssignment_3_1_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2180:1: ( rule__WithExpression__ExpressionsAssignment_3_1_1 )
            {
             before(grammarAccess.getWithExpressionAccess().getExpressionsAssignment_3_1_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2181:1: ( rule__WithExpression__ExpressionsAssignment_3_1_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2181:2: rule__WithExpression__ExpressionsAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__WithExpression__ExpressionsAssignment_3_1_1_in_rule__WithExpression__Group_3_1__1__Impl4336);
            rule__WithExpression__ExpressionsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getWithExpressionAccess().getExpressionsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__Group_3_1__1__Impl"


    // $ANTLR start "rule__AdaptExpression__Group__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2195:1: rule__AdaptExpression__Group__0 : rule__AdaptExpression__Group__0__Impl rule__AdaptExpression__Group__1 ;
    public final void rule__AdaptExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2199:1: ( rule__AdaptExpression__Group__0__Impl rule__AdaptExpression__Group__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2200:2: rule__AdaptExpression__Group__0__Impl rule__AdaptExpression__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group__0__Impl_in_rule__AdaptExpression__Group__04370);
            rule__AdaptExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group__1_in_rule__AdaptExpression__Group__04373);
            rule__AdaptExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group__0"


    // $ANTLR start "rule__AdaptExpression__Group__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2207:1: rule__AdaptExpression__Group__0__Impl : ( 'AdaptTo' ) ;
    public final void rule__AdaptExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2211:1: ( ( 'AdaptTo' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2212:1: ( 'AdaptTo' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2212:1: ( 'AdaptTo' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2213:1: 'AdaptTo'
            {
             before(grammarAccess.getAdaptExpressionAccess().getAdaptToKeyword_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__AdaptExpression__Group__0__Impl4401); 
             after(grammarAccess.getAdaptExpressionAccess().getAdaptToKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group__0__Impl"


    // $ANTLR start "rule__AdaptExpression__Group__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2226:1: rule__AdaptExpression__Group__1 : rule__AdaptExpression__Group__1__Impl rule__AdaptExpression__Group__2 ;
    public final void rule__AdaptExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2230:1: ( rule__AdaptExpression__Group__1__Impl rule__AdaptExpression__Group__2 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2231:2: rule__AdaptExpression__Group__1__Impl rule__AdaptExpression__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group__1__Impl_in_rule__AdaptExpression__Group__14432);
            rule__AdaptExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group__2_in_rule__AdaptExpression__Group__14435);
            rule__AdaptExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group__1"


    // $ANTLR start "rule__AdaptExpression__Group__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2238:1: rule__AdaptExpression__Group__1__Impl : ( ( rule__AdaptExpression__ValueAssignment_1 ) ) ;
    public final void rule__AdaptExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2242:1: ( ( ( rule__AdaptExpression__ValueAssignment_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2243:1: ( ( rule__AdaptExpression__ValueAssignment_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2243:1: ( ( rule__AdaptExpression__ValueAssignment_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2244:1: ( rule__AdaptExpression__ValueAssignment_1 )
            {
             before(grammarAccess.getAdaptExpressionAccess().getValueAssignment_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2245:1: ( rule__AdaptExpression__ValueAssignment_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2245:2: rule__AdaptExpression__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__ValueAssignment_1_in_rule__AdaptExpression__Group__1__Impl4462);
            rule__AdaptExpression__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAdaptExpressionAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group__1__Impl"


    // $ANTLR start "rule__AdaptExpression__Group__2"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2255:1: rule__AdaptExpression__Group__2 : rule__AdaptExpression__Group__2__Impl rule__AdaptExpression__Group__3 ;
    public final void rule__AdaptExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2259:1: ( rule__AdaptExpression__Group__2__Impl rule__AdaptExpression__Group__3 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2260:2: rule__AdaptExpression__Group__2__Impl rule__AdaptExpression__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group__2__Impl_in_rule__AdaptExpression__Group__24492);
            rule__AdaptExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group__3_in_rule__AdaptExpression__Group__24495);
            rule__AdaptExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group__2"


    // $ANTLR start "rule__AdaptExpression__Group__2__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2267:1: rule__AdaptExpression__Group__2__Impl : ( '{' ) ;
    public final void rule__AdaptExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2271:1: ( ( '{' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2272:1: ( '{' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2272:1: ( '{' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2273:1: '{'
            {
             before(grammarAccess.getAdaptExpressionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__AdaptExpression__Group__2__Impl4523); 
             after(grammarAccess.getAdaptExpressionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group__2__Impl"


    // $ANTLR start "rule__AdaptExpression__Group__3"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2286:1: rule__AdaptExpression__Group__3 : rule__AdaptExpression__Group__3__Impl rule__AdaptExpression__Group__4 ;
    public final void rule__AdaptExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2290:1: ( rule__AdaptExpression__Group__3__Impl rule__AdaptExpression__Group__4 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2291:2: rule__AdaptExpression__Group__3__Impl rule__AdaptExpression__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group__3__Impl_in_rule__AdaptExpression__Group__34554);
            rule__AdaptExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group__4_in_rule__AdaptExpression__Group__34557);
            rule__AdaptExpression__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group__3"


    // $ANTLR start "rule__AdaptExpression__Group__3__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2298:1: rule__AdaptExpression__Group__3__Impl : ( ( rule__AdaptExpression__Group_3__0 )? ) ;
    public final void rule__AdaptExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2302:1: ( ( ( rule__AdaptExpression__Group_3__0 )? ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2303:1: ( ( rule__AdaptExpression__Group_3__0 )? )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2303:1: ( ( rule__AdaptExpression__Group_3__0 )? )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2304:1: ( rule__AdaptExpression__Group_3__0 )?
            {
             before(grammarAccess.getAdaptExpressionAccess().getGroup_3()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2305:1: ( rule__AdaptExpression__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=21 && LA16_0<=22)||(LA16_0>=26 && LA16_0<=32)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2305:2: rule__AdaptExpression__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group_3__0_in_rule__AdaptExpression__Group__3__Impl4584);
                    rule__AdaptExpression__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAdaptExpressionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group__3__Impl"


    // $ANTLR start "rule__AdaptExpression__Group__4"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2315:1: rule__AdaptExpression__Group__4 : rule__AdaptExpression__Group__4__Impl ;
    public final void rule__AdaptExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2319:1: ( rule__AdaptExpression__Group__4__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2320:2: rule__AdaptExpression__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group__4__Impl_in_rule__AdaptExpression__Group__44615);
            rule__AdaptExpression__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group__4"


    // $ANTLR start "rule__AdaptExpression__Group__4__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2326:1: rule__AdaptExpression__Group__4__Impl : ( '}' ) ;
    public final void rule__AdaptExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2330:1: ( ( '}' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2331:1: ( '}' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2331:1: ( '}' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2332:1: '}'
            {
             before(grammarAccess.getAdaptExpressionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__AdaptExpression__Group__4__Impl4643); 
             after(grammarAccess.getAdaptExpressionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group__4__Impl"


    // $ANTLR start "rule__AdaptExpression__Group_3__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2355:1: rule__AdaptExpression__Group_3__0 : rule__AdaptExpression__Group_3__0__Impl rule__AdaptExpression__Group_3__1 ;
    public final void rule__AdaptExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2359:1: ( rule__AdaptExpression__Group_3__0__Impl rule__AdaptExpression__Group_3__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2360:2: rule__AdaptExpression__Group_3__0__Impl rule__AdaptExpression__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group_3__0__Impl_in_rule__AdaptExpression__Group_3__04684);
            rule__AdaptExpression__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group_3__1_in_rule__AdaptExpression__Group_3__04687);
            rule__AdaptExpression__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group_3__0"


    // $ANTLR start "rule__AdaptExpression__Group_3__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2367:1: rule__AdaptExpression__Group_3__0__Impl : ( ( rule__AdaptExpression__ExpressionsAssignment_3_0 ) ) ;
    public final void rule__AdaptExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2371:1: ( ( ( rule__AdaptExpression__ExpressionsAssignment_3_0 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2372:1: ( ( rule__AdaptExpression__ExpressionsAssignment_3_0 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2372:1: ( ( rule__AdaptExpression__ExpressionsAssignment_3_0 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2373:1: ( rule__AdaptExpression__ExpressionsAssignment_3_0 )
            {
             before(grammarAccess.getAdaptExpressionAccess().getExpressionsAssignment_3_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2374:1: ( rule__AdaptExpression__ExpressionsAssignment_3_0 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2374:2: rule__AdaptExpression__ExpressionsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__ExpressionsAssignment_3_0_in_rule__AdaptExpression__Group_3__0__Impl4714);
            rule__AdaptExpression__ExpressionsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getAdaptExpressionAccess().getExpressionsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group_3__0__Impl"


    // $ANTLR start "rule__AdaptExpression__Group_3__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2384:1: rule__AdaptExpression__Group_3__1 : rule__AdaptExpression__Group_3__1__Impl ;
    public final void rule__AdaptExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2388:1: ( rule__AdaptExpression__Group_3__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2389:2: rule__AdaptExpression__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group_3__1__Impl_in_rule__AdaptExpression__Group_3__14744);
            rule__AdaptExpression__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group_3__1"


    // $ANTLR start "rule__AdaptExpression__Group_3__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2395:1: rule__AdaptExpression__Group_3__1__Impl : ( ( rule__AdaptExpression__Group_3_1__0 )* ) ;
    public final void rule__AdaptExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2399:1: ( ( ( rule__AdaptExpression__Group_3_1__0 )* ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2400:1: ( ( rule__AdaptExpression__Group_3_1__0 )* )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2400:1: ( ( rule__AdaptExpression__Group_3_1__0 )* )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2401:1: ( rule__AdaptExpression__Group_3_1__0 )*
            {
             before(grammarAccess.getAdaptExpressionAccess().getGroup_3_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2402:1: ( rule__AdaptExpression__Group_3_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==25) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2402:2: rule__AdaptExpression__Group_3_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group_3_1__0_in_rule__AdaptExpression__Group_3__1__Impl4771);
            	    rule__AdaptExpression__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getAdaptExpressionAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group_3__1__Impl"


    // $ANTLR start "rule__AdaptExpression__Group_3_1__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2416:1: rule__AdaptExpression__Group_3_1__0 : rule__AdaptExpression__Group_3_1__0__Impl rule__AdaptExpression__Group_3_1__1 ;
    public final void rule__AdaptExpression__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2420:1: ( rule__AdaptExpression__Group_3_1__0__Impl rule__AdaptExpression__Group_3_1__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2421:2: rule__AdaptExpression__Group_3_1__0__Impl rule__AdaptExpression__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group_3_1__0__Impl_in_rule__AdaptExpression__Group_3_1__04806);
            rule__AdaptExpression__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group_3_1__1_in_rule__AdaptExpression__Group_3_1__04809);
            rule__AdaptExpression__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group_3_1__0"


    // $ANTLR start "rule__AdaptExpression__Group_3_1__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2428:1: rule__AdaptExpression__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__AdaptExpression__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2432:1: ( ( ',' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2433:1: ( ',' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2433:1: ( ',' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2434:1: ','
            {
             before(grammarAccess.getAdaptExpressionAccess().getCommaKeyword_3_1_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__AdaptExpression__Group_3_1__0__Impl4837); 
             after(grammarAccess.getAdaptExpressionAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group_3_1__0__Impl"


    // $ANTLR start "rule__AdaptExpression__Group_3_1__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2447:1: rule__AdaptExpression__Group_3_1__1 : rule__AdaptExpression__Group_3_1__1__Impl ;
    public final void rule__AdaptExpression__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2451:1: ( rule__AdaptExpression__Group_3_1__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2452:2: rule__AdaptExpression__Group_3_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__Group_3_1__1__Impl_in_rule__AdaptExpression__Group_3_1__14868);
            rule__AdaptExpression__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group_3_1__1"


    // $ANTLR start "rule__AdaptExpression__Group_3_1__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2458:1: rule__AdaptExpression__Group_3_1__1__Impl : ( ( rule__AdaptExpression__ExpressionsAssignment_3_1_1 ) ) ;
    public final void rule__AdaptExpression__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2462:1: ( ( ( rule__AdaptExpression__ExpressionsAssignment_3_1_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2463:1: ( ( rule__AdaptExpression__ExpressionsAssignment_3_1_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2463:1: ( ( rule__AdaptExpression__ExpressionsAssignment_3_1_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2464:1: ( rule__AdaptExpression__ExpressionsAssignment_3_1_1 )
            {
             before(grammarAccess.getAdaptExpressionAccess().getExpressionsAssignment_3_1_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2465:1: ( rule__AdaptExpression__ExpressionsAssignment_3_1_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2465:2: rule__AdaptExpression__ExpressionsAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AdaptExpression__ExpressionsAssignment_3_1_1_in_rule__AdaptExpression__Group_3_1__1__Impl4895);
            rule__AdaptExpression__ExpressionsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAdaptExpressionAccess().getExpressionsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__Group_3_1__1__Impl"


    // $ANTLR start "rule__EqualExpression__Group__0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2479:1: rule__EqualExpression__Group__0 : rule__EqualExpression__Group__0__Impl rule__EqualExpression__Group__1 ;
    public final void rule__EqualExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2483:1: ( rule__EqualExpression__Group__0__Impl rule__EqualExpression__Group__1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2484:2: rule__EqualExpression__Group__0__Impl rule__EqualExpression__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EqualExpression__Group__0__Impl_in_rule__EqualExpression__Group__04929);
            rule__EqualExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EqualExpression__Group__1_in_rule__EqualExpression__Group__04932);
            rule__EqualExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualExpression__Group__0"


    // $ANTLR start "rule__EqualExpression__Group__0__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2491:1: rule__EqualExpression__Group__0__Impl : ( 'Equal' ) ;
    public final void rule__EqualExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2495:1: ( ( 'Equal' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2496:1: ( 'Equal' )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2496:1: ( 'Equal' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2497:1: 'Equal'
            {
             before(grammarAccess.getEqualExpressionAccess().getEqualKeyword_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__EqualExpression__Group__0__Impl4960); 
             after(grammarAccess.getEqualExpressionAccess().getEqualKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualExpression__Group__0__Impl"


    // $ANTLR start "rule__EqualExpression__Group__1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2510:1: rule__EqualExpression__Group__1 : rule__EqualExpression__Group__1__Impl ;
    public final void rule__EqualExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2514:1: ( rule__EqualExpression__Group__1__Impl )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2515:2: rule__EqualExpression__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EqualExpression__Group__1__Impl_in_rule__EqualExpression__Group__14991);
            rule__EqualExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualExpression__Group__1"


    // $ANTLR start "rule__EqualExpression__Group__1__Impl"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2521:1: rule__EqualExpression__Group__1__Impl : ( ( rule__EqualExpression__ValueAssignment_1 ) ) ;
    public final void rule__EqualExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2525:1: ( ( ( rule__EqualExpression__ValueAssignment_1 ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2526:1: ( ( rule__EqualExpression__ValueAssignment_1 ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2526:1: ( ( rule__EqualExpression__ValueAssignment_1 ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2527:1: ( rule__EqualExpression__ValueAssignment_1 )
            {
             before(grammarAccess.getEqualExpressionAccess().getValueAssignment_1()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2528:1: ( rule__EqualExpression__ValueAssignment_1 )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2528:2: rule__EqualExpression__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EqualExpression__ValueAssignment_1_in_rule__EqualExpression__Group__1__Impl5018);
            rule__EqualExpression__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEqualExpressionAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualExpression__Group__1__Impl"


    // $ANTLR start "rule__Root__ExpressionAssignment_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2543:1: rule__Root__ExpressionAssignment_1 : ( ruleExpression ) ;
    public final void rule__Root__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2547:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2548:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2548:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2549:1: ruleExpression
            {
             before(grammarAccess.getRootAccess().getExpressionExpressionParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__Root__ExpressionAssignment_15057);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getRootAccess().getExpressionExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Root__ExpressionAssignment_1"


    // $ANTLR start "rule__InstanceExpression__ValueAssignment_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2558:1: rule__InstanceExpression__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__InstanceExpression__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2562:1: ( ( RULE_STRING ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2563:1: ( RULE_STRING )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2563:1: ( RULE_STRING )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2564:1: RULE_STRING
            {
             before(grammarAccess.getInstanceExpressionAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__InstanceExpression__ValueAssignment_15088); 
             after(grammarAccess.getInstanceExpressionAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstanceExpression__ValueAssignment_1"


    // $ANTLR start "rule__AndExpression__ExpressionsAssignment_3_0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2573:1: rule__AndExpression__ExpressionsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__AndExpression__ExpressionsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2577:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2578:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2578:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2579:1: ruleExpression
            {
             before(grammarAccess.getAndExpressionAccess().getExpressionsExpressionParserRuleCall_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__AndExpression__ExpressionsAssignment_3_05119);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionAccess().getExpressionsExpressionParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__ExpressionsAssignment_3_0"


    // $ANTLR start "rule__AndExpression__ExpressionsAssignment_3_1_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2588:1: rule__AndExpression__ExpressionsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__AndExpression__ExpressionsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2592:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2593:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2593:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2594:1: ruleExpression
            {
             before(grammarAccess.getAndExpressionAccess().getExpressionsExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__AndExpression__ExpressionsAssignment_3_1_15150);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionAccess().getExpressionsExpressionParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__ExpressionsAssignment_3_1_1"


    // $ANTLR start "rule__OrExpresison__ExpressionsAssignment_3_0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2603:1: rule__OrExpresison__ExpressionsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__OrExpresison__ExpressionsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2607:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2608:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2608:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2609:1: ruleExpression
            {
             before(grammarAccess.getOrExpresisonAccess().getExpressionsExpressionParserRuleCall_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__OrExpresison__ExpressionsAssignment_3_05181);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getOrExpresisonAccess().getExpressionsExpressionParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__ExpressionsAssignment_3_0"


    // $ANTLR start "rule__OrExpresison__ExpressionsAssignment_3_1_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2618:1: rule__OrExpresison__ExpressionsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__OrExpresison__ExpressionsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2622:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2623:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2623:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2624:1: ruleExpression
            {
             before(grammarAccess.getOrExpresisonAccess().getExpressionsExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__OrExpresison__ExpressionsAssignment_3_1_15212);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getOrExpresisonAccess().getExpressionsExpressionParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpresison__ExpressionsAssignment_3_1_1"


    // $ANTLR start "rule__NotExpression__ExpressionsAssignment_3_0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2633:1: rule__NotExpression__ExpressionsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__NotExpression__ExpressionsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2637:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2638:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2638:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2639:1: ruleExpression
            {
             before(grammarAccess.getNotExpressionAccess().getExpressionsExpressionParserRuleCall_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__NotExpression__ExpressionsAssignment_3_05243);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getNotExpressionAccess().getExpressionsExpressionParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__ExpressionsAssignment_3_0"


    // $ANTLR start "rule__NotExpression__ExpressionsAssignment_3_1_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2648:1: rule__NotExpression__ExpressionsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__NotExpression__ExpressionsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2652:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2653:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2653:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2654:1: ruleExpression
            {
             before(grammarAccess.getNotExpressionAccess().getExpressionsExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__NotExpression__ExpressionsAssignment_3_1_15274);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getNotExpressionAccess().getExpressionsExpressionParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NotExpression__ExpressionsAssignment_3_1_1"


    // $ANTLR start "rule__IterableExpression__IfEmptyAssignment_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2663:1: rule__IterableExpression__IfEmptyAssignment_1 : ( ( 'ifEmpty' ) ) ;
    public final void rule__IterableExpression__IfEmptyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2667:1: ( ( ( 'ifEmpty' ) ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2668:1: ( ( 'ifEmpty' ) )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2668:1: ( ( 'ifEmpty' ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2669:1: ( 'ifEmpty' )
            {
             before(grammarAccess.getIterableExpressionAccess().getIfEmptyIfEmptyKeyword_1_0()); 
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2670:1: ( 'ifEmpty' )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2671:1: 'ifEmpty'
            {
             before(grammarAccess.getIterableExpressionAccess().getIfEmptyIfEmptyKeyword_1_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__IterableExpression__IfEmptyAssignment_15310); 
             after(grammarAccess.getIterableExpressionAccess().getIfEmptyIfEmptyKeyword_1_0()); 

            }

             after(grammarAccess.getIterableExpressionAccess().getIfEmptyIfEmptyKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__IfEmptyAssignment_1"


    // $ANTLR start "rule__IterableExpression__OperandAssignment_3"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2686:1: rule__IterableExpression__OperandAssignment_3 : ( ruleOperator ) ;
    public final void rule__IterableExpression__OperandAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2690:1: ( ( ruleOperator ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2691:1: ( ruleOperator )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2691:1: ( ruleOperator )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2692:1: ruleOperator
            {
             before(grammarAccess.getIterableExpressionAccess().getOperandOperatorParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_rule__IterableExpression__OperandAssignment_35349);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getIterableExpressionAccess().getOperandOperatorParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__OperandAssignment_3"


    // $ANTLR start "rule__IterableExpression__ExpressionsAssignment_5_0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2701:1: rule__IterableExpression__ExpressionsAssignment_5_0 : ( ruleExpression ) ;
    public final void rule__IterableExpression__ExpressionsAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2705:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2706:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2706:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2707:1: ruleExpression
            {
             before(grammarAccess.getIterableExpressionAccess().getExpressionsExpressionParserRuleCall_5_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__IterableExpression__ExpressionsAssignment_5_05380);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getIterableExpressionAccess().getExpressionsExpressionParserRuleCall_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__ExpressionsAssignment_5_0"


    // $ANTLR start "rule__IterableExpression__ExpressionsAssignment_5_1_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2716:1: rule__IterableExpression__ExpressionsAssignment_5_1_1 : ( ruleExpression ) ;
    public final void rule__IterableExpression__ExpressionsAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2720:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2721:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2721:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2722:1: ruleExpression
            {
             before(grammarAccess.getIterableExpressionAccess().getExpressionsExpressionParserRuleCall_5_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__IterableExpression__ExpressionsAssignment_5_1_15411);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getIterableExpressionAccess().getExpressionsExpressionParserRuleCall_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterableExpression__ExpressionsAssignment_5_1_1"


    // $ANTLR start "rule__WithExpression__VariableAssignment_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2731:1: rule__WithExpression__VariableAssignment_1 : ( ruleVariable ) ;
    public final void rule__WithExpression__VariableAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2735:1: ( ( ruleVariable ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2736:1: ( ruleVariable )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2736:1: ( ruleVariable )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2737:1: ruleVariable
            {
             before(grammarAccess.getWithExpressionAccess().getVariableVariableParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_rule__WithExpression__VariableAssignment_15442);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getWithExpressionAccess().getVariableVariableParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__VariableAssignment_1"


    // $ANTLR start "rule__WithExpression__ExpressionsAssignment_3_0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2746:1: rule__WithExpression__ExpressionsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__WithExpression__ExpressionsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2750:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2751:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2751:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2752:1: ruleExpression
            {
             before(grammarAccess.getWithExpressionAccess().getExpressionsExpressionParserRuleCall_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__WithExpression__ExpressionsAssignment_3_05473);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getWithExpressionAccess().getExpressionsExpressionParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__ExpressionsAssignment_3_0"


    // $ANTLR start "rule__WithExpression__ExpressionsAssignment_3_1_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2761:1: rule__WithExpression__ExpressionsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__WithExpression__ExpressionsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2765:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2766:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2766:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2767:1: ruleExpression
            {
             before(grammarAccess.getWithExpressionAccess().getExpressionsExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__WithExpression__ExpressionsAssignment_3_1_15504);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getWithExpressionAccess().getExpressionsExpressionParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithExpression__ExpressionsAssignment_3_1_1"


    // $ANTLR start "rule__AdaptExpression__ValueAssignment_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2776:1: rule__AdaptExpression__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__AdaptExpression__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2780:1: ( ( RULE_STRING ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2781:1: ( RULE_STRING )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2781:1: ( RULE_STRING )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2782:1: RULE_STRING
            {
             before(grammarAccess.getAdaptExpressionAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__AdaptExpression__ValueAssignment_15535); 
             after(grammarAccess.getAdaptExpressionAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__ValueAssignment_1"


    // $ANTLR start "rule__AdaptExpression__ExpressionsAssignment_3_0"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2791:1: rule__AdaptExpression__ExpressionsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__AdaptExpression__ExpressionsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2795:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2796:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2796:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2797:1: ruleExpression
            {
             before(grammarAccess.getAdaptExpressionAccess().getExpressionsExpressionParserRuleCall_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__AdaptExpression__ExpressionsAssignment_3_05566);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getAdaptExpressionAccess().getExpressionsExpressionParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__ExpressionsAssignment_3_0"


    // $ANTLR start "rule__AdaptExpression__ExpressionsAssignment_3_1_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2806:1: rule__AdaptExpression__ExpressionsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__AdaptExpression__ExpressionsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2810:1: ( ( ruleExpression ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2811:1: ( ruleExpression )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2811:1: ( ruleExpression )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2812:1: ruleExpression
            {
             before(grammarAccess.getAdaptExpressionAccess().getExpressionsExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__AdaptExpression__ExpressionsAssignment_3_1_15597);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getAdaptExpressionAccess().getExpressionsExpressionParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdaptExpression__ExpressionsAssignment_3_1_1"


    // $ANTLR start "rule__EqualExpression__ValueAssignment_1"
    // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2821:1: rule__EqualExpression__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__EqualExpression__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2825:1: ( ( RULE_STRING ) )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2826:1: ( RULE_STRING )
            {
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2826:1: ( RULE_STRING )
            // ../org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui/src-gen/org/eclipse/escriptmonkey/scripting/ui/expression/xtext/ui/contentassist/antlr/internal/InternalCoreExpression.g:2827:1: RULE_STRING
            {
             before(grammarAccess.getEqualExpressionAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EqualExpression__ValueAssignment_15628); 
             after(grammarAccess.getEqualExpressionAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualExpression__ValueAssignment_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__0_in_ruleRoot94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Expression__Alternatives_in_ruleExpression154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInstanceExpression_in_entryRuleInstanceExpression183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInstanceExpression190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InstanceExpression__Group__0_in_ruleInstanceExpression216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression243 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group__0_in_ruleAndExpression276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOrExpresison_in_entryRuleOrExpresison303 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOrExpresison310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group__0_in_ruleOrExpresison336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotExpression_in_entryRuleNotExpression363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNotExpression370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group__0_in_ruleNotExpression396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIterableExpression_in_entryRuleIterableExpression423 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIterableExpression430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__0_in_ruleIterableExpression456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithExpression_in_entryRuleWithExpression483 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWithExpression490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group__0_in_ruleWithExpression516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAdaptExpression_in_entryRuleAdaptExpression543 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAdaptExpression550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group__0_in_ruleAdaptExpression576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEqualExpression_in_entryRuleEqualExpression603 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEqualExpression610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EqualExpression__Group__0_in_ruleEqualExpression636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_entryRuleOperator663 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperator670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Operator__Alternatives_in_ruleOperator696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable725 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariable732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Alternatives_in_ruleVariable758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInstanceExpression_in_rule__Expression__Alternatives794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndExpression_in_rule__Expression__Alternatives811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOrExpresison_in_rule__Expression__Alternatives828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotExpression_in_rule__Expression__Alternatives845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIterableExpression_in_rule__Expression__Alternatives862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWithExpression_in_rule__Expression__Alternatives879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAdaptExpression_in_rule__Expression__Alternatives896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEqualExpression_in_rule__Expression__Alternatives913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Operator__Alternatives947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Operator__Alternatives967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Variable__Alternatives1003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Variable__Alternatives1023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Variable__Alternatives1043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Variable__Alternatives1063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Variable__Alternatives1083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Variable__Alternatives1103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__0__Impl_in_rule__Root__Group__01135 = new BitSet(new long[]{0x00000001FC600000L});
        public static final BitSet FOLLOW_rule__Root__Group__1_in_rule__Root__Group__01138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Root__Group__0__Impl1166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__1__Impl_in_rule__Root__Group__11197 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Root__Group__2_in_rule__Root__Group__11200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__ExpressionAssignment_1_in_rule__Root__Group__1__Impl1227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Root__Group__2__Impl_in_rule__Root__Group__21257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Root__Group__2__Impl1285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InstanceExpression__Group__0__Impl_in_rule__InstanceExpression__Group__01322 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__InstanceExpression__Group__1_in_rule__InstanceExpression__Group__01325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__InstanceExpression__Group__0__Impl1353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InstanceExpression__Group__1__Impl_in_rule__InstanceExpression__Group__11384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InstanceExpression__ValueAssignment_1_in_rule__InstanceExpression__Group__1__Impl1411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group__0__Impl_in_rule__AndExpression__Group__01445 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__AndExpression__Group__1_in_rule__AndExpression__Group__01448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group__1__Impl_in_rule__AndExpression__Group__11506 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__AndExpression__Group__2_in_rule__AndExpression__Group__11509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__AndExpression__Group__1__Impl1537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group__2__Impl_in_rule__AndExpression__Group__21568 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__AndExpression__Group__3_in_rule__AndExpression__Group__21571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__AndExpression__Group__2__Impl1599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group__3__Impl_in_rule__AndExpression__Group__31630 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__AndExpression__Group__4_in_rule__AndExpression__Group__31633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group_3__0_in_rule__AndExpression__Group__3__Impl1660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group__4__Impl_in_rule__AndExpression__Group__41691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__AndExpression__Group__4__Impl1719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group_3__0__Impl_in_rule__AndExpression__Group_3__01760 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__AndExpression__Group_3__1_in_rule__AndExpression__Group_3__01763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__ExpressionsAssignment_3_0_in_rule__AndExpression__Group_3__0__Impl1790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group_3__1__Impl_in_rule__AndExpression__Group_3__11820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group_3_1__0_in_rule__AndExpression__Group_3__1__Impl1847 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group_3_1__0__Impl_in_rule__AndExpression__Group_3_1__01882 = new BitSet(new long[]{0x00000001FC600000L});
        public static final BitSet FOLLOW_rule__AndExpression__Group_3_1__1_in_rule__AndExpression__Group_3_1__01885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__AndExpression__Group_3_1__0__Impl1913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__Group_3_1__1__Impl_in_rule__AndExpression__Group_3_1__11944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AndExpression__ExpressionsAssignment_3_1_1_in_rule__AndExpression__Group_3_1__1__Impl1971 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group__0__Impl_in_rule__OrExpresison__Group__02005 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group__1_in_rule__OrExpresison__Group__02008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group__1__Impl_in_rule__OrExpresison__Group__12066 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group__2_in_rule__OrExpresison__Group__12069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__OrExpresison__Group__1__Impl2097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group__2__Impl_in_rule__OrExpresison__Group__22128 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group__3_in_rule__OrExpresison__Group__22131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__OrExpresison__Group__2__Impl2159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group__3__Impl_in_rule__OrExpresison__Group__32190 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group__4_in_rule__OrExpresison__Group__32193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group_3__0_in_rule__OrExpresison__Group__3__Impl2220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group__4__Impl_in_rule__OrExpresison__Group__42251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__OrExpresison__Group__4__Impl2279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group_3__0__Impl_in_rule__OrExpresison__Group_3__02320 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group_3__1_in_rule__OrExpresison__Group_3__02323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__ExpressionsAssignment_3_0_in_rule__OrExpresison__Group_3__0__Impl2350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group_3__1__Impl_in_rule__OrExpresison__Group_3__12380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group_3_1__0_in_rule__OrExpresison__Group_3__1__Impl2407 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group_3_1__0__Impl_in_rule__OrExpresison__Group_3_1__02442 = new BitSet(new long[]{0x00000001FC600000L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group_3_1__1_in_rule__OrExpresison__Group_3_1__02445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__OrExpresison__Group_3_1__0__Impl2473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__Group_3_1__1__Impl_in_rule__OrExpresison__Group_3_1__12504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__OrExpresison__ExpressionsAssignment_3_1_1_in_rule__OrExpresison__Group_3_1__1__Impl2531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group__0__Impl_in_rule__NotExpression__Group__02565 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__NotExpression__Group__1_in_rule__NotExpression__Group__02568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group__1__Impl_in_rule__NotExpression__Group__12626 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__NotExpression__Group__2_in_rule__NotExpression__Group__12629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__NotExpression__Group__1__Impl2657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group__2__Impl_in_rule__NotExpression__Group__22688 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__NotExpression__Group__3_in_rule__NotExpression__Group__22691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__NotExpression__Group__2__Impl2719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group__3__Impl_in_rule__NotExpression__Group__32750 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__NotExpression__Group__4_in_rule__NotExpression__Group__32753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group_3__0_in_rule__NotExpression__Group__3__Impl2780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group__4__Impl_in_rule__NotExpression__Group__42811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__NotExpression__Group__4__Impl2839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group_3__0__Impl_in_rule__NotExpression__Group_3__02880 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__NotExpression__Group_3__1_in_rule__NotExpression__Group_3__02883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__ExpressionsAssignment_3_0_in_rule__NotExpression__Group_3__0__Impl2910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group_3__1__Impl_in_rule__NotExpression__Group_3__12940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group_3_1__0_in_rule__NotExpression__Group_3__1__Impl2967 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group_3_1__0__Impl_in_rule__NotExpression__Group_3_1__03002 = new BitSet(new long[]{0x00000001FC600000L});
        public static final BitSet FOLLOW_rule__NotExpression__Group_3_1__1_in_rule__NotExpression__Group_3_1__03005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__NotExpression__Group_3_1__0__Impl3033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__Group_3_1__1__Impl_in_rule__NotExpression__Group_3_1__13064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NotExpression__ExpressionsAssignment_3_1_1_in_rule__NotExpression__Group_3_1__1__Impl3091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__0__Impl_in_rule__IterableExpression__Group__03125 = new BitSet(new long[]{0x0000000110000000L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__1_in_rule__IterableExpression__Group__03128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__1__Impl_in_rule__IterableExpression__Group__13186 = new BitSet(new long[]{0x0000000110000000L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__2_in_rule__IterableExpression__Group__13189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__IfEmptyAssignment_1_in_rule__IterableExpression__Group__1__Impl3216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__2__Impl_in_rule__IterableExpression__Group__23247 = new BitSet(new long[]{0x0000000000801800L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__3_in_rule__IterableExpression__Group__23250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__IterableExpression__Group__2__Impl3278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__3__Impl_in_rule__IterableExpression__Group__33309 = new BitSet(new long[]{0x0000000000801800L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__4_in_rule__IterableExpression__Group__33312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__OperandAssignment_3_in_rule__IterableExpression__Group__3__Impl3339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__4__Impl_in_rule__IterableExpression__Group__43370 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__5_in_rule__IterableExpression__Group__43373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__IterableExpression__Group__4__Impl3401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__5__Impl_in_rule__IterableExpression__Group__53432 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__6_in_rule__IterableExpression__Group__53435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group_5__0_in_rule__IterableExpression__Group__5__Impl3462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group__6__Impl_in_rule__IterableExpression__Group__63493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__IterableExpression__Group__6__Impl3521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group_5__0__Impl_in_rule__IterableExpression__Group_5__03566 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group_5__1_in_rule__IterableExpression__Group_5__03569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__ExpressionsAssignment_5_0_in_rule__IterableExpression__Group_5__0__Impl3596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group_5__1__Impl_in_rule__IterableExpression__Group_5__13626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group_5_1__0_in_rule__IterableExpression__Group_5__1__Impl3653 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group_5_1__0__Impl_in_rule__IterableExpression__Group_5_1__03688 = new BitSet(new long[]{0x00000001FC600000L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group_5_1__1_in_rule__IterableExpression__Group_5_1__03691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__IterableExpression__Group_5_1__0__Impl3719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__Group_5_1__1__Impl_in_rule__IterableExpression__Group_5_1__13750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IterableExpression__ExpressionsAssignment_5_1_1_in_rule__IterableExpression__Group_5_1__1__Impl3777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group__0__Impl_in_rule__WithExpression__Group__03811 = new BitSet(new long[]{0x000000000007E000L});
        public static final BitSet FOLLOW_rule__WithExpression__Group__1_in_rule__WithExpression__Group__03814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__WithExpression__Group__0__Impl3842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group__1__Impl_in_rule__WithExpression__Group__13873 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__WithExpression__Group__2_in_rule__WithExpression__Group__13876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__VariableAssignment_1_in_rule__WithExpression__Group__1__Impl3903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group__2__Impl_in_rule__WithExpression__Group__23933 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__WithExpression__Group__3_in_rule__WithExpression__Group__23936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__WithExpression__Group__2__Impl3964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group__3__Impl_in_rule__WithExpression__Group__33995 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__WithExpression__Group__4_in_rule__WithExpression__Group__33998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group_3__0_in_rule__WithExpression__Group__3__Impl4025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group__4__Impl_in_rule__WithExpression__Group__44056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__WithExpression__Group__4__Impl4084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group_3__0__Impl_in_rule__WithExpression__Group_3__04125 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__WithExpression__Group_3__1_in_rule__WithExpression__Group_3__04128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__ExpressionsAssignment_3_0_in_rule__WithExpression__Group_3__0__Impl4155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group_3__1__Impl_in_rule__WithExpression__Group_3__14185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group_3_1__0_in_rule__WithExpression__Group_3__1__Impl4212 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group_3_1__0__Impl_in_rule__WithExpression__Group_3_1__04247 = new BitSet(new long[]{0x00000001FC600000L});
        public static final BitSet FOLLOW_rule__WithExpression__Group_3_1__1_in_rule__WithExpression__Group_3_1__04250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__WithExpression__Group_3_1__0__Impl4278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__Group_3_1__1__Impl_in_rule__WithExpression__Group_3_1__14309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__WithExpression__ExpressionsAssignment_3_1_1_in_rule__WithExpression__Group_3_1__1__Impl4336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group__0__Impl_in_rule__AdaptExpression__Group__04370 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group__1_in_rule__AdaptExpression__Group__04373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__AdaptExpression__Group__0__Impl4401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group__1__Impl_in_rule__AdaptExpression__Group__14432 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group__2_in_rule__AdaptExpression__Group__14435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__ValueAssignment_1_in_rule__AdaptExpression__Group__1__Impl4462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group__2__Impl_in_rule__AdaptExpression__Group__24492 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group__3_in_rule__AdaptExpression__Group__24495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__AdaptExpression__Group__2__Impl4523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group__3__Impl_in_rule__AdaptExpression__Group__34554 = new BitSet(new long[]{0x00000001FD600000L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group__4_in_rule__AdaptExpression__Group__34557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group_3__0_in_rule__AdaptExpression__Group__3__Impl4584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group__4__Impl_in_rule__AdaptExpression__Group__44615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__AdaptExpression__Group__4__Impl4643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group_3__0__Impl_in_rule__AdaptExpression__Group_3__04684 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group_3__1_in_rule__AdaptExpression__Group_3__04687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__ExpressionsAssignment_3_0_in_rule__AdaptExpression__Group_3__0__Impl4714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group_3__1__Impl_in_rule__AdaptExpression__Group_3__14744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group_3_1__0_in_rule__AdaptExpression__Group_3__1__Impl4771 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group_3_1__0__Impl_in_rule__AdaptExpression__Group_3_1__04806 = new BitSet(new long[]{0x00000001FC600000L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group_3_1__1_in_rule__AdaptExpression__Group_3_1__04809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__AdaptExpression__Group_3_1__0__Impl4837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__Group_3_1__1__Impl_in_rule__AdaptExpression__Group_3_1__14868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AdaptExpression__ExpressionsAssignment_3_1_1_in_rule__AdaptExpression__Group_3_1__1__Impl4895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EqualExpression__Group__0__Impl_in_rule__EqualExpression__Group__04929 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__EqualExpression__Group__1_in_rule__EqualExpression__Group__04932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__EqualExpression__Group__0__Impl4960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EqualExpression__Group__1__Impl_in_rule__EqualExpression__Group__14991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EqualExpression__ValueAssignment_1_in_rule__EqualExpression__Group__1__Impl5018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__Root__ExpressionAssignment_15057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__InstanceExpression__ValueAssignment_15088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__AndExpression__ExpressionsAssignment_3_05119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__AndExpression__ExpressionsAssignment_3_1_15150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__OrExpresison__ExpressionsAssignment_3_05181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__OrExpresison__ExpressionsAssignment_3_1_15212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__NotExpression__ExpressionsAssignment_3_05243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__NotExpression__ExpressionsAssignment_3_1_15274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__IterableExpression__IfEmptyAssignment_15310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_rule__IterableExpression__OperandAssignment_35349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__IterableExpression__ExpressionsAssignment_5_05380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__IterableExpression__ExpressionsAssignment_5_1_15411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_rule__WithExpression__VariableAssignment_15442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__WithExpression__ExpressionsAssignment_3_05473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__WithExpression__ExpressionsAssignment_3_1_15504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__AdaptExpression__ValueAssignment_15535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__AdaptExpression__ExpressionsAssignment_3_05566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__AdaptExpression__ExpressionsAssignment_3_1_15597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EqualExpression__ValueAssignment_15628 = new BitSet(new long[]{0x0000000000000002L});
    }


}