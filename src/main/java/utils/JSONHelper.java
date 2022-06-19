package utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONHelper {
    public String getAttributeFromJSON(String jsonPath, String attribute) {
        FileReader reader = null;
        try {
            reader = new FileReader(jsonPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object obj = JSONValue.parse(reader);
        JSONObject jsonObject = (JSONObject) obj;
        return (String) jsonObject.get(attribute);
    }
}
