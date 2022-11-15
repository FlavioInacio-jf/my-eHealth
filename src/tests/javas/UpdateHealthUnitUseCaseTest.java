package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.updateHeathUnit.UpdateHealthUnitUseCase;
import org.junit.Test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UpdateHealthUnitUseCaseTest {
    IHealthUnitRepository healthUnitRepository;
    public UpdateHealthUnitUseCaseTest() {
        this.healthUnitRepository = new HealthUnitRepository();
    }

    @Test
    public void testHandle() {
        UpdateHealthUnitUseCase updateHealthUnitUseCase = new UpdateHealthUnitUseCase(this.healthUnitRepository);
        Address address = new Address("Rua flavao", "Bairro Oliveira",
                "Aracaju", "Sergipe", "987909123");

        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "19.865.563/0001-24", address);

        this.healthUnitRepository.create(healthUnit);
        try {
            this.healthUnitRepository.findById(healthUnit.getId());
        }catch (Error ignored) {
            fail();
        }
        healthUnit.setName("João Alves Filho");
        updateHealthUnitUseCase.handle(healthUnit);
        assertTrue(this.healthUnitRepository.findByCNPJ(healthUnit.getCNPJ()).equals(healthUnit));

        this.healthUnitRepository.delete(healthUnit.getId());
    }
}
