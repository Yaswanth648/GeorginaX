package com.example.Helpers;

import com.example.Bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class delMsg extends Bot {
    public void deleteMsg(Update update, int mId) {
        try {
            execute(new DeleteMessage(chatId(update), mId));
            SendMessage sMessage = new SendMessage(chatId(update), "Deleted Message Succesfully");
            Message message = execute(sMessage);
            try {
                Thread.sleep(1500);
                execute(new DeleteMessage(chatId(update), message.getMessageId()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (TelegramApiException e) {
            sendMessage(update, "I Don't have enough right's to execute this command");
            e.printStackTrace();
        }
    }
}
