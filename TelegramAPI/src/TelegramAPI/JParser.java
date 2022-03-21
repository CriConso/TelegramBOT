/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

/*import TelegramAPI.JsonReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;*/
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
//import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Consonni_Cristian
 */
public class JParser {

    List<Integer> idMessaggi = new ArrayList<>();
    int idMessaggio;
    String nome;
    int idChat;
    String text;
    int updateID;
    URL url;
    Scanner s;

    public JParser() {
    }

    public void parse(JSONObject update, String token) throws MalformedURLException, IOException {
        JSONArray jArray = update.getJSONArray("result");

        if (jArray.length() > 0) {
            for (int i = 0; i < jArray.length(); i++) {

            idMessaggio = jArray.getJSONObject(i).getJSONObject("message").getInt("message_id");
            idMessaggi.add(idMessaggio);
            
            nome = jArray.getJSONObject(i).getJSONObject("message").getJSONObject("from").get("first_name").toString();
            
            idChat = jArray.getJSONObject(i).getJSONObject("message").getJSONObject("chat").getInt("id");
            
            text = jArray.getJSONObject(i).getJSONObject("message").getString("text");
            
        }
        updateID = jArray.getJSONObject(jArray.length() - 1).getInt("update_id");

        url = new URL("https://api.telegram.org/bot" + token + "/getUpdates?offset=" + (updateID + 1));
        s = new Scanner(url.openStream());
        s.next();
        }
    }

    public int getIdMessaggio() {
        return idMessaggio;
    }

    public String getNome() {
        return nome;
    }

    public int getIdChat() {
        return idChat;
    }

    public String getText() {
        return text;
    }

}
