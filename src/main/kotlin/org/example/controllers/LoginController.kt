package org.example.controllers

import javafx.animation.PauseTransition
import javafx.scene.control.Label
import javafx.util.Duration
import org.example.models.dao.UserDAO
import org.example.models.dto.UserDTO
import tornadofx.*

class LoginController : Controller() {
    fun verifyLoginInfos(username: String, password: String, errorLabel: Label): Int {
        var id = -1;
        val userDAO = UserDAO()
        val userDTO = userDAO.authenticateUser(username, password)

        if (userDTO == null) {
            errorLabel.isVisible = true
            val pause = PauseTransition(Duration.seconds(3.0))
            pause.setOnFinished { errorLabel.isVisible = false }
            pause.play()
        } else {
            id = userDTO.getId()
        }

        return id
    }
}