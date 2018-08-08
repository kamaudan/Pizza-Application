package Repository;

import  Models.Pizza;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import static javafx.scene.input.KeyCode.M;

public interface PizzaRepository extends ReactiveMongoRepository<Pizza, Long> {

}
