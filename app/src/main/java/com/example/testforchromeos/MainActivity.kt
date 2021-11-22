package com.example.testforchromeos

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainTest: TextView

    private var telephonyManager: TelephonyManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainTest = findViewById(R.id.activity_main_test)

        val a =
            if ((getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager).phoneType == TelephonyManager.PHONE_TYPE_NONE) "Tablet"
            else "Mobile"

        val hasChromeOS = packageManager.hasSystemFeature("org.chromium.arc.device_management")

        val isPC = packageManager.hasSystemFeature(PackageManager.FEATURE_PC)

        activityMainTest.text = """
            <리틀카카오프렌즈 크롬북>
            
            Build.MODEL = ${Build.MODEL}
            
            Build.BRAND = ${Build.BRAND}
            
            Build.MANUFACTURER = ${Build.MANUFACTURER}
            
            Tablet or Mobile (화면 크기 or 비율 기준으로 판단하는 것으로 예상) = $a
            
            packageManager.hasSystemFeature("org.chromium.arc.device_management") = $hasChromeOS
            
            packageManager.hasSystemFeature("android.hardware.type.pc") = $isPC
        """.trimIndent()

//        val b = packageManager.systemAvailableFeatures
//        val sb = StringBuilder()
//        for (i in b) {
//            sb.appendLine(i.toString())
//        }

//        ${Settings.Secure.ANDROID_ID}
//        ${Build.SERIAL}
//        ${Build.BRAND}
//        ${Build.DEVICE}
//        ${Build.PRODUCT}
    }

}