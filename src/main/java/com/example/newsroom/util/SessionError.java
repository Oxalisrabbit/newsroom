package com.example.newsroom.util;

import java.util.HashMap;
import java.util.Map;

public class SessionError {

    public static Map<String, Object> AdminError(int role){
        Map<String, Object> result = new HashMap<>();
        if(role != 0){
            result.put("result",0);
            result.put("error","您不是管理员，权限不足");
            return result;
        }
        return result;
    }

}
