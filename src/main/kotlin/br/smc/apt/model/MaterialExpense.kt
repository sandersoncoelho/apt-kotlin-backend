package br.smc.apt.model

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "despesa_material")
data class MaterialExpense(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @get: NotNull
    @Column(name = "data")
    val date: LocalDateTime,

    @get: NotNull
    @Column(name = "total")
    val total: Float,

    @get: NotNull
    @ManyToOne(cascade = [CascadeType.DETACH])
    @JoinColumn(name = "id_obra")
    val work: Work,

    @get: NotNull
    @ManyToOne(cascade = [CascadeType.DETACH])
    @JoinColumn(name = "id_loja")
    val store: Store,

    @get: NotNull
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.DETACH], orphanRemoval = true, mappedBy = "materialExpense")
    val items: MutableList<MaterialItemExpensive>
)