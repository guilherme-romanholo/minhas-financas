package org.example.models.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object UserTable : IntIdTable("users") {
    val username = varchar("username", 255)
    val password = varchar("password", 255)
}