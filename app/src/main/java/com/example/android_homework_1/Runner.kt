package com.example.android_homework_1

import com.example.android_homework_1.exception.CalcException
import com.example.android_homework_1.repository.VarMapRepository
import com.example.android_homework_1.services.Parser
import com.example.android_homework_1.services.Printer
import com.example.android_homework_1.services.VarCreator
import java.util.*

fun main() {
    val printer = Printer()
    val repository = VarMapRepository()
    val varCreator = VarCreator(repository)
    val parser = Parser(repository, varCreator)
    val scanner = Scanner(System.`in`)
    println("app launched")
    while (scanner.hasNext()) {
        val expression = scanner.nextLine()
        if (expression == "end") {
            break
        } else {
            try {
                val result = parser.calc(expression)
                printer.print(result)
            } catch (e: CalcException) {
                println(e.message)
            }
        }
    }
    println("app finished")
}