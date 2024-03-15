import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import services.AnimalService;

@QuarkusMain
public class QuarkusRunner {
    public static void main(String[] args) {

        Quarkus.run(args);
        AnimalService animalService = new AnimalService();

        System.out.println(animalService.findAll());
    }
}