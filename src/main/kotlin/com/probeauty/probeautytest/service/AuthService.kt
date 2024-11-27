package com.probeauty.probeautytest.service

import com.probeauty.probeautytest.domain.AuthStep
import com.probeauty.probeautytest.domain.User

interface AuthService {
    fun checkPhoneNumber(phoneNumber: String): AuthStep
    fun authenticateExistingUser(phoneNumber: String, password: String): Boolean
    fun registerNewUser(phoneNumber: String, password: String, firstName: String, lastName: String): User
    fun verifySmsCode(phoneNumber: String, code: String): Boolean
}