package xyz.arjunsinh.otpdemo;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by arjunsinh on 6/15/17.
 */

public class SendNumber {
    SendNumber(final Context context, final String phoneNumber) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String CLIENT_KEY = "BR7234HT3471NM906";
        String url = "https://lean-otp.herokuapp.com/requestOTP.php?qnum="+phoneNumber+"&clientkey="+CLIENT_KEY;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        String INTENT_NUM = "getNumber";
                        Intent intent = new Intent(context, EnterOtpActivity.class);
                        intent.putExtra(INTENT_NUM, phoneNumber);
                        context.startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Could not request OTP. Try again.", Toast.LENGTH_SHORT).show();
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
