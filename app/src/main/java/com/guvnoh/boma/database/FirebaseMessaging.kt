package com.guvnoh.boma.database

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.guvnoh.boma.R

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        // save token to database
        FirebaseRefs.Tokens.child(token).setValue(true)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        remoteMessage.notification?.let {
            val title = it.title ?: "Price Update"
            val body = it.body ?: ""
            sendNotification(title, body)
        }

        // Handle data payload for price change notifications
        remoteMessage.data.isNotEmpty().let {
            val title = remoteMessage.data["title"] ?: "Price Update"
            val body = remoteMessage.data["body"] ?: ""
            if (body.isNotEmpty()) {
                sendNotification(title, body)
            }
        }
    }

    private fun sendNotification(title: String, body: String) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "price_updates_channel"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Price Updates",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notifications for product price changes"
            }
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.boma_logo)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager.notify(System.currentTimeMillis().toInt(), notification)
    }
}