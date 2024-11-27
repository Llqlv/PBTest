package com.probeauty.probeautytest.service

import com.probeauty.probeautytest.domain.User

interface UserService {
    fun getUsers(): List<User>
}