package javas.modules.healthUnit.useCases.updateHeathUnit;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;

public class UpdateHealthUnitController {
    UpdateHealthUnitUseCase updateHealthUnitUseCase;

    public UpdateHealthUnitController(UpdateHealthUnitUseCase updateHealthUnitUseCase){
        this.updateHealthUnitUseCase = updateHealthUnitUseCase;
    }
    public void execute (
            String type,
            String name,
            String cnpj,
            String street,
            String district,
            String city,
            String state,
            String postalCode)
    {
        Address address = new Address(street, district, city, state, postalCode);
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.valueOf(type), name, cnpj, address);
        this.updateHealthUnitUseCase.handle(healthUnit);
    }
}
