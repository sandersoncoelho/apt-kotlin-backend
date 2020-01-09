package br.smc.apt.repository

import br.smc.apt.model.Work
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkRepository : JpaRepository<Work, Long>