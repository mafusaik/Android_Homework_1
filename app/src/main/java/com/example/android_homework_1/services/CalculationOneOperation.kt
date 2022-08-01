package com.example.android_homework_1.services

import com.example.android_homework_1.entity.Var
import com.example.android_homework_1.exception.CalcException
import com.example.android_homework_1.repository.VarMapRepository

fun calcOneOperation(
    leftOperand: String,
    operation: String,
    rightOperand: String,
    varCreator: VarCreator,
    repository: VarMapRepository
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