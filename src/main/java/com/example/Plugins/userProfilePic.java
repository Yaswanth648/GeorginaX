package com.example.Plugins;

import java.io.IOException;

import com.example.Bot;
import com.example.Master;
import com.example.Helpers.sendAction;
import com.example.Plugins.Authentication.Authentication;

import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.objects.Update;

public class userProfilePic extends Bot implements Master {

    @Override
    public void handleRequests(Update update, String cmd) {
        if (cmd.equalsIgnoreCase(getHandler() + "insta " + cmd.replace(getHandler() + "insta ", ""))) {
            String username = cmd.replace(getHandler() + "insta ", "");
            sendAction s = new sendAction();
            s.sendChatAction(update.getMessage().getChatId().toString(), ActionType.UPLOADDOCUMENT);
            Authentication a = new Authentication();
            try {
                a.getUserProfilePic(username, update);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
