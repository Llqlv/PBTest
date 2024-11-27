package com.probeauty.probeautytest.domain

import jakarta.persistence.*
import lombok.*

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(nullable = false, unique = true)
    val phoneNumber: String,
    @Column(nullable = false)
    val password: String,
    @Column(nullable = true)
    val firstName: String? = null,
    @Column(nullable = true)
    val lastName: String? = null,
    @Column(nullable = true)
    val isVerified: Boolean = false
) {


}