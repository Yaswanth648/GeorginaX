package com.example.Plugins;

import com.example.Bot;
import com.example.Master;
import com.example.Helpers.Insta;
import com.example.Helpers.outgoingArguments;

import org.telegram.telegrambots.meta.api.objects.Update;

public class instagram extends Bot implements Master{

    @Override
    public void handleRequests(Update update, String cmd) {
        String arg = new outgoingArguments().getOutgoingArguments(cmd, getHandler()+"insta ");
        if(cmd.equalsIgnoreCase(getHandler()+"insta "+arg)){
            Insta i = new Insta();
            String name = i.getAccountName(arg);
            if(name != null) sendMessage(update, "Name :- "+name);
            else sendMessage(update, "Invalid Username");
        }
        
    }
    
}
