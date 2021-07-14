package com.example.Plugins.Greetings;

import com.example.Bot;
import com.example.Master;

import org.telegram.telegrambots.meta.api.objects.Update;

public class welcome extends Bot implements Master{

    @Override
    public void handleRequests(Update update, String cmd) {
        if(cmd.equalsIgnoreCase(getHandler()+"start")){
            sendMessage(update, "Welcome to Georgina Bot");
        }
        
    }
    
}
