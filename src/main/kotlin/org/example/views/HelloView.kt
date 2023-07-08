package org.example.views

import javafx.scene.Parent
import tornadofx.View
import tornadofx.hbox
import tornadofx.label

class HelloView : View() {
    override val root: Parent = hbox {
        setPrefSize(600.0, 400.0)
        label("Hello World!")
    }
}