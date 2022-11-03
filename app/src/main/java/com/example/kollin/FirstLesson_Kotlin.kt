package com.example.kollin

const val ZERO = 0

fun outerFun() {
    print("I'm an outer fun")
}

class FirstLesson {

    val county = "Belarus"
    var city = "Minsk"
    lateinit var address: String

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val kotlinClass = KotlinClass("Zhora", 100)
            val kotlinClass2 = KotlinClass("country", "city", "angarskaya")

            val string = kotlinClass.getNameAndAge();
            print(string)
            println(" ${kotlinClass2.country} ${kotlinClass2.city} ${kotlinClass2.address}")

            val firstLesson = FirstLesson()
            firstLesson.city = "Brest"
            firstLesson.address = "Angarskaya 14"
            println(" ${firstLesson.address}")

            firstLesson.emptyFun()
            outerFun()
        }
    }

    fun emptyFun(): Unit = print("I'm an empty fun")//return like this

    fun returnBoolean(): Boolean { // or like this
        return true
    }
}

class KotlinClass(val name: String, var age: Int) : Parent(), Behavior {
    public var country: String = ""
    public var city: String = ""
    public var address: String = ""

    constructor() : this("", 1)
    constructor(country: String, city: String, address: String) : this() {
        this.address = address
        this.city = city
        this.country = country
    }

    fun getNameAndAge(): String {

        return "$name $age"
    }

    override fun getEyeColor() {
        TODO("Not yet implemented")
    }

    override fun getHairColor() {
        super.getHairColor()
    }
}

open class Parent() {

    open fun getHairColor() {

    }

}

interface Behavior {
    fun getEyeColor()
}