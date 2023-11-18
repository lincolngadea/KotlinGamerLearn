package br.com.kotlin.learning.utils

import br.com.kotlin.learning.model.Player
import br.com.kotlin.learning.model.PlayerInfo

fun PlayerInfo.createPlayer(): Player{
    return Player(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}