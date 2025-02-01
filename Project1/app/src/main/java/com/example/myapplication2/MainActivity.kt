package com.example.myapplication2

fun main()
{
    val a = readLine()
    println("입력받을 숫자: ${a!!}")

    for(i: Int in 1 .. a.toInt())
    {
        if(i % 2 == 1)
            print("$i ")
        else continue
    }
}