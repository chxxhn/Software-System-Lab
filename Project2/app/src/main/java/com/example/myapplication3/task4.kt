package com.example.myapplication3

import java.lang.Exception
import java.lang.NumberFormatException
import java.util.*


fun getPrice(m: Int?):Int{
    var price:Int = 0
    when(m) {
        1 -> price= 1000
        2 -> price= 1500
        3 -> price= 800
        4 -> price= 1200
        5 -> price= 1500
    }
    return price
}
fun getMenu():Int?{
    println("============== MENU =================")
    println("| (1) 참깨라면\t- 1,000원\t|")
    println("| (2) 햄버거\t\t- 1,500원\t|")
    println("| (3) 콜라\t\t-   800원\t|")
    println("| (4) 핫바\t\t- 1,200원\t|")
    println("| (5) 초코우유\t- 1,500원\t|")
    println("Choose menu: ")
    val sc: Scanner ? = Scanner(System.`in`)
    var inputString = sc?.nextLine() ?: return null
    try{
        val num: Int = inputString.toInt()
    } catch (e: NumberFormatException){
        println("아무것도 선택하지 않았습니다.")
        println("다시 선택해주세요.")
        return null
    }
    return inputString.toInt()
}
fun getCoin():Int?{
    println("Insert coin")
    val sc: Scanner ? = Scanner(System.`in`)
    var inputString = sc?.nextLine() ?: return null
    try{
        val num: Int = inputString.toInt()
    } catch (e: NumberFormatException){
        println("돈을 넣지 않았습니다.")
        return null
    }
    return inputString.toInt()
}
fun getChange(money:Int,price:Int):Int{
    var change = money - price
    return change
}
fun main() {
    var menu:Int? = null
    while(true){
        menu = getMenu()
        if (menu != null) {
            break
        }
    }
    when(menu) {
        1 -> println("참깨라면이 선택되었습니다.")
        2 -> println("햄버거가 선택되었습니다.")
        3 -> println("콜라가 선택되었습니다.")
        4 -> println("핫바가 선택되었습니다.")
        5 -> println("초코우유가 선택되었습니다.")
    }
    var coin:Int? = null
    while(true){
        coin = getCoin()
        if (coin != null) {
            break
        }
    }
    println("$coin 원을 넣었습니다.")

    var change:Int = getChange(coin ?: -1, getPrice(menu))

    if (change < 0){
        println("현금이 부족합니다.")
    }else{
        println("감사합니다. 잔돈반환:$change")
    }
}