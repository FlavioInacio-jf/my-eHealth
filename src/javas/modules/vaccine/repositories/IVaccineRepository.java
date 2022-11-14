package javas.modules.vaccine.repositories;

import javas.modules.vaccine.models.Vaccine;
import java.util.ArrayList;

public interface IVaccineRepository {
    Vaccine create(String _idUser, String _idHealthUnit, Vaccine data);
    boolean update(Vaccine data);
    boolean delete(String _id);
    ArrayList<Vaccine> findByUserId(String userId);

    ArrayList<Vaccine>  findByHealthUnitId(String healthUnitId);

    Vaccine findById(String _id);

}
