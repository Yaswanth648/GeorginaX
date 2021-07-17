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
                update.getMessage().getFrom();
                long userId = user.getId();

                try {
                    PromoteChatMember promoteChatMember = new PromoteChatMember(chatId(update), userId);
                    boolean ifadmin = promoteChatMember.getCanPromoteMembers();

                    if (ifadmin)
                        sendMessage(update, user.getFirstName() + " is already Administrator in this Chat.");

                    // Permissions Granted to the User

                    else {
                        // promoteChatMember.setCanChangeInformation(true);
                        promoteChatMember.setCanDeleteMessages(true);
                        promoteChatMember.setCanEditMessages(true);
                        promoteChatMember.setCanInviteUsers(true);
                        // promoteChatMember.setCanManageChat(true);
                        // promoteChatMember.setCanManageVoiceChats(true);
                        promoteChatMember.setCanPinMessages(true);
                        promoteChatMember.setCanPostMessages(true);
                        // promoteChatMember.setCanRestrictMembers(true);

                        boolean res = execute(promoteChatMember);
                        if (res)
                            sendMessage(update, user.getFirstName() + " is Promoted Successfully");
                        else
                            sendMessage(update, "Error Promoting user");
                    }

                } catch (Exception e) {
                    sendMessage(update, e.getMessage());
                }
            }
        }
    }
}
