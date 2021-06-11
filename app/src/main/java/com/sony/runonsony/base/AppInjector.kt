package com.sony.runonsony.base

import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle
import com.sony.runonsony.BaseApplication

class AppInjector {

    companion object {
        fun init(mraApplication: BaseApplication) {

            mraApplication
                .registerActivityLifecycleCallbacks(object :
                    Application.ActivityLifecycleCallbacks {
                    override fun onActivityCreated(
                        activity: Activity,
                        savedInstanceState: Bundle?
                    ) {
                        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                    }

                    override fun onActivityResumed(activity: Activity) {
                    }

                    override fun onActivityStarted(activity: Activity) {
                    }

                    override fun onActivityDestroyed(activity: Activity) {
                    }

                    override fun onActivitySaveInstanceState(
                        activity: Activity,
                        outState: Bundle
                    ) {
                    }

                    override fun onActivityStopped(activity: Activity) {
                    }

                    override fun onActivityPaused(activity: Activity) {
                    }

                })
        }
    }
}