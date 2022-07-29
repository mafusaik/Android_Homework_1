package com.example.android_homework_1

interface Operation {
    fun add(other: Var?): Var?
    fun sub(other: Var?): Var?
    fun mul(other: Var?): Var?
    operator fun div(other: Var?): Var?
}