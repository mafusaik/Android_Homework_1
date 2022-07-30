package com.example.android_homework_1.services

import com.example.android_homework_1.constant.Constants
import com.example.android_homework_1.entity.Scalar
import com.example.android_homework_1.entity.Var
import com.example.android_homework_1.repository.VarMapRepository

class VarCreator(private var repository: VarMapRepository) {

    fun createVar(stringVar: String): Var? {
        val result: Var?
        if (stringVar.matches(Regex(Constants.SCALAR))) {
            result = Scalar(stringVar)
        } else {
            result = repository.get(stringVar)
        }
        //if (Objects.isNull(result)) throw CalcException("incorrect string $stringVar")
        return result
    }

}