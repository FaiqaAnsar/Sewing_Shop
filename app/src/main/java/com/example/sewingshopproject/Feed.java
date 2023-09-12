package com.example.sewingshopproject;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Feed {
    private String name;
    private String msg;

    public Feed() {
    }

    public Feed(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }
}
