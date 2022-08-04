package com.example.android_homework_1.entity

class Scalar(var value: Double = 0.0) : Var() {

    constructor(scalar: Scalar) : this() {
        value = scalar.value
    }

    constructor(strScalar: String) : this() {
        this.value = strScalar.toDouble()
    }

    override operator fun plus(other: Var?): Var? = when (other) {
        is Scalar -> Scalar(this.value + other.value)
        else -> other?.plus(this)
    }

    override operator fun minus(other: Var?): Var? = when (other) {
        is Scalar -> Scalar(this.value - other.value)
        else -> other?.minus(this)?.times(Scalar(-1.0))
    }

    override operator fun times(other: Var?): Var? = when (other) {
        is Scalar -> Scalar(this.value * other.value)
        else -> other?.times(this)
    }

    override operator fun div(other: Var?): Var? = when (other) {
        is Scalar -> Scalar(this.value / other.value)
        else -> other?.div(this)
    }

    override fun toString(): String {
        return value.toString()
    }
}
