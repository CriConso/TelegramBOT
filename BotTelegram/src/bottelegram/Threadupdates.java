/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottelegram;

import TelegramAPI.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

/**
 *
 * @author Consonni_Cristian
 */
public class Threadupdates extends Thread {

    public Threadupdates() {

    }

    @Override
    public void run() {

        String token = "5173570569:AAGDQWcSDBwUL7tvcCAuX43xRSM-Y9fgtVM";
        JParser parser = new JParser();
        JSend invia = new JSend(token);
        List idMessaggi = new ArrayList();
        Osm gestore = new Osm();

        while (true) {
            try {
                JSONObject update = JsonReader.readJsonFromUrl("https://api.telegram.org/bot" + token + "/getUpdates");
                parser.parse(update);

                int chatID = Integer.valueOf(parser.getIdChat());
                int idMessaggio = Integer.valueOf(parser.getIdMessaggio());
                String nome = parser.getNome();
                String text = parser.getText();

                if (text.startsWith("/citta") && !idMessaggi.contains(idMessaggio)) {

                    String nomeCitta = text.substring(6);
                    System.out.println(nomeCitta);
                    if (!nomeCitta.equals("")) {
                        gestore.getXml(nomeCitta);
                        gestore.getCoordinate();
                        String risposta = "Latitudine: " + gestore.getLat() + " Longitudine: " + gestore.getLon();
                        invia.sendMessage(risposta, chatID);
                        gestore.getXMLToCSV(nomeCitta, chatID, nome);
                        idMessaggi.add(idMessaggio);
                    }
                } else if(!idMessaggi.contains(idMessaggio)){
                    invia.sendMessage("Messaggio non valido",chatID);
                    idMessaggi.add(idMessaggio);
                }

                Thread.sleep(5000);

            } catch (IOException ex) {
                Logger.getLogger(Threadupdates.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(Threadupdates.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Threadupdates.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Threadupdates.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(Threadupdates.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
