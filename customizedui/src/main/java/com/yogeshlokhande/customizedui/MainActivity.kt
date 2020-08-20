package com.yogeshlokhande.customizedui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.inappmessaging.FirebaseInAppMessaging
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
import com.google.firebase.inappmessaging.model.InAppMessage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firebaseInAppMessageDisplay =
            FirebaseInAppMessagingDisplay { inAppMessage, displayCallbacks ->
                val alertDialog = AlertDialog.Builder(this@MainActivity)
                alertDialog.setTitle("Custom UI Title :" + inAppMessage.title!!.text)
                alertDialog.setMessage("Hi I am your custom UI")
                alertDialog.setCancelable(true)
                alertDialog.setPositiveButton(
                    "Thank you"
                ) { dialog, id ->
                    dialog.dismiss()
                }
                val alert = alertDialog.create()
                alert.show()
            }
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(firebaseInAppMessageDisplay)
    }
}
