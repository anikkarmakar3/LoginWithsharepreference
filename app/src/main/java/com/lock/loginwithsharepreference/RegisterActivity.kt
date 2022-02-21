package com.lock.loginwithsharepreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lock.loginwithsharepreference.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor:SharedPreferences.Editor

    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun onregister(view: View) {
        sharedPreferences= this.getSharedPreferences("userdetails", MODE_PRIVATE)
        editor=sharedPreferences.edit()
        val getemail=binding.editText.text.toString()
        val getname=binding.editText1.text.toString()
        val getpassword=binding.editText2.text.toString()

        editor.putString("email",getemail)
        editor.putString("name",getname)
        editor.putString("password",getpassword)

        editor.commit()
        editor.apply()

        Toast.makeText(getApplicationContext(),
            "Successfully Register",
            Toast.LENGTH_LONG)
            .show();
    }

    fun gologin(view: View) {
        val intent:Intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}