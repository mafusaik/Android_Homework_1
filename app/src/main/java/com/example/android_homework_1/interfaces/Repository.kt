package com.example.android_homework_1.interfaces

import com.example.android_homework_1.entity.Var

interface Repository {


    fun save(name: String, value: Var?): Var?
    fun get(name: String?): Var?
}