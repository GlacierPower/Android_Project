package com.example.kollin

class Collections {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //immutable collections
            val collectionList = listOf<String>(
                "hello",
                "bye",
                "world"
            )
            collectionList.forEach { words ->
                print("$words ")
            }
//            collectionList.add()//we can't do so

            //mutable collection
            val collectionList2 = mutableListOf<String>()
            collectionList2.add("hello")
            collectionList2.add("bye")
            collectionList2.add("world")


            for (i in 1..10) {
            }

            val arrayList = arrayListOf<String>(
                "hello",
                "bye",
                "world"
            )
            for (word in arrayList) {
                println(word)
            }

            for (i in 10 downTo 1 step 2) {
                print(" $i\n ")
            }

            for (i in 1..10) {
                if (i == 2) {
                    println("Hello world")
                    continue
                }
                println(i)
            }
            val collections = Collections()
            repeat(10){getName->
                println(collections.getName())
            }
        }

    }

    fun getName():String{
        return "Hello"
    }
}