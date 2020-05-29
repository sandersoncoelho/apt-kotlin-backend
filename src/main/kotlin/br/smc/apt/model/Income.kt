package br.smc.apt.model

import br.smc.apt.model.enums.Apartment
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "receita")
data class Income(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @get: NotNull
    @Column(name = "apartamento")
    var apartment: Apartment? = null,

    @get: NotNull
    @Column(name ="valor")
    var value: Float? = null,

    @get: NotNull
    @Column(name ="data")
    var date: LocalDateTime? = null
)