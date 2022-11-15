package javas.modules.vaccine.useCases.getAllVaccines;

import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;

import java.util.ArrayList;

public class GetAllVaccinesUseCase {
    private IVaccineRepository vaccineRepository;

    public GetAllVaccinesUseCase(IVaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }
    public ArrayList<Vaccine> handle(String querySQL) {
        return this.vaccineRepository.findAll(querySQL);
    }
}
