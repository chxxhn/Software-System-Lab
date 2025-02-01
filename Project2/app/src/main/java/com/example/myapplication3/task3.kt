package com.example.myapplication3

fun change(a:String):String {
    var islower: Boolean = true
    var notlower = ""
    try{
        for(i in a)
        {
            if(i.isUpperCase() || i !in 'a'..'z')
            {
                notlower += i
                islower = false
            }
        }
        if(!islower)
        {
            throw Exception("error with $notlower")
        }
    } catch (e : Exception) {
        return "error with $notlower"
    }
    return a.toUpperCase()
}

fun main(){
    var a = "abcd"
    println(change(a))

    var b = "EfgH"
    println(change(b))

    var c = "!@%$"
    println(change(c))
}