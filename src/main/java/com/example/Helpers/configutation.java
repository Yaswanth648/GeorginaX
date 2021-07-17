package com.example.Helpers;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class configutation {

    private static final Dotenv dotenv = new DotenvBuilder().ignoreIfMissing().load();

    public static String botToken = dotenv.get("botToken");
    public static String botUserName = dotenv.get("botUserName");
    public static String handler = dotenv.get("handler");
    public static String rapidXapi = dotenv.get("af27998622mshee39756f420f221p167084jsn884f347da58c");
}