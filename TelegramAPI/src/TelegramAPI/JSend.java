/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

import TelegramAPI.JsonReader;
import java.io.IOException;
import org.json.JSONObject;
//import org.json.JSONArray;
import org.json.JSONException;
/**
 *
 * @author Consonni_Cristian
 */
public class JSend {
    
    String token;
    
    public JSend(String token){
        this.token = token;
    }
    
    public void sendMessage(String text, int chatID) throws JSONException, IOException{
        JSONObject send = JsonReader.readJsonFromUrl("https://api.telegram.org/bot" + token + "/sendMessage?chat_id=" + chatID + "&text=" + text);
    }
}

