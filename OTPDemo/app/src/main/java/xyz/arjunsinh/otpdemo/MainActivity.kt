package xyz.arjunsinh.otpdemo

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import xyz.arjunsinh.otpdemo.R

class MainActivity : Activity() {

    var phoneNumber: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryCodeInput = findViewById<EditText>(R.id.countryCodeInput)
        val phoneInput = findViewById<EditText>(R.id.phoneNoInput)
        val submitButton = findViewById<Button>(R.id.submitButton)

        countryCodeInput.isEnabled=false

        submitButton.setOnClickListener {
            //Toast.makeText(this, "Number requested:" + phoneInput.text, Toast.LENGTH_SHORT).show()
            phoneNumber = phoneInput.text.toString()
            if (phoneNumber?.length == 10) {
                showAlertDialog(10)
            } else
                showAlertDialog()
        }
    }

    fun showAlertDialog(mode: Int = 0) {
        val dialogBuilder = AlertDialog.Builder(this).create()
        dialogBuilder.setCancelable(true)
        if (mode == 10) {
            dialogBuilder.setMessage("We will be verifying the phone number:\n\n$phoneNumber\n\nIs this OK, or would you like to edit the number?")
            dialogBuilder.setButton(AlertDialog.BUTTON_POSITIVE, "YES", {
                _, _ ->
                SendNumber(applicationContext,phoneNumber)
            })
            dialogBuilder.setButton(AlertDialog.BUTTON_NEUTRAL, "Edit", {
                _, _ ->
            })
        } else {
            dialogBuilder.setMessage("Phone Number should contain 10 digits.")
            dialogBuilder.setButton(AlertDialog.BUTTON_POSITIVE, "OK", { _, _ -> })
        }
        dialogBuilder.show()
    }

}
