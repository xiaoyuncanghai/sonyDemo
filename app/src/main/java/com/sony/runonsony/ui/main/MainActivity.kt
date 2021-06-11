package com.sony.runonsony.ui.main

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sony.runonsony.R
import com.sony.runonsony.base.viewModel.ProjectViewModelFactory
import com.sony.runonsony.ui.main.viewModel.MainViewModel
import com.sony.runonsony.ui.receiver.RefreshDataReceiver
import com.sony.runonsony.ui.service.RefreshService
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ProjectViewModelFactory
    private lateinit var mainActViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        mainActViewModel =
            ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            Log.d("sony-test", "first click")
            val intent = Intent(this, RefreshService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent)
            } else {
                startService(intent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val manager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, RefreshDataReceiver::class.java)
        val pi = PendingIntent.getBroadcast(this, 0, intent, 0)
        manager.cancel(pi)
    }
}