package com.example.Plugins.Greetings;

import com.example.Bot;
import com.example.Master;
import com.example.Helpers.sendPic;

import org.telegram.telegrambots.meta.api.objects.Update;

public class welcome extends Bot implements Master{

    @Override
    public void handleRequests(Update update, String cmd) {
        if(cmd.equalsIgnoreCase(getHandler()+"start")){
            new sendPic().sendpic(update, "src/main/java/com/example/assets/res/georgina.png", "Welcome to Georgina Bot");
            //sendMessage(update, "Welcome to Georgina Bot");
        }
        
    }
    
}
