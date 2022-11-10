package javas.modules.vaccine.repositories;

import javas.modules.vaccine.models.Vaccine;

import java.util.ArrayList;

public interface IVaccineRepository {
    public Vaccine crate(String _idUser, Vaccine data);
    public boolean update(Vaccine data);
    public boolean delete(String _id);
    public Vaccine findById(String _id);
    public ArrayList<Vaccine> getAll(String personID);
}
