package com.example.Helpers;

import java.io.File;

import com.example.Bot;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class sendPic extends Bot {

    public void sendpic(Update update, String caption){
        InputFile inputFile = new InputFile(new File("src/main/java/com/example/assets/res/georgina.png"));
        SendPhoto photo = new SendPhoto(chatId(update), inputFile);
        photo.setCaption(caption);

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
}
