package javas.modules.vaccine.useCases.getAllVaccines;

import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;

public class GetAllVaccines {
    private static final IVaccineRepository vaccineRepository = new VaccineRepository();
    private static final GetAllVaccinesUseCase getAllVaccinesUseCase = new GetAllVaccinesUseCase(vaccineRepository);
    public static final GetAllVaccinesController getAllVaccinesController = new GetAllVaccinesController(getAllVaccinesUseCase);
}
