package javas.modules.vaccine.useCases.deleteVaccine;

import javas.errors.CustomError;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;

import javas.exceptions.VaccineErrorMessages;

public class DeleteVaccineUseCase {
    private IVaccineRepository vaccineRepository;
    public DeleteVaccineUseCase(IVaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    public void handle(String _id) {
        Vaccine vaccineExists = this.vaccineRepository.findById(_id);

        if (vaccineExists == null) {
            throw new CustomError(VaccineErrorMessages.VACCINE_NOT_FOUND_TITLE,
                                    VaccineErrorMessages.VACCINE_NOT_FOUND_DETAIL);
        }

        this.vaccineRepository.delete(_id);
    }
}
