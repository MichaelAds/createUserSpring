package com.example.demo

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
        val userRepository: UserRepository
) {

    fun listAllUsers() : List<User> {
        return userRepository.findAll()
    }

    fun findId(id: UUID) : User? {
        return userRepository.findById(id).get() // get simplificado
    }

    fun create(user: User) : User {
        val id = UUID.randomUUID()

        user.id = id

        val savedUser = userRepository.save(user)

        return savedUser
    }

}