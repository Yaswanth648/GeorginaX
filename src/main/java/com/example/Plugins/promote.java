package com.example.Plugins;

import com.example.Bot;
import com.example.Master;

import org.telegram.telegrambots.meta.api.methods.groupadministration.PromoteChatMember;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class promote extends Bot implements Master {

    @Override
    public void handleRequests(Update update, String cmd) {
        if (update.getMessage().getReplyToMessage().getText().equals(getHandler() + "promote")) {
            Message replymsg = update.getMessage().getReplyToMessage();
            User user = replymsg.getFrom();
            long userId = user.getId();
            try {
                PromoteChatMember promoteChatMember = new PromoteChatMember(chatId(update), userId);
                execute(promoteChatMember);
            } catch (Exception e) {
                sendMessage(update, "I should be Admin Here to promote memebers.");
            }
        }

    }

}
