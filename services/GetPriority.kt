package com.example.android_homework_1.services


private val priorityMap: Map<String, Int> = mapOf(
    "=" to 0,
    "+" to 1,
    "-" to 1,
    "*" to 2,
    "/" to 2
)

fun getPriority(operations: MutableList<String>): Int {
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