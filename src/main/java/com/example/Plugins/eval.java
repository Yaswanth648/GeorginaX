package com.example.Plugins;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import com.example.Bot;
import com.example.Master;
import org.telegram.telegrambots.meta.api.objects.Update;

public class eval extends Bot implements Master {

    @Override
    public void handleRequests(Update update, String cmd) {
        String t = update.getMessage().getText().replace(getHandler() + "eval ", "");
        System.out.println(t);
        if (cmd.equalsIgnoreCase(getHandler() + "eval " + t)) {
            String i = evalExpression(t);
            sendMessage(update, "Result  =  " + i);
        }
    }

    public String evalExpression(String t) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            System.out.println(engine.eval(t));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        try {
            return engine.eval(t).toString();
        } catch (NumberFormatException | ScriptException e) {
            e.printStackTrace();
        }
        return "Error Occured";
    }

}
