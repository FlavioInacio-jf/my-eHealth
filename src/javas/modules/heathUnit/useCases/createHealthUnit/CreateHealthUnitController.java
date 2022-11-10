package javas.modules.heathUnit.useCases.createHealthUnit;

import javas.modules.app.models.Address;
import javas.modules.heathUnit.enums.UnitTypeEnum;
import javas.modules.heathUnit.models.HealthUnit;

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
    ){
        try {
            Address address = new Address(street, district, city, state, postalCode);
            HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.valueOf(type), name, cnpj, address);
            this.createHealthUnitUseCase.handle(healthUnit);
        }catch (Error error) {
            throw new Error(error);
        }
    }
}
