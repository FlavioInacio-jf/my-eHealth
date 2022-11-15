package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.getAllHealthUnits.GetAllHealthUnitsController;
import javas.modules.healthUnit.useCases.getAllHealthUnits.GetAllHealthUnitsUseCase;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetAllHealthUnitsControllerTest {
    IHealthUnitRepository healthUnitRepository;
    GetAllHealthUnitsUseCase getAllHealthUnitsUseCase;
    public GetAllHealthUnitsControllerTest() {
        this.healthUnitRepository = new HealthUnitRepository();
        this.getAllHealthUnitsUseCase = new GetAllHealthUnitsUseCase(this.healthUnitRepository);
    }

    @Test
    public void execute() {
        GetAllHealthUnitsController getAllHealthUnitsController = new GetAllHealthUnitsController(this.getAllHealthUnitsUseCase);

        Address address1 = new Address("Rua flavao", "Bairro Oliveira",
                "Aracaju", "Sergipe", "987909123");

        HealthUnit healthUnit1 = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "21.789.127/0001-24", address1);

        Address address2 = new Address("Rua flavao", "Bairro Oliveira",
                "Aracaju", "Sergipe", "987909123");

        HealthUnit healthUnit2 = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "21.123.653/0001-24", address2);

        try {
            this.healthUnitRepository.create(healthUnit1);
            this.healthUnitRepository.create(healthUnit2);
        }catch (Error ignored) {
            fail();
        }

        ArrayList<HealthUnit> healthUnits = getAllHealthUnitsController.execute();
        assertTrue(healthUnits.contains(healthUnit1));
        assertTrue(healthUnits.contains(healthUnit2));

        try {
            this.healthUnitRepository.delete(healthUnit1.getId());
            this.healthUnitRepository.delete(healthUnit2.getId());
        }catch (Error ignored) {
        }
    }
}
