package com.example.marvecomicssearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import android.util.Log;
import java.security.MessageDigest;

public class GetResponse {
    /**public static String excutePost(String targetURL, String urlParameters)
    {
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream ());
            wr.writeBytes (urlParameters);
            wr.flush ();
            wr.close ();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }*/
    private int i = 0;
    private String myWholeKey = "240dd8655edafdcf8740ac4aa5afb0adf35400c4c79aa88beaa09e722e51ed4c4dd8747c";
    public void getResponse(final String input) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    /* get the actual url*/
                    String urll = "https://gateway.marvel.com:443/v1/public";
                    String apiKey = "&apikey=c79aa88beaa09e722e51ed4c4dd8747c";
                    i++;
                    String timestamp = "?ts=" + i;
                    String toHash = i + myWholeKey;
                    String name = "&name=" + input;
                    /* generate hash*/
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte[] messageDigest = md.digest(toHash.getBytes());
                    BigInteger number = new BigInteger(1, messageDigest);
                    String hash = number.toString(16);
                    // Now we need to zero pad it if you actually want the full 32 chars.
                    while (hash.length() < 32) {
                        hash = "0" + hash;
                    }
                    hash = "&hash=" + hash;
                    /* post process*/
                    urll += "/characters" + timestamp + apiKey + hash + name;
                    URL url = new URL(urll);
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                    String strTemp = "";
                    Log.v("what", "at least running");
                    while (null != (strTemp = br.readLine())) {
                        System.out.println(strTemp);
                        Log.v("try", strTemp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

}
