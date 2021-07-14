package com.example.Helpers;

public class outgoingArguments {
    public String getOutgoingArguments(String msg, String cmd){
        return msg.replace(cmd, "");
    }
}
