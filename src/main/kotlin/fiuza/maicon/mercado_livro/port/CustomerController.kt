package fiuza.maicon.mercado_livro.port

import fiuza.maicon.mercado_livro.domain.Customer
import fiuza.maicon.mercado_livro.domain.dto.CustomerDto
import fiuza.maicon.mercado_livro.domain.dto.CustomerPatchDto
import fiuza.maicon.mercado_livro.extensions.toCustomerModel
import fiuza.maicon.mercado_livro.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping()
    fun getAllCustomer(@RequestParam name: String?): ResponseEntity<List<Customer>> {
        val allCustomer =  customerService.getAll(name)

        return ResponseEntity(allCustomer, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findCustomer(@PathVariable id: Int): ResponseEntity<Customer> {
        val customer = customerService.find(id)
        return ResponseEntity(customer, HttpStatus.OK )
    }

    @PostMapping
    fun createCustomer(@RequestBody customer: CustomerDto): ResponseEntity<Customer> {
      val newCustomer = customerService.create(customer.toCustomerModel())
      return ResponseEntity(newCustomer, HttpStatus.CREATED)
    }

   // @PutMapping("/{id}") //não é comum método update retornar dados
    //fun updateUser(@PathVariable id: Int, @RequestBody updatedUser: CustomerDto) {
      //  customerService.update(id, updatedUser)
    //}

    //@PatchMapping("/{id}")
    //fun updateOnly(@PathVariable id: Int, @RequestBody updatedUser: CustomerPatchDto) {
      //  customerService.onlyUpdate(id,updatedUser)
    //}

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Int) {
        customerService.delete(id)
    }

}