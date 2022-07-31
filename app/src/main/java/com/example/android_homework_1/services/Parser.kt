package com.example.android_homework_1.services

import com.example.android_homework_1.constant.Constants
import com.example.android_homework_1.entity.Var
import com.example.android_homework_1.exception.CalcException
import com.example.android_homework_1.repository.VarMapRepository


class Parser(private var repository: VarMapRepository, private var varCreator: VarCreator) {

    fun calc(inputExpression: String): Var? {
        var expression = inputExpression
            .replace(Constants.SPACES.toRegex(), "")

        while (expression.contains("(")) {
            expression = deleteBrackets(expression)
        }

        val operands: MutableList<String> = Regex(Constants.MATH_OPERATIONS)
            .split(expression) as MutableList<String>
        val operations: MutableList<String> = ArrayList()

        Regex(Constants.MATH_OPERATIONS).findAll(expression)
            .forEach { operations.add(it.value) }

        while (operations.isNotEmpty()) {
            val index: Int = getPriority(operations)
            val leftOperand = operands.removeAt(index)
            val operation = operations.removeAt(index)
            val rightOperand = operands.removeAt(index)
            val result: Var? = calcOneOperation(leftOperand, operation, rightOperand)
            operands.add(index, result.toString())
        }
        return varCreator.createVar(operands[0])
    }

    private fun deleteBrackets(expression: String): String {
        val bracketGroup = Regex(Constants.EXPRESSION_IN_BRACKETS).find(expression)
        return if (bracketGroup != null) {
            val withoutBracketGroup = Regex(Constants.ROUND_BRACKETS)
                .replace(bracketGroup.value, "")
            expression.replace(bracketGroup.value, calc(withoutBracketGroup).toString())
        } else expression
    }

    private fun calcOneOperation(
        leftOperand: String,
        operation: String,
        rightOperand: String
    ): Var? {
        val right = varCreator.createVar(rightOperand)
        when (operation) {
            "=" -> return repository.save(leftOperand, right)
        }
        val left = varCreator.createVar(leftOperand)
        when (operation) {
            "+" -> return left?.add(right)
            "-" -> return left?.sub(right)
            "*" -> return left?.mul(right)
            "/" -> return left?.div(right)
        }
        throw CalcException("not found operation $operation")
    }
}