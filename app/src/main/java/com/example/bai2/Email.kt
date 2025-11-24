package com.example.bai2

data class Email(
    val sender: String,
    val subject: String,
    val preview: String,
    val timestamp: String,
    val color: Int,
    var isStarred: Boolean = false,
    var isRead: Boolean = false
)