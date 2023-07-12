package org.example.views

import tornadofx.*

class MainView(private val userId: Int) : View("My View") {
    override val root = anchorpane {
        setPrefSize(1200.0, 800.0)
        label("Welcome, $userId")
    }
}
