package org.example.views

import javafx.fxml.FXML
import javafx.scene.Parent
import javafx.scene.control.Label
import org.example.models.dao.UserDAO
import org.example.models.dto.UserDTO
import tornadofx.*

class MainView(userDTO: UserDTO) : View("Main") {
    override val root: Parent by fxml("/fxml/main-view.fxml")

    @FXML
    private lateinit var usernameLabel: Label

    init {
        usernameLabel.text = userDTO.username
    }
}
