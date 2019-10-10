package com.labyspring.GalleryApplication.model;

import org.json.simple.JSONObject;

public class Response {

    public static String result(boolean result){
        JSONObject r = new JSONObject();
        r.put("result", result);
        return r.toString();
    }
}
