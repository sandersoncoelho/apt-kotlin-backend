package br.smc.apt.model

import br.smc.apt.model.enums.Status
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "obra")
data class Work(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @get: NotNull
    @Column(name = "nome")
    val name: String,

    @Column(name = "descricao")
    val description: String,

    @get: NotNull
    @Column(name ="inicio")
    val start: LocalDateTime,

    @get: NotNull
    @Column(name ="fim")
    val end: LocalDateTime,

    @get: NotNull
    @Column(name ="status")
    val status: Status
)