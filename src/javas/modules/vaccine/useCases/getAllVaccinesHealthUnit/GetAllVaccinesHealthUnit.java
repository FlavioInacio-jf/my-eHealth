package javas.modules.vaccine.useCases.getAllVaccinesHealthUnit;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;

public class GetAllVaccinesHealthUnit {
    private static final IVaccineRepository vaccineRepository = new VaccineRepository();
    private static final IHealthUnitRepository healthUnitRepository = new HealthUnitRepository();
    private static final GetAllVaccinesHealthUnitUseCase getAllVaccinesHealthUnitUseCase= new GetAllVaccinesHealthUnitUseCase(vaccineRepository, healthUnitRepository);
    public static final GetAllVaccinesHealthUnitController getAllVaccinesHealthUnitController = new GetAllVaccinesHealthUnitController(getAllVaccinesHealthUnitUseCase);
}
