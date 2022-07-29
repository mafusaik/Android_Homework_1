package com.example.android_homework_1

class Parser {
    fun calc(inputExpression: String): Var? {

        val expression = inputExpression
            .replace("\\s+".toRegex(), "")
            .trim()
        val delimiter = Regex("(?<=[^{,+=*/-])[-+*/=]")
        val parts: Array<String> = expression
            .split(delimiter, 2)
            .toTypedArray()
        val leftOperand = Var.createVar(parts[0])
        if (parts.size == 1) {
            return leftOperand
        }
        val rightOperand = Var.createVar(parts[1])
        expression.forEach {
            when (it) {
                '+' -> return leftOperand?.add(rightOperand)
                '-' -> return leftOperand?.sub(rightOperand)
                '*' -> return leftOperand?.mul(rightOperand)
                '/' -> return leftOperand?.div(rightOperand)
            }
        }
        return null
    }
}