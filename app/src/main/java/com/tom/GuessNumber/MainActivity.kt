package com.tom.GuessNumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretNumber=SecretNumber()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","secretNumber is ${secretNumber.secret}")
    }

    fun check(view:View){
        val n:Int =number_editText.text.toString().toInt()
        println("number ${n}")
        Log.v("MainActivity","verbose甚麼都要詳細顯示的log"+" number : ${n}")
        Log.e("MainActivity","error表示這件事情很嚴重的log"+" number : ${n}")
        Log.d("MainActivity","debug通常除錯時使用的log"+" number : ${n}")
        Log.i("MainActivity","imformation一般資訊使用的log"+" number : ${n}")
        Log.w("MainActivity","warning警告使用者的log"+" number : ${n}")
        var message:String="恭喜猜對了~"
        var vali:Int=secretNumber.validate(n)
        if(vali<0){
            message="再大一些"
        }else if (vali>0){
            message="再小一些"
        }
//        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(message)
            .setPositiveButton("OK",null)
            .show()
    }
}
