package fr.mtp.epsi.save;

import android.app.Activity;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by pallier04 on 22/05/2014.
 */
public class WebService extends Activity {
    private RequestQueue _volleyQueue;

    public WebService(){
        _volleyQueue = Volley.newRequestQueue(this);
        downloadDataFromUrl("http://www.google.com");
    }

    public void download(){


    }

    public void downloadDataFromUrl(String url) {

        StringRequest req = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
               // Toast.makeText(MainActivity.this,volleyError.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
        _volleyQueue.add(req);
    }
}
