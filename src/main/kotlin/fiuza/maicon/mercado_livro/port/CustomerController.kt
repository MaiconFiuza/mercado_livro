package fiuza.maicon.mercado_livro.port

import fiuza.maicon.mercado_livro.domain.Customer
import fiuza.maicon.mercado_livro.domain.dto.CustomerDto
import org.springframework.http.HttpStatus
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

    @GetMapping()
    fun findCustomer(): Customer {
        return Customer(
            id = "1",
            name = "Fifiuza",
            email = "maicon.b.fiuza@gmail.com"
        )
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED )
    fun createCustomer(@RequestBody customer: CustomerDto) {
       println(customer)
    }
}