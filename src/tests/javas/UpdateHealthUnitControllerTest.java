package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.updateHeathUnit.UpdateHealthUnitController;
import javas.modules.healthUnit.useCases.updateHeathUnit.UpdateHealthUnitUseCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UpdateHealthUnitControllerTest {
    IHealthUnitRepository healthUnitRepository;
    UpdateHealthUnitUseCase updateHealthUnitUseCase;

    public UpdateHealthUnitControllerTest() {
        this.healthUnitRepository = new HealthUnitRepository();
        this.updateHealthUnitUseCase = new UpdateHealthUnitUseCase(this.healthUnitRepository);
    }

    @Test
    public void execute() {
        UpdateHealthUnitController updateHealthUnitController = new UpdateHealthUnitController(updateHealthUnitUseCase);
        Address address = new Address("Rua flavao", "Bairro Oliveira",
                "Aracaju", "Sergipe", "44444-000");

        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "19.865.563/0001-24", address);

        this.healthUnitRepository.create(healthUnit);
        try {
            this.healthUnitRepository.findById(healthUnit.getId());
        }catch (Error ignored) {
            fail();
        }
        healthUnit.setName("João Alves Filho");
        try {
            updateHealthUnitController.execute("HOSPITAL",
                                                healthUnit.getName(),
                                                healthUnit.getCNPJ(),
                                                healthUnit.getAddress().getStreet(),
                                                healthUnit.getAddress().getDistrict(),
                                                healthUnit.getAddress().getCity(),
                                                healthUnit.getAddress().getState(),
                                                healthUnit.getAddress().getPostalCode());
        }catch (Error | IllegalAccessException ignored) {
            fail();
        }
        assertTrue(this.healthUnitRepository.findByCNPJ(healthUnit.getCNPJ()).equals(healthUnit));
        this.healthUnitRepository.delete(healthUnit.getId());
    }
}
