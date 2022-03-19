/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottelegram;

import TelegramAPI.*;
import static TelegramAPI.JsonReader.readJsonFromUrl;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author Consonni_Cristian
 */
public class BotTelegram {

    

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Threadupdates tu = new Threadupdates();
        tu.start();
  
    }
}
