package javas.modules.vaccine.useCases.updateVaccine;

import javas.errors.CustomError;
import javas.exceptions.VaccineErrorMessages;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;

public class UpdateVaccineUseCase {
    private IVaccineRepository vaccineRepository;
    public UpdateVaccineUseCase(IVaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    public void handle(Vaccine vaccine) {
       Vaccine vaccineExists = this.vaccineRepository.findById(vaccine.getId());
       if (vaccineExists == null) {
           throw new CustomError(VaccineErrorMessages.VACCINE_NOT_FOUND_TITLE,
                                 VaccineErrorMessages.VACCINE_NOT_FOUND_DETAIL);
       }

       vaccineExists.setName(vaccine.getName());
       vaccineExists.setDose(vaccine.getDose());
       vaccineExists.setLot(vaccine.getLot());

       this.vaccineRepository.update(vaccineExists);
    }
}
