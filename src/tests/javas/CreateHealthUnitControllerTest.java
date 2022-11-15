package tests.javas;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.createHealthUnit.CreateHealthUnitController;
import javas.modules.healthUnit.useCases.createHealthUnit.CreateHealthUnitUseCase;
import org.junit.Test;

import static org.junit.Assert.fail;

public class CreateHealthUnitControllerTest {
    IHealthUnitRepository healthUnitRepository;
    CreateHealthUnitUseCase createHealthUnitUseCase;
    public CreateHealthUnitControllerTest() {
        this.healthUnitRepository = new HealthUnitRepository();
        this.createHealthUnitUseCase = new CreateHealthUnitUseCase(this.healthUnitRepository);
    }

    @Test
    public void execute() {
        CreateHealthUnitController createHealthUnitController = new CreateHealthUnitController(this.createHealthUnitUseCase);
        try {
            createHealthUnitController.execute("UBS", "Hospital Inacio", "21.987.127/0001-24",
                    "Rua flavao", "Bairro Oliveira",
                    "Aracaju", "Sergipe", "44445-000");
        } catch (IllegalAccessException | Error e) {
            fail();
        }

        try {
            createHealthUnitController.execute("UBS", "Hospital Inacio", "",
                    "Rua flavao", "Bairro Oliveira",
                    "Aracaju", "Sergipe", "44445-000");
            fail();
        } catch (IllegalAccessException | Error e) {
        }
        this.healthUnitRepository.delete(this.healthUnitRepository.findByCNPJ("21.987.127/0001-24").getId());
    }

}
