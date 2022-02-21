package com.lock.loginwithsharepreference

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var bundle :Bundle ?=intent.extras
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val finalgotname= bundle?.getString("name")
        val finalemail= bundle!!.getString("email")
        val text1:EditText=findViewById(R.id.editText3)
        val text2:EditText=findViewById(R.id.editText2)
        text1.setText(finalemail)
        text2.setText(finalgotname)
    }
}