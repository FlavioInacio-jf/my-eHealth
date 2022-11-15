package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.getSingleHealthUnit.GetSingleHealthUnitController;
import javas.modules.healthUnit.useCases.getSingleHealthUnit.GetSingleHealthUnitUseCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetSingleHealthUnitControllerTest {
    IHealthUnitRepository healthUnitRepository;
    GetSingleHealthUnitUseCase getSingleHealthUnitUseCase;
    public GetSingleHealthUnitControllerTest() {
        this.healthUnitRepository = new HealthUnitRepository();
        this.getSingleHealthUnitUseCase = new GetSingleHealthUnitUseCase(this.healthUnitRepository);
    }

    @Test
    public void execute() {
        GetSingleHealthUnitController getSingleHealthUnitController = new GetSingleHealthUnitController(getSingleHealthUnitUseCase);

        Address address = new Address("Rua flavao", "Bairro Oliveira",
                "Aracaju", "Sergipe", "987909123");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "13.659.127/0001-24", address);

        this.healthUnitRepository.create(healthUnit);
        assertTrue(getSingleHealthUnitController.execute(healthUnit.getCNPJ()).equals(healthUnit));
        this.healthUnitRepository.delete(healthUnit.getId());

        try {
            assertNull(getSingleHealthUnitController.execute(healthUnit.getCNPJ()));
            fail();
        }catch (Error ignored) {
        }
    }
}
