package com.example.Plugins;

import com.example.Bot;
import com.example.Master;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.telegram.telegrambots.meta.api.objects.Update;

public class covidData extends Bot implements Master{

    @Override
    public void handleRequests(Update update, String cmd) {
        if(cmd.equalsIgnoreCase(getHandler()+"covid")){
            try {
                HttpResponse<String> response = Unirest.get("https://covid-19-data.p.rapidapi.com/country/all")
                .header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .asString();
                //response.getBody();
                sendMessage(update, response.getBody());
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
