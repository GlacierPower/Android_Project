package com.example.kollin

class TypesClass {
    companion object {
        @JvmStatic
        fun main(args: Array<String>){



            val child:Child =Child()
            val parent2 =child as Parent2
            if(child is Parent2){
                child.sleep()
                child.walk()
            }
            if (child is Child){
                child.sleep()
                child.walk()
            }
//            if (parent2 is Parent2){
//                parent2.sleep()
//                parent2.walk()
//            }

        }
    }
}
open class Parent2 {
    open fun walk(){
        print("parent is walking..")
    }
}
class Child : Parent2(){
    override fun walk() {
        print("Child is walking..")
    }
    fun sleep(){
        print("Child is sleeping..")
    }
}