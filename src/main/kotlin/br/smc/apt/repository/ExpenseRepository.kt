package br.smc.apt.repository

import br.smc.apt.model.MaterialExpense
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository : JpaRepository<MaterialExpense, Long>