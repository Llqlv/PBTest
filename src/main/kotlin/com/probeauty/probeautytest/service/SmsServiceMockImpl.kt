package com.probeauty.probeautytest.service

import org.springframework.stereotype.Service

@Service
class SmsServiceMockImpl : SmsService {

    private val code = "111111"

    override fun sendSmsCode(phoneNumber: String) {
        println("Отправлен SMS-код на номер $phoneNumber: $code")
    }

    override fun verifySmsCode(phoneNumber: String, code: String): Boolean {
        return code == this.code
    }
}