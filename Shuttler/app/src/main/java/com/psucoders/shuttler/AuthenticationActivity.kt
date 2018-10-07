package com.psucoders.shuttler

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_authentication.*

class AuthenticationActivity : AppCompatActivity() {
    private val currentUser = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)


        btnVerified.setOnClickListener {
            if (currentUser?.isEmailVerified == true) {
                val intent = Intent(this, TrackerActivity::class.java)
                startActivity(intent)
            }
            else {
                Snackbar.make(rootLayoutAuthentication, "Please verify your account", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        currentUser?.reload()
        currentUser?.getIdToken(true)
    }


}
