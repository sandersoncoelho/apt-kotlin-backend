package br.smc.apt.controller

import br.smc.apt.model.Product
import br.smc.apt.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/product")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun findAll(@RequestParam(value = "query") query: String?)
            = productService.findAll(query ?: "")

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<Product>
            = ResponseEntity.ok(productService.findById(id))

    @PostMapping
    fun save(@RequestBody product: Product): ResponseEntity<Product>
            = ResponseEntity.ok(productService.save(product))

    @PutMapping("/{id}")
    fun update(@PathVariable(value = "id") id: Long, @Valid @RequestBody product: Product):
            ResponseEntity<Product> = ResponseEntity.ok(productService.update(id, product))

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Unit> {
        productService.deleteById(id)
        return ResponseEntity(HttpStatus.OK)
    }
}