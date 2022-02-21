package com.lock.loginwithsharepreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lock.loginwithsharepreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val binding=binding.root
        setContentView(binding)
    }
    fun onlogin(view: View) {
        sharedPreferences=this.getSharedPreferences("userdetails",Context.MODE_PRIVATE)
        val logmail=sharedPreferences.getString("email","defa")
        val logname=sharedPreferences.getString("name","")
        val logpassword=sharedPreferences.getString("password","")

        val inputemail=binding.editText.text.toString()
        val inputpassword=binding.editText2.text.toString()
        if (logmail.equals(inputemail) && logpassword.equals(inputpassword)){
            val intent:Intent= Intent(this,dashboard::class.java)
            intent.putExtra("name",logname)
            intent.putExtra("email",logmail)
            Toast.makeText(getApplicationContext(),
                "Successfully Login",
                Toast.LENGTH_LONG)
                .show();
            startActivity(intent)
        }
        else{
            Toast.makeText(getApplicationContext(),
                "Credentials Mismatch",
                Toast.LENGTH_LONG)
                .show();
        }

    }
    fun goregister(view: View) {
        val intent:Intent= Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }


}