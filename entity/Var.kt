package com.example.android_homework_1.entity

import com.example.android_homework_1.interfaces.Operation

abstract class Var : Operation {

    override fun add(other: Var?): Var? {
        println("Incorrect operation $this + $other")
        return null
    }

    override fun sub(other: Var?): Var? {
        println("Incorrect operation $this - $other")
        return null
    }

    override fun mul(other: Var?): Var? {
        println("Incorrect operation $this * $other")
        return null
    }

    override fun div(other: Var?): Var? {
        println("Incorrect operation $this / $other")
        return null
    }

    override fun toString(): String {
        return "unknown variable"
    }
}