package com.probeauty.probeautytest.controller

import com.probeauty.probeautytest.domain.AuthStep
import com.probeauty.probeautytest.domain.User
import com.probeauty.probeautytest.service.AuthService
import com.probeauty.probeautytest.service.UserService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserController(private val authService: AuthService, private val userService: UserService) {

    @QueryMapping
    fun getUsers(): List<User> {
        return userService.getUsers()
    }

    @QueryMapping
    fun checkPhoneNumber(@Argument phoneNumber: String): AuthStep {
        return authService.checkPhoneNumber(phoneNumber)
    }

    @MutationMapping
    fun authenticateExistingUser(@Argument phoneNumber: String, @Argument password: String): Boolean {
        return authService.authenticateExistingUser(phoneNumber, password)
    }

    @MutationMapping
    fun registerNewUser(
        @Argument phoneNumber: String,
        @Argument password: String,
        @Argument firstName: String,
        @Argument lastName: String
    ): User {
        return authService.registerNewUser(phoneNumber, password, firstName, lastName)
    }

    @MutationMapping
    fun verifySmsCode(@Argument phoneNumber: String, @Argument code: String): Boolean {
        return authService.verifySmsCode(phoneNumber, code)
    }

}
