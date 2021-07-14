package com.example.Helpers;

import java.io.IOException;
import me.postaddict.instagram.scraper.Instagram;
import me.postaddict.instagram.scraper.cookie.CookieHashSet;
import me.postaddict.instagram.scraper.cookie.DefaultCookieJar;
import me.postaddict.instagram.scraper.interceptor.ErrorInterceptor;
import me.postaddict.instagram.scraper.model.Account;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class Insta{
    public String getAccountName(String username){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
        .addNetworkInterceptor(loggingInterceptor)
        .addInterceptor(new ErrorInterceptor())
        .cookieJar(new DefaultCookieJar(new CookieHashSet()))
        .build();

        Instagram instagram = new Instagram(httpClient);
        Account account;

        try {
            account = instagram.getAccountByUsername("Kevin");
            System.out.println(account.getMedia().getCount());
            //return account.getFullName();
            return account.getMedia().getCount().toString();
        } catch (IOException e) {
            return null;
        }
    }
}
