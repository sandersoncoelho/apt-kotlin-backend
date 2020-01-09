package br.smc.apt.service

import br.smc.apt.model.Work
import br.smc.apt.repository.WorkRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class WorkService(private val workRepository: WorkRepository) {

    fun findAll(): List<Work> = workRepository.findAll()

    fun findById(id: Long): Work = findByIdOrThrow(id)

    fun save(work: Work): Work = workRepository.save(work)

    fun update(id: Long, work: Work): Work {
        findByIdOrThrow(id)
        return workRepository.save(work)
    }

    fun deleteById(id: Long) {
        findByIdOrThrow(id)
        workRepository.deleteById(id)
    }

    private fun findByIdOrThrow(id: Long): Work
            = workRepository.findById(id).orElseThrow{ Exception() }
}