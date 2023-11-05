package br.com.kotlin.learning.utils

import br.com.kotlin.learning.model.GamerUser
import br.com.kotlin.learning.model.GamerUserInfo

fun GamerUserInfo.createGamerUser(): GamerUser{
    return GamerUser(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}