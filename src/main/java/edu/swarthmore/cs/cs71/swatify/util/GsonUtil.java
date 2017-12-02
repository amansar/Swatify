package edu.swarthmore.cs.cs71.swatify.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GsonUtil {
    private static final Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static <T> T fromJson(Class<T> objectClass, String json) {
        return gson.fromJson(json, objectClass);
    }

    public static SecretsUtil readSecretsFromJsonFile(String filename){
        BufferedReader reader = null;
        try {
            System.out.println(new File(".").getAbsoluteFile());
            reader = new BufferedReader(new FileReader("src/main/resources/secrets.json"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        SecretsUtil secrets = gson.fromJson(reader, SecretsUtil.class);
        return secrets;
    }
}
