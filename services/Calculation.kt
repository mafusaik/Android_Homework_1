package com.example.android_homework_1.services

import com.example.android_homework_1.constant.Constants
import com.example.android_homework_1.entity.Var
import com.example.android_homework_1.repository.VarMapRepository

fun calc(
    inputExpression: String,
    varCreator: VarCreator,
    repository: VarMapRepository
): Var? {
    var expression = inputExpression
        .replace(Constants.SPACES.toRegex(), "")

    while (expression.contains("(")) {
        expression = deleteBrackets(expression, varCreator, repository)
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
        val result: Var? =
            calcOneOperation(leftOperand, operation, rightOperand, varCreator, repository)
        operands.add(index, result.toString())
    }
    return varCreator.createVar(operands[0])
}
