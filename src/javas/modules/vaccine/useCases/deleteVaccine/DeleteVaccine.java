package javas.modules.vaccine.useCases.deleteVaccine;

import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;

public class DeleteVaccine {
    private static final IVaccineRepository vaccineRepository = new VaccineRepository();
    private static final DeleteVaccineUseCase deleteVaccineUseCase = new DeleteVaccineUseCase(vaccineRepository);
    public static final DeleteVaccineController deleteVaccineController = new DeleteVaccineController(deleteVaccineUseCase);
}
