package org.example.models.dto

import org.example.models.tables.UserTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserDTO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserDTO>(UserTable)

    var username by UserTable.username
    var password by UserTable.password
}