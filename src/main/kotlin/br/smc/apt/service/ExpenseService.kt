package br.smc.apt.service

import br.smc.apt.model.Expense
import br.smc.apt.repository.ExpenseRepository
import org.springframework.stereotype.Service

@Service
class ExpenseService(private val expenseRepository: ExpenseRepository) {

    fun findAll(): List<Expense> = expenseRepository.findAll()

    fun findById(id: Long): Expense = findByIdOrThrow(id)

    fun save(product: Expense): Expense = expenseRepository.save(product)

    fun update(id: Long, product: Expense): Expense {
        findByIdOrThrow(id)
        return expenseRepository.save(product)
    }

    fun deleteById(id: Long) {
        findByIdOrThrow(id)
        expenseRepository.deleteById(id)
    }

    private fun findByIdOrThrow(id: Long): Expense
            = expenseRepository.findById(id).orElseThrow{ Exception() }
}