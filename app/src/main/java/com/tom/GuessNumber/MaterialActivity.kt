package com.tom.GuessNumber

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_material.*
import kotlinx.android.synthetic.main.content_material.*
import kotlin.math.log

class MaterialActivity : AppCompatActivity() {
    private val REQUEST_RECORD = 100
    val secretNumber=SecretNumber()
    val TAG=MaterialActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
        setContentView(R.layout.activity_material)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            replay()
        }

        counter_TV.setText(secretNumber.count.toString())
        Log.d(TAG,"onCreate: "+secretNumber.secret)
        val count=getSharedPreferences("guess", Context.MODE_PRIVATE)
            .getInt("REC_COUNTER",-1)
        val nick=getSharedPreferences("guess", Context.MODE_PRIVATE)
            .getString("REC_NICKNAME",null)
        Log.d(TAG,getString(R.string.save_message_part1)+nick+getString(R.string.save_message_part2)+count
                +getString(R.string.save_message_part3))
    }

    private fun replay() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.replayTitle_dialog))
            .setMessage(getString(R.string.replayMessage_dialog))
            .setPositiveButton(getString(R.string.ok), { dialog, which ->
                secretNumber.reset()
                counter_TV.setText(secretNumber.count.toString())
                number_editText.setText("")
                Log.d(TAG,secretNumber.secret.toString())
            })
            .setNeutralButton("Cancel", null)
            .show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==REQUEST_RECORD){
            if(resultCode== Activity.RESULT_OK){
                val nameFromRecordActivity=data?.getStringExtra("NICKNAME")
                val counter=data?.getIntExtra("COUNTER",-1)
                Log.d(TAG,"name: "+nameFromRecordActivity+" times: "+counter)
                replay()
            }
        }
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

    fun check(view: View){
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
        counter_TV.setText(secretNumber.count.toString())
//        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok),{dialog, which ->
                if(vali==0){
                    val intent=Intent(this,RecordActivity::class.java)
                    intent.putExtra("COUNTER",secretNumber.count)
//                    startActivity(intent)
                    startActivityForResult(intent,REQUEST_RECORD)
                }
            })
            .show()
    }


}
