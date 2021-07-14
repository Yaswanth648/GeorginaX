package com.example.Helpers;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class configutation {
    private final Dotenv dotenv = new DotenvBuilder().ignoreIfMissing().load();

    public String botToken = dotenv.get("botToken");
    public String botUserName = dotenv.get("botUserName");
    public String handler = dotenv.get("handler");
}
