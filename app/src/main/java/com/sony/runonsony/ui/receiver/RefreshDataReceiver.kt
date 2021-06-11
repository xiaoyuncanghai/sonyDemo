package com.sony.runonsony.ui.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.sony.runonsony.ui.service.RefreshService
import dagger.android.AndroidInjection

class RefreshDataReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("sony-test","receive broadcast")
        AndroidInjection.inject(this, context)
        //TODO:定时 请求网络

        val intent = Intent(context, RefreshService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.startForegroundService(intent)
        } else {
            context?.startService(intent)
        }
    }
}