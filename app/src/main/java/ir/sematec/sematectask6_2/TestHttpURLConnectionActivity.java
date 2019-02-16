package ir.sematec.sematectask6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestHttpURLConnectionActivity<string> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_http_urlconnection);

        final String url = "https://api.aladhan.com/v1/timingsByCity?city=Tehran&country=Iran&method=8";
        new Thread(new Runnable() {
            private final Object S = " ";

            @Override
            public void run() {

        try {
            URL obj = new URL("https://google.com");

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));

                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }


                System.out.println(response.toString());
                
                JSONObject object = new JSONObject(response.toString());
                String s = object.getString("data");
                
                JSONObject object1 = new JSONObject((String) S);
                String s1 = object1.getString("timings");
                
                JSONObject object2 = new JSONObject(s1);
                String s2 = object2.getString("MAGHRIB");

                Log.d("MAGHRIB",s2);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            }
        }).start();
    }
}
