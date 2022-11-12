package javas.modules.vaccine.useCases.updateVaccine;

import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;

public class UpdateVaccine {
    private static final IVaccineRepository vaccineRepository =  new VaccineRepository();
    private static final UpdateVaccineUseCase updateVaccineUseCase = new UpdateVaccineUseCase(vaccineRepository);
    public static final UpdateVaccineController updateVaccineController = new UpdateVaccineController(updateVaccineUseCase);
}
