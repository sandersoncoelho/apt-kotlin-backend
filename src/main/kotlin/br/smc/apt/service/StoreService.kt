package br.smc.apt.service

import br.smc.apt.model.Store
import br.smc.apt.repository.StoreRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class StoreService(private val storeRepository: StoreRepository) {

    fun findAll(): List<Store> = storeRepository.findAll()

    fun findById(id: Long): Store = findByIdOrThrow(id)

    fun save(store: Store): Store = storeRepository.save(store)

    fun update(id: Long, store: Store): Store {
        findByIdOrThrow(id)
        return storeRepository.save(store)
    }

    fun deleteById(id: Long) {
        findByIdOrThrow(id)
        storeRepository.deleteById(id)
    }

    private fun findByIdOrThrow(id: Long): Store
            = storeRepository.findById(id).orElseThrow{ Exception() }
}