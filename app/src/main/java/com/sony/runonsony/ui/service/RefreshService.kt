package com.sony.runonsony.ui.service

import android.app.*
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat
import com.sony.runonsony.ui.receiver.RefreshDataReceiver

class RefreshService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("sony-test", "start service")
        val i = Intent(this, RefreshDataReceiver::class.java)
        val pi = PendingIntent.getBroadcast(this, 0, i, 0)
        val aManager = getSystemService(ALARM_SERVICE) as AlarmManager
        //val triggerAtTime = SystemClock.elapsedRealtime() + 30*60*1000
        val triggerAtTime = SystemClock.elapsedRealtime() + 10 * 1000
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            aManager.setExactAndAllowWhileIdle(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                triggerAtTime,
                pi
            )
        } else {
            aManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi)
        }
        val channelId = "my_channel_01"
        val notificationChannel: NotificationChannel
        val notification: Notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(
                channelId, "channel", NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.setShowBadge(true)
            notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(notificationChannel)
            notification = NotificationCompat.Builder(this, channelId)
                .setContentTitle("RefreshService")
                .build()
        } else {
            notification = NotificationCompat.Builder(this, channelId)
                .setContentTitle("RefreshService")
                .build()
        }
        startForeground(-1, notification)
        stopSelf()
        Log.d("sony", "stop service")
        return super.onStartCommand(intent, flags, startId)
    }
}