package com.carlsberg_stack.robolectricsampletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var login = findViewById<Button>(R.id.login);
        var emailAddress = findViewById<EditText>(R.id.email_address);
        login.setOnClickListener {
            if(EmailValidator.isValidEmail(emailAddress.text.toString())){
                val intent = Intent(this, WelcomeActivity::class.java);
                startActivity(intent)
            } else {
                emailAddress.error = getString(R.string.err_invalid_email_address);
            }
        }
    }
}