package com.example.Plugins;

import com.example.Bot;
import com.example.Master;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.telegram.telegrambots.meta.api.objects.Update;

public class translate extends Bot implements Master {

    @Override
    public void handleRequests(Update update, String cmd) {
        String language_code = cmd.replace(getHandler() + "tr ", "");
        if (cmd.equalsIgnoreCase(getHandler() + "tr " + language_code)) {
            try {
                HttpResponse<String> response = Unirest
                        .post("https://google-translate1.p.rapidapi.com/language/translate/v2")
                        .header("content-type", "application/x-www-form-urlencoded")
                        .header("accept-encoding", "application/gzip")
                        .header("x-rapidapi-key", "af27998622mshee39756f420f221p167084jsn884f347da58c")
                        .header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
                        .body("q=Hello%2C%20world!&target=es&source="+language_code).asString();

                sendMessage(update, response.getBody());
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }

    }

}
