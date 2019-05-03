package com.tom.GuessNumber

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_record.*
import kotlin.math.log

class RecordActivity : AppCompatActivity() {
    val TAG = RecordActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        val count = intent.getIntExtra("COUNTER", -1)
        counter.setText(count.toString())
        save_button.setOnClickListener { view ->
            val nickname = nickname.text.toString()
            getSharedPreferences("guess", Context.MODE_PRIVATE)
                .edit()
                .putInt("REC_COUNTER", count)
                .putString("REC_NICKNAME", nickname)
                .apply()      //系統會在空餘時間存取
//                .commit()     及時存取與讀取 需要在下一行使用時使用
//            val username=getSharedPreferences("guess",Context.MODE_PRIVATE)
//                .getString("REC_NICKNAME","Never user get...")
//            val usercount=getSharedPreferences("guess",Context.MODE_PRIVATE)
//                .getInt("REC_COUNTER",-1)
//            AlertDialog.Builder(this)
//                .setTitle("Save message")
//                .setMessage(getString(
//                    R.string.save_message_part1)+username+getString(R.string.save_message_part2)+usercount+getString(
//                    R.string.save_message_part3))
//                .setPositiveButton(getString(R.string.ok),null)
//                .show()
            val intent = Intent().putExtra("NICKNAME",nickname)
            intent.putExtra("COUNTER",count)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        Log.d(TAG, "onCreateeeeeeeeeeeeeeeeeeeeee")

    }
        override fun onStart() {
            super.onStart()
            Log.d(TAG,"onStart")
        }

        override fun onStop() {
            super.onStop()
            Log.d(TAG,"onStop")

        }

        override fun onPause() {
            super.onPause()
            Log.d(TAG,"onPause")

        }

        override fun onRestart() {
            super.onRestart()
            Log.d(TAG,"onRestart")
        }

        override fun onResume() {
            super.onResume()
            Log.d(TAG,"onResume")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d(TAG,"onDestroy")

    }
}
