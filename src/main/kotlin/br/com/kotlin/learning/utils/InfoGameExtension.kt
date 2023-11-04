package br.com.kotlin.learning.utils

import br.com.kotlin.learning.model.GamerUser
import br.com.kotlin.learning.model.InfoGamerUser

fun InfoGamerUser.criaGamer(): GamerUser{
    return GamerUser(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}