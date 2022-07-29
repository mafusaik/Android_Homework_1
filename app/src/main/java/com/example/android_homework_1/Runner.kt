package com.example.android_homework_1

import java.util.*

fun main() {
    val printer = Printer()
    val parser = Parser()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val expression = scanner.nextLine()
        if (expression == "end") {
            break
        } else {
            val result = parser.calc(expression)
            printer.print(result)
        }
    }
}