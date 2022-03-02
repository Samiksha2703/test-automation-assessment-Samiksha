package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pageobjects.User;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JSONUtil {
    public static String sysPath = System.getProperty("user.dir");

    public static ArrayList<User> getValue() {
        ArrayList<User> userData = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(sysPath + "\\src\\main\\resources\\users.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String userName = (String) jsonObject.get("username");
            String password = (String) jsonObject.get("password");
            String skill = (String) jsonObject.get("skill");
            String details = (String) jsonObject.get("Programming and Application Development");
            userData.add(new User(userName, password, skill, details));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return userData;
    }
}