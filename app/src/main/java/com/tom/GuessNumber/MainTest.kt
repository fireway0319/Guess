package com.tom.GuessNumber

fun main(){
    val secretNumber=SecretNumber()
    println(secretNumber.secret)
    println("${secretNumber.validate(2)} , count: ${secretNumber.count}")
}