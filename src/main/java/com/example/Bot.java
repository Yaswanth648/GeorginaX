package com.example;

import com.example.Helpers.configutation;
import com.example.Plugins.Add;
import com.example.Plugins.eval;
import com.example.Plugins.userProfilePic;
import com.example.Plugins.Greetings.welcome;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        String cmd = update.getMessage().getText();
        if (update.hasMessage() && cmd.startsWith(getHandler())) {
            sendRequest(update, cmd);
        }
    }

    public void sendRequest(Update update, String cmd) {
        new welcome().handleRequests(update, cmd);
        new userProfilePic().handleRequests(update, cmd);
        new Add().handleRequests(update, cmd);
        new eval().handleRequests(update, cmd);
    }

    public String getHandler() {
        return configutation.handler;
    }

    public String chatId(Update update) {
        return update.getMessage().getChatId().toString();
    }

    public Message sendMessage(Update update, String text) {
        Message m;
        SendMessage sMessage = new SendMessage(chatId(update), text);

        try {
            m = execute(sMessage);
            return m;
        } catch (TelegramApiException e) {
            e.getMessage();
        }

        return null;
    }

    @Override
    public String getBotUsername() {
        String s = configutation.botUserName;
        return s;
    }

    @Override
    public String getBotToken() {
        String s = configutation.botToken;
        return s;
    }

}
