package org.eclipse.escriptmonkey.scripting.engine.python.jython;

import org.python.core.PyObject;

public class JythonTracer extends PyObject {

	@Override
	public PyObject __call__(final PyObject arg0, final PyObject arg1, final PyObject arg2) {
		if("call".equals(arg1.toString())) {
			// call
			//			return super.__call__(arg0, arg1, arg2);
		} else {
			//			return super.__call__(arg0, arg1, arg2);
		}

		return this;
	}
}
