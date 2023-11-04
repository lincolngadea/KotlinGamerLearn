package br.com.kotlin.learning.utils

import br.com.kotlin.learning.model.Game
import br.com.kotlin.learning.model.InfoGame

fun InfoGame.criaGame(): Game{
    return Game(
        this.titulo,
        this.capa,
        this.descricao
    )
}