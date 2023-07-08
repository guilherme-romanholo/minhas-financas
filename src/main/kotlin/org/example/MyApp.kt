package org.example

import org.example.styles.HelloStyle
import org.example.views.HelloView
import tornadofx.App

class MyApp : App(HelloView::class, HelloStyle::class)