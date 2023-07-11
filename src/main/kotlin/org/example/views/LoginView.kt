package org.example.views

import javafx.fxml.FXML
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import org.example.controllers.LoginController
import tornadofx.*

class LoginView : View("Login") {
    override val root: Parent by fxml("/fxml/login-view.fxml")

    private val controller: LoginController by inject()

    @FXML
    private lateinit var passwordField: PasswordField
    @FXML
    private lateinit var usernameField: TextField
    @FXML
    private lateinit var signInButton: Button
    @FXML
    private lateinit var signUpButton: Button

    init {
        signInButton.setOnAction {
            controller.verifyLoginInfos(usernameField.text, passwordField.text)
        }
        signUpButton.setOnAction {
            replaceWith(RegisterView::class)
        }
    }
}