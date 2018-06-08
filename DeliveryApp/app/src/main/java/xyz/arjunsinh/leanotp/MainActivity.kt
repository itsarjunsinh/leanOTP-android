package xyz.arjunsinh.leanotp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import xyz.arjunsinh.leanotpsms.WebHandler


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<FloatingActionButton>(R.id.checkOtpButton)
        button.setOnClickListener {
            WebHandler(applicationContext, 1)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.getItemId()) {
            R.id.clearQueue -> {
                WebHandler(applicationContext, 0);
                return true
            }
            R.id.requestPermission -> {
                if (ContextCompat.checkSelfPermission(applicationContext,
                                Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), 2)
                }

                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
