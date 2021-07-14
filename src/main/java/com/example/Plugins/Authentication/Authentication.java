package com.example.Plugins.Authentication;

import java.io.IOException;
import com.example.Bot;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Authentication extends Bot {
    public void getUserProfilePic(String username, Update update) throws IOException {
        Document doc = (Document) Jsoup.connect("https://www.instagram.com/" + username.trim()).get();

        String title = doc.title();
        System.out.println(title);


        String info = doc.getElementsByAttributeValueMatching("property", "og:description").toString();

        String infos = info.substring(41, info.length() - 2);

        sendMessage(update, parse(infos));

    }

    public String parse(String s) {
        int index = 0;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        int index5 = 0;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) + "").equals("F")) {
                index = i;
                break;
            }
        }
        String Followers = s.substring(0, index);

        for (int i = index + 1; i < s.length(); i++) {
            if (s.charAt(i) == 'F') {
                index2 = i;
                break;
            }
        }
        String Following = s.substring(index + 10, index2);

        for (int i = index2 + 1; i < s.length(); i++) {
            if (s.charAt(i) == 'P') {
                index3 = i;
                break;
            }
        }
        String posts = s.substring(index2 + 10, index3);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'm') {
                counter++;
                if (counter >= 2) {
                    index4 = i;
                    break;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                index5 = i;
                break;
            }
        }

        String name = s.substring(index4 + 1, index5);

        return "Information Fetched From " + name + "\nFollowers - " + Followers + "\nFollowing - " + Following
                + "\nPosts - " + posts + "\nLink to Profile - https://instagram.com/"
                + s.substring(index5 + 2, s.length() - 1);
    }
}

