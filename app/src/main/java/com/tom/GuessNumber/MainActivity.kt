package com.tom.GuessNumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val secretNumber=SecretNumber()
    private val TAG=MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","secretNumber is ${secretNumber.secret}")
    }

    fun check(view:View){
//        resources.getString(R.string.yes_you_got_it_chinese)
        val n:Int =number_editText.text.toString().toInt()
        println("number ${n}")
        Log.v(TAG,getString(R.string.log_verbose)+" number : ${n}")
        Log.e(TAG,getString(R.string.log_error)+" number : ${n}")
        Log.d(TAG,getString(R.string.log_debug)+" number : ${n}")
        Log.i(TAG,getString(R.string.log_information)+" number : ${n}")
        Log.w(TAG,getString(R.string.log_warning)+" number : ${n}")
        var message:String=getString(R.string.yes_you_got_it)
        var vali:Int=secretNumber.validate(n)
        if(vali<0){
            message=getString(R.string.bigger)
        }else if (vali>0){
            message=getString(R.string.smaller)
        }
//        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok),null)
            .show()
    }
}
