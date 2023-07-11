package org.example.models.dao

import org.example.models.dto.UserDTO
import org.example.models.tables.UserTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class UserDAO {
    fun authenticateUser(username: String, password: String): UserDTO? {
        Database.connect("jdbc:sqlite:src/main/resources/database/finances.db")

        var userDTO: UserDTO? = null

        transaction {
            val user = UserTable.select { UserTable.username eq username}.singleOrNull()

            if (user != null && user[UserTable.password] == password)
                userDTO = UserDTO[user[UserTable.id].value]
        }

        return userDTO
    }
}