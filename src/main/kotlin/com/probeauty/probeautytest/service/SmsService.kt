package com.probeauty.probeautytest.service

interface SmsService {
    fun sendSmsCode(phoneNumber: String)
    fun verifySmsCode(phoneNumber: String, code: String): Boolean
}