package com.tom.GuessNumber

import java.util.*

class SecretNumber {
    val secret:Int=Random().nextInt(10)+1
    var count:Int=0

    fun validate(number:Int):Int{
        count++
        return number-secret
    }
}
