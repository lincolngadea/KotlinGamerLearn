package br.com.kotlin.learning.principal

import br.com.kotlin.learning.repository.DataBase

fun main(){
    val connection = DataBase.getConnection()
    println(connection)
}