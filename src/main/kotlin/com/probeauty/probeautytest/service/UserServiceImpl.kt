package com.probeauty.probeautytest.service

import com.probeauty.probeautytest.domain.User
import com.probeauty.probeautytest.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
) : UserService {

    override fun getUsers(): List<User> {
        return userRepository.findAll()
    }
}