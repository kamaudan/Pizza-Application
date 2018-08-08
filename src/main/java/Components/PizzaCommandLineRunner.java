package Components;

import Models.Pizza;
import Repository.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Stream;
@Component
public class PizzaCommandLineRunner {

    private PizzaRepository pizzaRepository;



    @Bean
    CommandLineRunner demo(PizzaRepository pizzaRepository ) {
        return  args -> pizzaRepository.deleteAll()
                .subscribe( null, null ,() ->
                        Stream.of("Hawaiyan", "Peri peri chicken", "Chicken Tikka", "Pizza Mwitu",
                                "Pizza Avo")
                                .map(name -> new Pizza (name))
                                .forEach( m -> pizzaRepository.save(m).subscribe(System.out::println)));

    }





}
