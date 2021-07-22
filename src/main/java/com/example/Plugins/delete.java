package com.example.Plugins;

import com.example.Bot;
import com.example.Master;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class delete extends Bot implements Master{

    @Override
    public void handleRequests(Update update, String cmd) {
        if(cmd.equalsIgnoreCase(getHandler()+"del") && update.getMessage().isReply()){
            Message m = update.getMessage().getReplyToMessage();
            DeleteMessage deleteMessage = new DeleteMessage(chatId(update), m.getMessageId());
            try {
                sendMessage(update, "Delete Message Successfully");
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        
    }

    
}
