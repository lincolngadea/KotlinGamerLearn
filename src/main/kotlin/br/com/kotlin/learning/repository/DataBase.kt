package br.com.kotlin.learning.repository

import br.com.kotlin.learning.model.Game
import org.slf4j.LoggerFactory
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import javax.persistence.EntityManager
import javax.persistence.Persistence
import kotlin.math.log

object DataBase {

    fun getEntityManager(): EntityManager{
        val factory = Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager()
    }
}