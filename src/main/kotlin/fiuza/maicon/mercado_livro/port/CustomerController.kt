package fiuza.maicon.mercado_livro.port

import fiuza.maicon.mercado_livro.domain.Customer
import fiuza.maicon.mercado_livro.domain.dto.CustomerDto
import fiuza.maicon.mercado_livro.domain.dto.CustomerPatchDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController {

    val customers = mutableListOf<Customer>()

    @GetMapping()
    fun getAllCustomer(): ResponseEntity<MutableList<Customer>> {
        return ResponseEntity(customers, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findCustomer(@PathVariable id: String): ResponseEntity<Customer> {
        val customer = customers.filter { it -> it.id == id }.first()
        return ResponseEntity(customer, HttpStatus.OK )
    }

    @PostMapping
    fun createCustomer(@RequestBody customer: CustomerDto): ResponseEntity<Customer> {
        val id = if (customers.isEmpty()) {
            "1"
        } else {
            customers.last().id.toInt() + 1
        }.toString()

        val newCustomer =  Customer(
           id = id,
           name = customer.name,
           email = customer.email
       )

      customers.add(newCustomer)

      return ResponseEntity(newCustomer, HttpStatus.CREATED)
    }

    @PutMapping("/{id}") //não é comum método update retornar dados
    fun updateUser(@PathVariable id: String, @RequestBody updatedUser: CustomerDto) {
        customers.filter { it.id == id }.first().let {
            it.name = updatedUser.name
            it.email= updatedUser.email
        }
    }

    @PatchMapping("/{id}")
    fun updateOnly(@PathVariable id: String, @RequestBody updatedUser: CustomerPatchDto) {
        customers.filter { it.id == id}.first().let {
            it.name = updatedUser.name
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String) {
        customers.removeIf { it.id == id }
    }

}