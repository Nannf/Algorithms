package learnkotlin

import kotlin.math.max

fun main() {
    println(" Hello Kotlin")
    val a = 10
    println(a)

    // val = final
//    val b: Int = 10
    var b: Int = 10
    b = b*10
    println(b)

    println("max " + largerNumber2(a,b))
}

fun largerNumber(num1: Int, num2: Int): Int {
    return max(num1,num2)
}

fun largerNumber2(num1: Int, num2: Int): Int = max(num1,num2)