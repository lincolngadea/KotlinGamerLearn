package br.com.kotlin.learning.repository

import br.com.kotlin.learning.model.Game
import org.slf4j.LoggerFactory
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import kotlin.math.log

object DataBase {
    private const val URL_CONNECTION = "jdbc:mysql://localhost:3306/alugames"
    private const val USER = "root"
    private const val PASSWORD = "root"

    private val logger = LoggerFactory.getLogger(javaClass)
    private fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD)
        } catch (error: SQLException) {
            error.printStackTrace()
            null
        }
    }

    fun getGame(): List<Game> {
        val gameResult = mutableListOf<Game>()
        val connection = getConnection()
        connection.use {
            it?.let { initConnection ->
                val statement = initConnection.createStatement()
                val result = statement.executeQuery("SELECT * FROM JOGOS")
                while (result.next()) {
                    result.apply {
                        val thumb = getString("capa")
                        val description = getString("descricao")
                        val price = getDouble("preco")
                        val title = getString("titulo")
                        logger.info("Title: $title")
                        val game = Game(title, thumb, price, description)
                        println("teste")
                        gameResult.add(game)
                    }
                }
                statement.close()
            } ?: run {
                println("Null Connection")
            }
        }
        return gameResult.ifEmpty {
            logger.warn("Data Not Found!")
            gameResult
        }
    }
}