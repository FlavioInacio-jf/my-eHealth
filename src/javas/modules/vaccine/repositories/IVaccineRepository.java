package javas.modules.vaccine.repositories;

import javas.modules.vaccine.models.Vaccine;
import java.util.ArrayList;

public interface IVaccineRepository {
    public Vaccine crate(String _idUser, String _idHeathUnit, Vaccine data);
    public boolean update(Vaccine data);
    public boolean delete(String _id);
    public Vaccine findById(String _id);
    public ArrayList<Vaccine> findByUserCPF(String userCPF);

    public ArrayList<Vaccine>  findByHeathUnitCNPJ(String heathUnitCNPJ);
    public ArrayList<Vaccine> getAll(String personID);
}
