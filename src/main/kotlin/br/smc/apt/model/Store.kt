package br.smc.apt.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "loja")
data class Store(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotNull
    @Column(name = "nome")
    val name: String,

    @get: NotNull
    @Column(name = "endereco")
    val address: String,

    @get: NotNull
    @Column(name = "telefone")
    val phone: String
)