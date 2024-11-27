package com.probeauty.probeautytest.service

import com.probeauty.probeautytest.domain.AuthStep
import com.probeauty.probeautytest.domain.User
import com.probeauty.probeautytest.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val smsService: SmsService
) : AuthService {

    override fun checkPhoneNumber(phoneNumber: String): AuthStep {
        val user = userRepository.findByPhoneNumber(phoneNumber)
        return if (user != null) {
            AuthStep.EXISTING_USER
        } else {
            AuthStep.NEW_USER
        }
    }

    override fun authenticateExistingUser(phoneNumber: String, password: String): Boolean {
        val user = userRepository.findByPhoneNumber(phoneNumber)
        return if (user != null && passwordEncoder.matches(password, user.password)) {
            smsService.sendSmsCode(phoneNumber)
            true
        } else {
            false
        }
    }

    override fun registerNewUser(phoneNumber: String, password: String, firstName: String, lastName: String): User {
        val encodedPassword = passwordEncoder.encode(password)
        val newUser = User(
            phoneNumber = phoneNumber,
            password = encodedPassword,
            firstName = firstName,
            lastName = lastName
        )
        val savedUser = userRepository.save(newUser)
        smsService.sendSmsCode(phoneNumber)
        return savedUser
    }

    override fun verifySmsCode(phoneNumber: String, code: String): Boolean {
        val isValidCode = smsService.verifySmsCode(phoneNumber, code)
        if (isValidCode) {
            val user = userRepository.findByPhoneNumber(phoneNumber)
            if (user != null) {
                userRepository.save(user.copy(isVerified = true))
                return true
            }
        }
        return false
    }
}
