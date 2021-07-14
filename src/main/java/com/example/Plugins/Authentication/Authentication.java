package com.example.Plugins.Authentication;

import java.io.IOException;
import com.example.Bot;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Authentication extends Bot {
    public void getUserProfilePic(String username, Update update) throws IOException {
        Document doc = (Document) Jsoup.connect("https://www.instagram.com/" + username.trim()).get();
        // Document doc = (Document) Jsoup.connect("https://www.instagram.com/" +
        // username).get();
        // Document doc = (Document) Jsoup.connect("https://www.instagram.com/" +
        // username);

        // Elements el = doc.getElementsByTag("div");
        // Elements i = el.attr("class", "_8gpiy _r43r5");
        // String link = i.attr("src");
        // String img = el.attr("src");
        String title = doc.title();
        System.out.println(title);
        // System.out.println(link);
        // System.out.println(img);

        String info = doc.getElementsByAttributeValueMatching("property", "og:description").toString();

        String infos = info.substring(41, info.length() - 2);
        // System.out.println(infos);
        // sendMsg(chatid, infos);
        sendMessage(update, parse(infos));
        // sendmsg(infos, chatid);
        /*
         * System.out.println( images.attr("content",
         * String.valueOf(Pattern.matches("(https.*\\\\.jpg)", images.toString()))));
         */
        /*
         * String keywords = doc.select("meta[name=keywords]").get(0).attr("content");
         * System.out.println(keywords);
         * 
         * String description = doc.getElementsByTag("meta").attr("property",
         * "og:description").toString(); System.out.println(description); String urllong
         * = doc.getElementsByAttributeValueMatching("content",
         * "(https.*\\.jpg)").toString(); String t = urllong; String sublink =
         * t.substring(41, t.length() - 2); String finallink =
         * sublink.replaceFirst("(150x150)", "1080*1080"); //
         * System.out.println(finallink); sendMsg(chatid, finallink);
         */
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

