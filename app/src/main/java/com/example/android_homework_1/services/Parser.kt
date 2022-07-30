package com.example.android_homework_1.services

import com.example.android_homework_1.constant.Constants
import com.example.android_homework_1.entity.Var
import com.example.android_homework_1.exception.CalcException
import com.example.android_homework_1.repository.VarMapRepository



class Parser(private var repository: VarMapRepository, private var varCreator: VarCreator) {

    private val priorityMap: MutableMap<String, Int> = mutableMapOf (
        "=" to 0,
        "+" to 1,
        "-" to 1,
        "*" to 2,
        "/" to 2
    )

    fun calc(inputExpression: String): Var? {
        val expression = inputExpression
            .replace(Constants.SPACES.toRegex(), "")
            .trim()


        val operands: MutableList<String> = Regex(Constants.MATH_OPERATIONS)
            .split(expression) as MutableList<String>
        val operations: MutableList<String> = ArrayList()
        Regex(Constants.MATH_OPERATIONS).findAll(expression)
            .forEach { operations.add(it.value) }

        while (operations.isNotEmpty()) {
            val index: Int = getPriority(operations)
            val left = operands.removeAt(index)
            val operation = operations.removeAt(index)
            val right = operands.removeAt(index)
            val result: Var? = calcOneOperation(left, operation, right)
            operands.add(index, result.toString())
        }

        return varCreator.createVar(operands[0]);
    }

    private fun calcOneOperation(
        leftOperand: String,
        operation: String,
        rightOperand: String
    ): Var? {
        val right = varCreator.createVar(rightOperand)

        if (operation == "=") {
            return repository.save(leftOperand, right)
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

    private fun getPriority(operations: MutableList<String>): Int {
        var indexOperation = -1
        var bestPriority = -1

        operations.forEachIndexed { index, it ->
            if (priorityMap[it]!! > bestPriority) {
                indexOperation = index
                bestPriority = priorityMap[it]!!
            }
        }

        return indexOperation
    }
}