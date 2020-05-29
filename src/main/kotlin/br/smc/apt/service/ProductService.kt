package br.smc.apt.service

import br.smc.apt.model.Product
import br.smc.apt.repository.ProductRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun findAll(query: String?): List<Product> = productRepository.findByNameContaining(query)

    fun findById(id: Long): Product = findByIdOrThrow(id)

    fun save(product: Product): Product = productRepository.save(product)

    fun update(id: Long, product: Product): Product {
        findByIdOrThrow(id)
        return productRepository.save(product)
    }

    fun deleteById(id: Long) {
        findByIdOrThrow(id)
        productRepository.deleteById(id)
    }

    private fun findByIdOrThrow(id: Long): Product
            = productRepository.findById(id).orElseThrow{ Exception() }
}