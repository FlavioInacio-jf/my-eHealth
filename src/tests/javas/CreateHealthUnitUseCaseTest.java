package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.createHealthUnit.CreateHealthUnitUseCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateHealthUnitUseCaseTest {
    IHealthUnitRepository healthUnitRepository;
    public CreateHealthUnitUseCaseTest() {
        this.healthUnitRepository = new HealthUnitRepository();
    }

    @Test
    public void testHandle() {
        CreateHealthUnitUseCase createHealthUnitUseCase = new CreateHealthUnitUseCase(this.healthUnitRepository);
        Address address = new Address("Rua flavao", "Bairro Oliveira",
                "Aracaju", "Sergipe", "987909123");

        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "21.456.127/0001-24", address);

        createHealthUnitUseCase.handle(healthUnit);
        assertTrue(this.healthUnitRepository.findById(healthUnit.getId()).equals(healthUnit));
        this.healthUnitRepository.delete(healthUnit.getId());
        assertNull(this.healthUnitRepository.findById(healthUnit.getId()));
    }
}
