package xyz.arjunsinh.leanotpsms

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

/**
 * Created by arjunsinh on 6/15/17.
 */

class WebHandler internal constructor(context: Context, option: Int) {
    init {

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        val DELIVERY_KEY = "A1231B34634D3489"

        var url = "https://lean-otp.herokuapp.com/getNumber.php?deliverykey=$DELIVERY_KEY"
        if (option == 0) {
            url = "https://lean-otp.herokuapp.com/clearQueue.php?deliverykey=$DELIVERY_KEY"
        }

        val finalUrl = url

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener { response ->
                    Log.d("Response:", response)
                    if (option == 0) {
                        Toast.makeText(context, "Successfully cleared Queue", Toast.LENGTH_SHORT).show()
                    } else if (option == 1) {
                        if (response.isEmpty()) {
                            Toast.makeText(context, "Queue is empty", Toast.LENGTH_SHORT).show()
                        } else {
                            try {
                                val number = response.substring(0, 10)
                                val otp = response.substring(10, 16)
                                Toast.makeText(context, "Sending OTP: $otp to: $number", Toast.LENGTH_SHORT).show()
                                SendOTP.send(number, otp)
                            } catch (e: Exception) {
                                Toast.makeText(context, "Queue might be empty.", Toast.LENGTH_SHORT).show()
                            }

                        }
                    }
                }, Response.ErrorListener { Toast.makeText(context, "Could not connect to: $finalUrl", Toast.LENGTH_SHORT).show() })
        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}
