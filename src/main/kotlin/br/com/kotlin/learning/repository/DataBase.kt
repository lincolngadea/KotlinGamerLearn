package br.com.kotlin.learning.repository

import br.com.kotlin.learning.model.Game
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

object DataBase {
    private const val URL_CONNECTION = "jdbc:mysql://localhost:3306/alugames"
    private const val USER = "root"
    private const val PASSWORD = "root"

    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD)
        } catch (error: SQLException) {
            error.printStackTrace()
            null
        }
    }
}