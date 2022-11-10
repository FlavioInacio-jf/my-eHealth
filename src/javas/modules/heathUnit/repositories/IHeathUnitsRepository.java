package javas.modules.heathUnit.repositories;

import javas.modules.heathUnit.models.HeathUnit;

import java.util.ArrayList;

public interface IHeathUnitsRepository {
    HeathUnit create(HeathUnit data);
    boolean update(HeathUnit data);
    boolean delete(String _id);

    HeathUnit findByName(String name);

    HeathUnit findByCNPJ(String cnpj);
    HeathUnit findById(String _id);
    ArrayList<HeathUnit> getAll();
}
