package br.smc.apt.service

import br.smc.apt.model.Income
import br.smc.apt.model.enums.Apartment
import br.smc.apt.repository.IncomeRepository
import org.springframework.stereotype.Service
import java.lang.Exception
import java.time.LocalDateTime

@Service
class IncomeService(private val incomeRepository: IncomeRepository) {

    fun findAll(apartment: Apartment?, start: LocalDateTime?, end: LocalDateTime?): List<Income> = incomeRepository.findAll()

    fun findById(id: Long): Income = findByIdOrThrow(id)

    fun save(income: Income): Income = incomeRepository.save(income)

    fun update(id: Long, income: Income): Income {
        findByIdOrThrow(id)
        return incomeRepository.save(income)
    }

    fun deleteById(id: Long) {
        findByIdOrThrow(id)
        incomeRepository.deleteById(id)
    }

    private fun findByIdOrThrow(id: Long): Income
            = incomeRepository.findById(id).orElseThrow{ Exception() }
}