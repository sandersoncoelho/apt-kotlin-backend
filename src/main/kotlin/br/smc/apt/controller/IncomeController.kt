package br.smc.apt.controller

import br.smc.apt.model.Income
import br.smc.apt.model.Product
import br.smc.apt.model.enums.Apartment
import br.smc.apt.service.IncomeService
import br.smc.apt.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.Valid

@RestController
@RequestMapping("/income")
class IncomeController(private val incomeService: IncomeService) {
    var dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    @GetMapping
    fun findAll(@RequestParam(value = "apartment") apartment: Apartment?,
                @RequestParam(value = "start") start: String?,
                @RequestParam(value = "end") end: String?): List<Income> {
        val startDate: LocalDateTime? = if (start != null) LocalDateTime.parse(start, dtf) else null
        val endDate: LocalDateTime? = if (end != null) LocalDateTime.parse(end, dtf) else null

        return incomeService.findAll(apartment, startDate, endDate)
    }

    /*@GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<Product>
            = ResponseEntity.ok(incomeService.findById(id))

    @PostMapping
    fun save(@RequestBody product: Product): ResponseEntity<Product>
            = ResponseEntity.ok(incomeService.save(product))

    @PutMapping("/{id}")
    fun update(@PathVariable(value = "id") id: Long, @Valid @RequestBody product: Product):
            ResponseEntity<Product> = ResponseEntity.ok(incomeService.update(id, product))

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Unit> {
        incomeService.deleteById(id)
        return ResponseEntity(HttpStatus.OK)
    }*/
}