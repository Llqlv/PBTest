package com.probeauty.probeautytest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class ProBeautyTestApplication

fun main(args: Array<String>) {
    runApplication<ProBeautyTestApplication>(*args)
}
