package com.qadomy.quotecard.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.qadomy.quotecard.R.drawable.ic_like

object Common {

    private const val NOTIFICATION_CHANNEL_ID = "com.qadomy.quotecard"

    /**
     * Method for create notification to display an quote description
     * when click on ACCEPT button for any quote cards
     */
    fun showNotification(
        context: Context,
        id: Int,
        title: String?,
        content: String?
    ) {

        val notificationManager =
            context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // check the API version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "Quote",
                IMPORTANCE_HIGH
            )

            notificationChannel.description = "Quote"
            notificationChannel.enableLights(true)
            notificationChannel.enableVibration(true)
            notificationChannel.lightColor = (Color.RED)
            notificationChannel.vibrationPattern = longArrayOf(0, 1000, 500, 1000)

            // create notification
            notificationManager.createNotificationChannel(notificationChannel)

        }

        val builder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)

        // set sound for notification
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))

        // build notification
        builder.setContentTitle(title!!)
            .setContentText(content!!)
            .setAutoCancel(true)
            .setSmallIcon(ic_like)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources, ic_like))
            .setStyle(NotificationCompat.BigTextStyle().bigText(content))

        val notification = builder.build()
        notificationManager.notify(id, notification)
    }


    /**
     * Method for clear quote notification when click on REJECT button for any quote cards
     */
    fun hideNotification(context: Context) {

        val notificationManager =
            context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.cancelAll()
    }
}