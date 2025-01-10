package com.example.task

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class TestService(private val db: JdbcTemplate) {
    fun findMessage(): List<Message> = db.query("select * from messages") { response, _ ->
        Message(response.getString("text"), response.getInt("id"))
    }

    fun save(message: Message): Message {
        db.update(
            "insert into message values ( ? , ? )",
            message.text, message.id
        )
        return message
    }
}