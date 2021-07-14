package com.example.Plugins;

import java.util.ArrayList;
import java.util.List;
import com.example.Bot;
import com.example.Master;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Add extends Bot implements Master {

    @Override
    public void handleRequests(Update update, String cmd) {
        String t = update.getMessage().getText().replace(getHandler() + "add ", "");
        System.out.println(t);
        boolean isChutiya = false;
        if (cmd.equalsIgnoreCase(getHandler() + "add " + t)) {
            String t2 = "";
            String t3 = "";

            int c = 0;
            int res = 0;
            List<Integer> list = new ArrayList<Integer>();
            t += " ";
            int length = t.length();
            for (int i = 0; i < length; i++) {
                String str = t.charAt(c) + "";
                if (str.equals("")) {
                    System.out.println(t2);
                    list.add(Integer.parseInt(t2.trim()));
                    res += Integer.parseInt(t2.trim());
                    t2 = "";
                    t.replace(t3, "");
                } else {
                    if (Character.isAlphabetic(t.charAt(c))) {
                        sendMessage(update, "Numbers Expected\nEntered Alphabect");
                        isChutiya = true;
                        break;
                    } else {
                        t2 += t.charAt(c);
                        t3 += t.charAt(c);
                    }
                }
                c++;
            }
            System.out.println(res);
            if (!isChutiya)
                sendMessage(update, "Sum  =  " + res);
        }

    }

}
