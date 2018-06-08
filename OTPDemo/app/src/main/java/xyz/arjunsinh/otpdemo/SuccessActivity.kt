package xyz.arjunsinh.otpdemo

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.Button

class SuccessActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        val repeatButton = findViewById<Button>(R.id.repeatButton)

        repeatButton.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }

}
