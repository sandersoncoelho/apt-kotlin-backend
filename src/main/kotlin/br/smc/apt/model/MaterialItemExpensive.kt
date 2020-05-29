package br.smc.apt.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "despesa_material_item")
data class MaterialItemExpensive(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @get: NotNull
    @ManyToOne(cascade = [CascadeType.DETACH])
    @JoinColumn(name = "id_produto")
    val product: Product,

    @get: NotNull
    @ManyToOne(cascade = [CascadeType.DETACH])
    @JoinColumn(name = "id_despesa_material")
    val materialExpense: MaterialExpense,

    @get: NotNull
    @Column(name = "preco_unitario")
    val price: Float,

    @get: NotNull
    @Column(name = "quantidade")
    val quantity: Int,

    @get: NotNull
    @Column(name = "total_parcial")
    val parcialTotal: Float
)