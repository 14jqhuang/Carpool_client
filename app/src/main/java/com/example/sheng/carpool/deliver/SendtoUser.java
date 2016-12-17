package com.example.sheng.carpool.deliver;

import android.util.Log;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The class used to send send signal to server to send the notification to
 * Created by tomyca on 12/17/16.
 */
public class SendtoUser {

    /**
     * Constructor without param.
     */
    public SendtoUser(){}

    /**
     *
     * @param message format: 1--type=[d]&username(s).([d] means number)
     * @throws Exception
     */
    public void sendToUser(String message)
    {
        String url = "http://10.21.26.32:8088/notification.do?action=send";
        try {
            URL url2 = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            String param = message;
            byte[] sendParam = param.getBytes("UTF-8");
            OutputStream out = httpURLConnection.getOutputStream();
            out.write(sendParam);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
            Log.d("SendtoUser: ","wrong here");
        }
    }
}
