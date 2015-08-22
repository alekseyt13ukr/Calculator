package com.taran.leason1.model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Number {

    public String countPhrase(String mathString) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String result = mathString;
        String resultNumber =  engine.eval(result).toString();
        return resultNumber;
    }
}
