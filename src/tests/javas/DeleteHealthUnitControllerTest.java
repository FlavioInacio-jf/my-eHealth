package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.deleteHealthUnit.DeleteHealthUnitController;
import javas.modules.healthUnit.useCases.deleteHealthUnit.DeleteHealthUnitUseCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteHealthUnitControllerTest {
    IHealthUnitRepository healthUnitRepository;
    DeleteHealthUnitUseCase deleteHealthUnitUseCase;
    public DeleteHealthUnitControllerTest() {
        this.healthUnitRepository = new HealthUnitRepository();
        this.deleteHealthUnitUseCase = new DeleteHealthUnitUseCase(this.healthUnitRepository);
    }

    @Test
    public void execute() {
        DeleteHealthUnitController deleteHealthUnitController = new DeleteHealthUnitController(this.deleteHealthUnitUseCase);
        Address address = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "987909123");

        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "21.222.333/0001-24", address);

        this.healthUnitRepository.create(healthUnit);
        assertTrue(healthUnit.equals(this.healthUnitRepository.findById(healthUnit.getId())));
        deleteHealthUnitController.execute(healthUnit.getCNPJ());
        assertNull(this.healthUnitRepository.findById(healthUnit.getId()));

        try {
            deleteHealthUnitController.execute(healthUnit.getCNPJ());
            fail();
        }catch (Error ignored) {
        }
    }
}
