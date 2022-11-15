package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.getSingleHealthUnit.GetSingleHealthUnitUseCase;
import org.junit.Test;

import static org.junit.Assert.*;


public class GetSingleHealthUnitUseCaseTest {
    IHealthUnitRepository healthUnitRepository;
    public GetSingleHealthUnitUseCaseTest() {
        this.healthUnitRepository = new HealthUnitRepository();
    }

    @Test
    public void testHandle() {
        GetSingleHealthUnitUseCase getSingleHealthUnitUseCase  = new GetSingleHealthUnitUseCase(this.healthUnitRepository);

        Address address = new Address("Rua flavao", "Bairro Oliveira",
                "Aracaju", "Sergipe", "987909123");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "13.789.127/0001-24", address);

        this.healthUnitRepository.create(healthUnit);
        assertTrue(getSingleHealthUnitUseCase.handle(healthUnit.getCNPJ()).equals(healthUnit));
        this.healthUnitRepository.delete(healthUnit.getId());

        try {
            assertNull(getSingleHealthUnitUseCase.handle(healthUnit.getCNPJ()));
            fail();
        }catch (Error ignored) {
        }
    }
}
