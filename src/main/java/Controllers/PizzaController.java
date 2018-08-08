package Controllers;

import Models.Pizza;
import Repository.PizzaRepository;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;



@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaRepository pizzaRepository;


    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    @GetMapping
    public Flux<Pizza> list(){
        return pizzaRepository.findAll ();


    }

    @PostMapping
    public Pizza addPizza(@RequestBody Pizza pizza){
         pizzaRepository.save(pizza);

         return pizza;
    }



}
