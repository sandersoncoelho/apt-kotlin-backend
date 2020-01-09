package br.smc.apt.service

import br.smc.apt.model.Revenue
import br.smc.apt.repository.RevenueRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class RevenueService(private val revenueRepository: RevenueRepository) {

    fun findAll(): List<Revenue> = revenueRepository.findAll()

    fun findById(id: Long): Revenue = findByIdOrThrow(id)

    fun save(revenue: Revenue): Revenue = revenueRepository.save(revenue)

    fun update(id: Long, revenue: Revenue): Revenue {
        findByIdOrThrow(id)
        return revenueRepository.save(revenue)
    }

    fun deleteById(id: Long) {
        findByIdOrThrow(id)
        revenueRepository.deleteById(id)
    }

    private fun findByIdOrThrow(id: Long): Revenue
            = revenueRepository.findById(id).orElseThrow{ Exception() }
}