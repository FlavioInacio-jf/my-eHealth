package javas.modules.vaccine.repositories;

import javas.modules.vaccine.models.Vaccine;
import java.util.ArrayList;

public interface IVaccineRepository {
    Vaccine create(String _idUser, String _idHealthUnit, Vaccine data);
    boolean update(Vaccine data);
    boolean delete(String _id);
    ArrayList<Vaccine> findAll(String query);

    Vaccine findById(String _id);

}
