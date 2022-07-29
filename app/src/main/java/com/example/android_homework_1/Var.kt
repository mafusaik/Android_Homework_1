package com.example.android_homework_1


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

    companion object {
        fun createVar(stringVar: String): Var? {
            var result: Var? = null
            if (stringVar.matches(Regex("-?[0-9]+(\\.[0-9]+)?"))) {
                result = Scalar(stringVar)
            }
            return result
        }
    }

    override fun toString(): String {
        return "unknown variable"
    }
}