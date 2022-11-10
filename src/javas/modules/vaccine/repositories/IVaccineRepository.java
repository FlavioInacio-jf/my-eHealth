package javas.modules.vaccine.repositories;

import javas.modules.vaccine.models.Vaccine;
import java.util.ArrayList;

public interface IVaccineRepository {
    Vaccine crate(String _idUser, String _idHealthUnit, Vaccine data);
    boolean update(Vaccine data);
    boolean delete(String _id);
    Vaccine findById(String _id);
    ArrayList<Vaccine> findByUserCPF(String userCPF);

    ArrayList<Vaccine>  findByHeathUnitCNPJ(String heathUnitCNPJ);
    ArrayList<Vaccine> getAll(String personID);
}
