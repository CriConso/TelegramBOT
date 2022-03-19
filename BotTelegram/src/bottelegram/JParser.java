/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottelegram;

/*import TelegramAPI.JsonReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;*/
import org.json.JSONArray;
//import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Consonni_Cristian
 */
public class JParser {

    String idMessaggio;
    String nome;
    String idChat;
    String text;

    public JParser() {
    }

    public void parse(JSONObject update) {
        JSONArray jArray = update.getJSONArray("result");

        for (int i = 0; i < jArray.length(); i++) {

            idMessaggio = jArray.getJSONObject(i).getJSONObject("message").get("message_id").toString();
            nome = jArray.getJSONObject(i).getJSONObject("message").getJSONObject("from").get("first_name").toString();
            idChat = jArray.getJSONObject(i).getJSONObject("message").getJSONObject("chat").get("id").toString();
            text = jArray.getJSONObject(i).getJSONObject("message").get("text").toString();
        }
    }

    public String getIdMessaggio() {
        return idMessaggio;
    }

    public String getNome() {
        return nome;
    }

    public String getIdChat() {
        return idChat;
    }

    public String getText() {
        return text;
    }

    

}
