package fiuza.maicon.mercado_livro.port

import fiuza.maicon.mercado_livro.domain.Customer
import fiuza.maicon.mercado_livro.domain.dto.CustomerDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController {

    val customers = mutableListOf<Customer>()

    @GetMapping()
    fun findCustomer(): ResponseEntity<MutableList<Customer>> {
        return ResponseEntity(customers, HttpStatus.OK)
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
}