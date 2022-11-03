package com.example.kollin

class DataClass {

    lateinit var wallet: Wallet

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val country = Country("Minsk", "Gerasimenko")
            val country2 = Country2("Minsk", "Gerasimenko")

            println(country)
            println(country2)
        }
    }
}

data class Country(val city: String, val address: String)
data class dataClassEx(val buy: Int, val sell: Int)

class Country2(val city: String, val address: String)

sealed class Wallet {

    data class Euro(val buy: Int, val sell: Int) : Wallet()

    data class Dollar(val buy: Int, val sell: Int) : Wallet()

}