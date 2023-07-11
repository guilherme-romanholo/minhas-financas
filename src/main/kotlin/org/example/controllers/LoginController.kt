package org.example.controllers

import org.example.models.dao.UserDAO
import tornadofx.*

class LoginController : Controller() {
    fun verifyLoginInfos(username: String, password: String) {
        val userDAO = UserDAO()

        val userDTO = userDAO.authenticateUser(username, password)

        if (userDTO != null)
            println("Id do usuário: ${userDTO.id}")
        else
            println("Usuário não encontrado!")
    }
}