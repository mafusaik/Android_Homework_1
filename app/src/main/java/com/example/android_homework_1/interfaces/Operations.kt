package com.example.android_homework_1.interfaces

import com.example.android_homework_1.entity.Var

interface Operation {
    operator fun plus(other: Var?): Var?
    operator fun minus(other: Var?): Var?
    operator fun times(other: Var?): Var?
    operator fun div(other: Var?): Var?
}