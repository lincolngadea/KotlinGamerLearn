package br.com.kotlin.learning.model

data class Game(val title:String,
                val thumb:String,
                val description: String) {
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $thumb \n" +
                "Descricao: $description \n" +
                "############################################### \n\n"
    }

}