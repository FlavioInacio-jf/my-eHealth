package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.getAllHealthUnits.GetAllHealthUnitsUseCase;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetAllHealthUnitsUseCaseTest {
    IHealthUnitRepository healthUnitRepository;
    public GetAllHealthUnitsUseCaseTest() {
        this.healthUnitRepository = new HealthUnitRepository();
    }

    @Test
    public void testHandle() {
        GetAllHealthUnitsUseCase getAllHealthUnitsUseCase = new GetAllHealthUnitsUseCase(this.healthUnitRepository);

        Address address1 = new Address("Rua flavao", "Bairro Oliveira",
                "Aracaju", "Sergipe", "987909123");

        HealthUnit healthUnit1 = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "21.699.127/0001-24", address1);

        Address address2 = new Address("Rua flavao", "Bairro Oliveira",
                "Aracaju", "Sergipe", "987909123");

        HealthUnit healthUnit2 = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "21.123.127/0001-24", address2);

        try {
            this.healthUnitRepository.create(healthUnit1);
            this.healthUnitRepository.create(healthUnit2);
        }catch (Error ignored) {
            fail();
        }

        ArrayList<HealthUnit> healthUnits = getAllHealthUnitsUseCase.handle();
        assertTrue(healthUnits.contains(healthUnit1));
        assertTrue(healthUnits.contains(healthUnit2));

        try {
            this.healthUnitRepository.delete(healthUnit1.getId());
            this.healthUnitRepository.delete(healthUnit2.getId());
        }catch (Error ignored) {
        }
    }
}
