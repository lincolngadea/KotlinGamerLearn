package br.com.kotlin.learning.model

data class Game(val title:String,
                val thumb:String) {
    var description: String? = null
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $thumb \n" +
                "Descricao: $description"
    }

}