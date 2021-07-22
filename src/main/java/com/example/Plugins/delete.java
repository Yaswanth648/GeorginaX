package com.example.Plugins;

import com.example.Bot;
import com.example.Master;
import com.example.Helpers.delMsg;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class delete extends Bot implements Master{

    @Override
    public void handleRequests(Update update, String cmd) {
        if(cmd.equalsIgnoreCase(getHandler()+"del") && update.getMessage().isReply()){
            Message m = update.getMessage().getReplyToMessage();

            // Delete The message
            new delMsg().deleteMsg(update, m.getMessageId());
        }
        
    }

    
}
