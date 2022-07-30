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

    override fun add(other: Var?): Var? {
        return if (other is Scalar) {
            val result = this.value + other.value
            Scalar(result)
        } else {
            other?.add(this)
        }
    }

    override fun sub(other: Var?): Var? {
        return if (other is Scalar) {
            val result = this.value - other.value
            Scalar(result)
        } else {
            other?.sub(this)?.mul(Scalar(-1.0))
        }
    }

    override fun mul(other: Var?): Var? {
        return if (other is Scalar) {
            val result = this.value * other.value
            Scalar(result)
        } else {
            other?.mul(this)
        }
    }

    override fun div(other: Var?): Var? {
        return if (other is Scalar) {
            val result = this.value / other.value
            Scalar(result)
        } else {
            super.div(other)
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}
