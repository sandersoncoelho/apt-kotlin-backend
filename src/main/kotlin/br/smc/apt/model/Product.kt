package br.smc.apt.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "produto")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @get: NotNull
    @Column(name = "nome")
    var name: String = "",

    @Column(name = "descricao")
    var description: String? = null
)