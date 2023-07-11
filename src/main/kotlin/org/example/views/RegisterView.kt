package org.example.views

import javafx.fxml.FXML
import javafx.scene.Parent
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import org.example.controllers.RegisterController
import tornadofx.*

class RegisterView : View("My View") {
    override val root: Parent by fxml("/fxml/register-view.fxml")

    private val controller: RegisterController by inject()

    @FXML
    private lateinit var usernameField: TextField
    @FXML
    private lateinit var passwordField: PasswordField
    @FXML
    private lateinit var confirmPasswordField: PasswordField
    @FXML
    private lateinit var backLoginButton: Button
    @FXML
    private lateinit var registerButton: Button
    @FXML
    private lateinit var errorLabel: Label

    init {
        backLoginButton.setOnAction {
            replaceWith(LoginView::class)
        }
        registerButton.setOnAction {
            controller.registerUser(usernameField.text, passwordField.text, confirmPasswordField.text, errorLabel)
        }
    }
}
