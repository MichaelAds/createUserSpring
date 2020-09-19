package com.example.demo

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User(
        @Id var id : UUID?,
        val nome: String,
        val email: String,
        val senha: String?
) {

}