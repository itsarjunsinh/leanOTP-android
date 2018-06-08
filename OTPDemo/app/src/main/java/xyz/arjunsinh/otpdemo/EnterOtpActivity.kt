package xyz.arjunsinh.otpdemo

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton

class EnterOtpActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_otp)

        val INTENT_NUM = "getNumber"
        val phoneNumber = intent.getStringExtra(INTENT_NUM)

        actionBar!!.title = "Verify +91$phoneNumber"

        val otpCodes: IntArray = intArrayOf(321729, 456892, 791146, 125269, 883692, 104291, 368437, 124727, 567836, 729384, 902162, 482972, 811296)
        val submitOtpButton = findViewById<ImageButton>(R.id.submitOtpButton)
        val otpInput = findViewById<EditText>(R.id.otpInput)
        submitOtpButton.setOnClickListener {
            if (otpCodes.contains(Integer.parseInt(otpInput.text.toString()))) {
                val intent = Intent(applicationContext, SuccessActivity::class.java)
                startActivity(intent)
            } else {
                val dialogBuilder = AlertDialog.Builder(this).create()
                dialogBuilder.setMessage("The OTP is invalid.\nCheck the sent OTP and retry or restart setup.")
                dialogBuilder.setButton(AlertDialog.BUTTON_POSITIVE, "OK", { _, _ -> })
                dialogBuilder.show()
            }
        }
    }

}
