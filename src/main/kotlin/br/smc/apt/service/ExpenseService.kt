package br.smc.apt.service

import br.smc.apt.model.MaterialExpense
import br.smc.apt.repository.ExpenseRepository
import org.springframework.stereotype.Service

@Service
class ExpenseService(private val expenseRepository: ExpenseRepository) {

    fun findAll(): List<MaterialExpense> = expenseRepository.findAll()

    fun findById(id: Long): MaterialExpense = findByIdOrThrow(id)

    fun save(product: MaterialExpense): MaterialExpense = expenseRepository.save(product)

    fun update(id: Long, product: MaterialExpense): MaterialExpense {
        findByIdOrThrow(id)
        return expenseRepository.save(product)
    }

    fun deleteById(id: Long) {
        findByIdOrThrow(id)
        expenseRepository.deleteById(id)
    }

    private fun findByIdOrThrow(id: Long): MaterialExpense
            = expenseRepository.findById(id).orElseThrow{ Exception() }
}