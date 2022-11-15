package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.deleteHealthUnit.DeleteHealthUnitUseCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteHealthUnitUseCaseTest {
    IHealthUnitRepository healthUnitRepository;
    public DeleteHealthUnitUseCaseTest() {
        this.healthUnitRepository = new HealthUnitRepository();
    }

    @Test
    public void testHandle() {
        DeleteHealthUnitUseCase deleteHealthUnitUseCase = new DeleteHealthUnitUseCase(this.healthUnitRepository);
        Address address = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "987909123");

        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "21.222.333/0001-24", address);

        this.healthUnitRepository.create(healthUnit);
        assertTrue(healthUnit.equals(this.healthUnitRepository.findById(healthUnit.getId())));
        deleteHealthUnitUseCase.handle(healthUnit.getCNPJ());
        assertNull(this.healthUnitRepository.findById(healthUnit.getId()));

        try {
            deleteHealthUnitUseCase.handle(healthUnit.getCNPJ());
            fail();
        }catch (Error ignored) {
        }
    }
}
