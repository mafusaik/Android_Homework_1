package com.example.android_homework_1.services

import com.example.android_homework_1.constant.Constants
import com.example.android_homework_1.repository.VarMapRepository

fun deleteBrackets(
    expression: String,
    varCreator: VarCreator,
    repository: VarMapRepository
): String {
    val bracketGroup = Regex(Constants.EXPRESSION_IN_BRACKETS).find(expression)
    return if (bracketGroup != null) {
        val withoutBracketGroup = Regex(Constants.ROUND_BRACKETS)
            .replace(bracketGroup.value, "")
        expression.replace(
            bracketGroup.value,
            calc(withoutBracketGroup, varCreator, repository).toString()
        )
    } else expression
}