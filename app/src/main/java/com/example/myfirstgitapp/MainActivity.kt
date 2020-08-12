package com.example.myfirstgitapp

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*  tv.text =  System.getenv("BITRISE_BUILD_NUMBER") ?: "0"
         // System.getenv("BITRISE_BUILD_NUMBER") ?: "0"
          BuildConfig.getCheckedOutGitCommitHash()*/

        tv.text = BuildConfig.GIT_LAST_COMMIT_DATE

    }

    fun getAppVersion(context: Context): String {
        var version = ""
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            version = pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        return version

    }
}
