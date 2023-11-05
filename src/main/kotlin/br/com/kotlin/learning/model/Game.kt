package br.com.kotlin.learning.model

data class Game(val title:String,
                val thumb:String,
                val price:Double,
                val description: String) {
    override fun toString(): String {
        return "My game: \n" +
                "Title: $title \n" +
                "Thumb: $thumb \n" +
                "Price: $price \n" +
                "Description: $description \n" +
                "############################################### \n\n"
    }

}