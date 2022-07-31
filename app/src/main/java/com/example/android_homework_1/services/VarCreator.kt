package com.example.android_homework_1.services

import com.example.android_homework_1.constant.Constants
import com.example.android_homework_1.entity.Scalar
import com.example.android_homework_1.entity.Var
import com.example.android_homework_1.exception.CalcException
import com.example.android_homework_1.repository.VarMapRepository
import java.util.*
import java.util.Objects.isNull

class VarCreator(private var repository: VarMapRepository) {

    fun createVar(stringVar: String): Var? = when {
        stringVar.matches(Regex(Constants.SCALAR)) -> Scalar(stringVar)
       // isNull(stringVar) -> throw CalcException("incorrect string $stringVar")
        else -> if (repository.get(stringVar)==null) {
            throw CalcException("incorrect string $stringVar")
        } else repository.get(stringVar)
    }

//    {
//        val result: Var?
//        if (stringVar.matches(Regex(Constants.SCALAR))) {
//            result = Scalar(stringVar)
//        } else {
//            result = repository.get(stringVar)
//        }
//        //if (Objects.isNull(result)) throw CalcException("incorrect string $stringVar")
//        return result
//    }

}