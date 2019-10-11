package Aula05_Fundamental_Kotlin

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

fun main(){
    reflection()
}

@ImAPlant class Plant {
    fun trim(){}
    fun fertilize(){}
}

annotation class ImAPlant

fun reflection(){
    // Print all class name
    val classObj = Plant::class
    for (method in classObj.declaredMemberFunctions){
        println(method.name)
    }

    // Print all annotation
    for (annotation in classObj.annotations){
        println(annotation.annotationClass.simpleName)
    }

    // find one annotation, or null
    val annotated = classObj.findAnnotation<ImAPlant>()
    annotated?.apply {
        println("Found a plant annotation!")
    }
}

