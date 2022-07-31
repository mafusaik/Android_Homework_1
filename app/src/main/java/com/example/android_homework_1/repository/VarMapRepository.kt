package com.example.android_homework_1.repository

import com.example.android_homework_1.entity.Var
import com.example.android_homework_1.interfaces.Repository

class VarMapRepository : Repository {

    private var vars = hashMapOf<String, Var?>()

   override fun save(name: String, value: Var?): Var? {
        vars[name] = value
        return value
    }

    override fun get(name: String?): Var? {
        return vars[name]
    }
}

