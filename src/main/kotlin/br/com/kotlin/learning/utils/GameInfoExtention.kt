package br.com.kotlin.learning.utils

import br.com.kotlin.learning.model.Game
import br.com.kotlin.learning.model.GameInfo

fun GameInfo.createGame(): Game{
    return Game(
        this.titulo,
        this.capa,
        this.preco,
        this.descricao
    )
}