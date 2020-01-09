package br.smc.apt.repository

import br.smc.apt.model.Revenue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RevenueRepository : JpaRepository<Revenue, Long>