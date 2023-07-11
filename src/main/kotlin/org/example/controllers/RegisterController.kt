package org.example.controllers

import javafx.animation.PauseTransition
import javafx.scene.control.Label
import javafx.scene.paint.Paint
import javafx.util.Duration
import org.example.models.dao.UserDAO
import tornadofx.*

class RegisterController : Controller(){
    fun registerUser(username: String, password: String, confirmPassword: String, errorLabel: Label) {
        if (showError(username, password, confirmPassword, errorLabel)) {
            val userDAO = UserDAO()
            userDAO.registerUser(username, password)
        }

        errorLabel.isVisible = true
        val pause = PauseTransition(Duration.seconds(3.0))
        pause.setOnFinished { errorLabel.isVisible = false }
        pause.play()
    }

    private fun showError(username: String, password: String, confirmPassword: String, errorLabel: Label): Boolean {
        val userDAO = UserDAO()
        var error = false

        errorLabel.textFill = Paint.valueOf("FF0000")

        if (username == "" || password == "") {
            errorLabel.text = "Empty fields!"
        }
        else if (password != confirmPassword) {
            errorLabel.text = "Different passwords!"
        }
        else if (userDAO.searchUsername(username)) {
            errorLabel.text = "Username alredy exists!"
        }
        else {
            errorLabel.text = "Successfully registered!"
            errorLabel.textFill = Paint.valueOf("008562")
            error = true
        }

        return error
    }
}