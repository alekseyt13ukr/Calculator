package com.taran.lesson1.model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CountNumber {

    public String countPhrase(String mathString) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String result = mathString;
        String resultNumber = null;
        try {
            resultNumber = engine.eval(result).toString();
        } catch (ScriptException e) {
            resultNumber = "Incorrect phrase for counting";
        }
        return resultNumber;
    }
}
