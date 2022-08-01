package com.example.android_homework_1.entity


class Scalar constructor() : Var() {
    var value = 0.0

    constructor(value: Double) : this() {
        this.value = value
    }

    constructor(scalar: Scalar) : this() {
        value = scalar.value
    }

    constructor(strScalar: String) : this() {
        this.value = strScalar.toDouble()
    }

    override fun add(other: Var?): Var? = when (other) {
        is Scalar -> Scalar(this.value + other.value)
        else -> other?.add(this)
    }

    override fun sub(other: Var?): Var? = when (other) {
        is Scalar -> Scalar(this.value - other.value)
        else -> other?.sub(this)?.mul(Scalar(-1.0))
    }

    override fun mul(other: Var?): Var? = when (other) {
        is Scalar -> Scalar(this.value * other.value)
        else -> other?.mul(this)
    }

    override fun div(other: Var?): Var? = when (other) {
        is Scalar -> Scalar(this.value / other.value)
        else -> other?.div(this)
    }

    override fun toString(): String {
        return value.toString()
    }
}
