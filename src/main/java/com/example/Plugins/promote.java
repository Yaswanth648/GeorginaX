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
        if (update.getMessage().getChat().isUserChat())
            sendMessage(update, "This command can only be used in Group Chats.");
        else {
            if (update.getMessage().isReply() && cmd.equalsIgnoreCase(getHandler() + "promote")) {
                Message replymsg = update.getMessage().getReplyToMessage();
                User user = replymsg.getFrom();
                long userId = user.getId();

                try {
                    PromoteChatMember promoteChatMember = new PromoteChatMember(update.getMessage().getChatId().toString(), userId, false, true, true, true, true, true, true, false, false, true, true);
                    execute(promoteChatMember);
                    sendMessage(update, user.getFirstName() + " is Promoted Successfully");
                } catch (Exception e) {
                    sendMessage(update, e.getMessage());
                }
            }
        }
    }
}
