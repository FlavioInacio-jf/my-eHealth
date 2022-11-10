package javas.modules.vaccine.repositories.impementations;

import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;

import java.util.ArrayList;

public class VaccineRepository implements IVaccineRepository {
    @Override
    public Vaccine crate(String _idUser, Vaccine data) {
        return null;
    }

    @Override
    public boolean update(Vaccine data) {
        return false;
    }

    @Override
    public boolean delete(String _id) {
        return false;
    }

    @Override
    public Vaccine findById(String _id) {
        return null;
    }

    @Override
    public ArrayList<Vaccine> getAll(String _idUser) {
        return null;
    }
}
