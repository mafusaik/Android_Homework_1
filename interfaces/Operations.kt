package com.example.android_homework_1.interfaces

import com.example.android_homework_1.entity.Var

interface Operation {
    fun add(other: Var?): Var?
    fun sub(other: Var?): Var?
    fun mul(other: Var?): Var?
    operator fun div(other: Var?): Var?
}