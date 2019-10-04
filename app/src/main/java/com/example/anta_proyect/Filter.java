package com.example.anta_proyect;

import java.util.HashMap;
import java.util.Map;

public class Filter {
    Map<String, String> Index = new HashMap<String, String>();
    Filter(){
        Code();
    }
    void Code(){
        Index.put("offset","3");
        Index.put("items","50");
        Index.put("sort","title,asc");
    }
    void Name(){
        Index.put("offset","3");
        Index.put("items","50");
        Index.put("sort","title,asc");
    }

}
