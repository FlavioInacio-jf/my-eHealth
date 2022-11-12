package javas.modules.vaccine.repositories;

import javas.modules.vaccine.models.Vaccine;
import java.util.ArrayList;

public interface IVaccineRepository {
    Vaccine crate(String _idUser, String _idHealthUnit, Vaccine data);
    boolean update(Vaccine data);
    boolean delete(String _id);
    ArrayList<Vaccine> findByUserId(String userId);

    ArrayList<Vaccine>  findByHeathUnitId(String healthUnitId);

    Vaccine findById(String _id);

}
