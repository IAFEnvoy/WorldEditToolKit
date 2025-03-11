package com.iafenvoy.wetk.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {
    public static String readByLines(InputStreamReader stream) throws IOException {
        BufferedReader in = new BufferedReader(stream);
        StringBuilder buffer = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null)
            buffer.append(line).append("\n");
        return buffer.toString();
    }

    public static JsonObject readResourceAsJson(String path) {
        try {
            InputStream listFile = FileUtil.class.getResourceAsStream(path);
            assert listFile != null;
            String data = FileUtil.readByLines(new InputStreamReader(listFile));
            return JsonParser.parseString(data).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
