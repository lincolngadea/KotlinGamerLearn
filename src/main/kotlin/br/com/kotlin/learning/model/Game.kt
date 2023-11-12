package br.com.kotlin.learning.model

import com.google.gson.annotations.Expose

data class Game(@Expose val title:String,
                @Expose val thumb:String,
                val price:Double,
                val description: String
): Recommended {
    private val listGrades = mutableListOf<Double>()
    override val gradeAverage: Double
        get() = listGrades.average()

    override fun toRecommend(grade: Double) {
        listGrades.add(grade)
    }
    override fun toString(): String {
        return "My game: \n" +
                "Title: $title \n" +
                "Thumb: $thumb \n" +
                "Price: $price \n" +
                "Description: $description \n" +
                "Recommendations: $gradeAverage" +
                "############################################### \n\n"
    }

}