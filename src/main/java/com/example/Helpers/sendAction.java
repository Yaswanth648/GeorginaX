package com.example.Helpers;

import com.example.Bot;
import com.example.Master;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class sendAction extends Bot implements Master {

    @Override
    public void handleRequests(Update update, String cmd) {
        if (cmd.equalsIgnoreCase(getHandler() + "sendhi")) {
            sendChatAction(update.getMessage().getChatId().toString(), ActionType.FINDLOCATION);
        }
    }

    public void sendChatAction(String chatId, ActionType action) {
        SendChatAction s = new SendChatAction();
        s.setChatId(chatId);
        s.setAction(action);

        try {
            execute(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}
