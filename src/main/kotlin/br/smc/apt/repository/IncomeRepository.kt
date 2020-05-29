package br.smc.apt.repository

import br.smc.apt.model.Income
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IncomeRepository : JpaRepository<Income, Long>