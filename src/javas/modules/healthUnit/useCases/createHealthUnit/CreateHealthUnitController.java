package javas.modules.healthUnit.useCases.createHealthUnit;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.validations.Validation;

public class CreateHealthUnitController {
    CreateHealthUnitUseCase createHealthUnitUseCase;

    public CreateHealthUnitController(CreateHealthUnitUseCase createHealthUnitUseCase){
        this.createHealthUnitUseCase = createHealthUnitUseCase;
    }
    public void execute(
            String type,
            String name,
            String cnpj,
            String street,
            String district,
            String city,
            String state,
            String postalCode // CEP
    ) throws IllegalAccessException {

        Address address = new Address(street, district, city, state, postalCode);
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.valueOf(type), name, cnpj, address);
        new Validation(healthUnit).validate();
        this.createHealthUnitUseCase.handle(healthUnit);
    }
}
