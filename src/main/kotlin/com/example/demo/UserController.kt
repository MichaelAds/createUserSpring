package com.example.demo


import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
class UserController(
        val userService: UserService
) {

    @GetMapping("/users/{id}")
    fun findById(@PathVariable id: UUID) : User? {
        return userService.findId(id)
    }

    @GetMapping("/users")
    fun listarUsuarios() : List<User> {
        return userService.listAllUsers()

        // lista não alteravel
        // val usuarios = listOf<User>(alan, michael)
    }

    @PostMapping("/users")
    fun criarUsuario(@RequestBody user: User) : ResponseEntity<Unit> {

        val savedUser = userService.create(user)

        return ResponseEntity.created(URI.create("/users/${savedUser.id}")).build() // desing pattern builder pesquisa
    }





}