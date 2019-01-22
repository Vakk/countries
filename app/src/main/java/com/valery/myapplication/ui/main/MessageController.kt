package com.valery.myapplication.ui.main

interface MessageController {
    fun showMessage(message: String)

    fun showMessage(messageId: Int)
}