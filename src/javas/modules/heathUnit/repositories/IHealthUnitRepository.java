package javas.modules.heathUnit.repositories;

import javas.modules.heathUnit.models.HealthUnit;

import java.util.ArrayList;

public interface IHealthUnitRepository {
    HealthUnit create(HealthUnit data);
    boolean update(HealthUnit data);
    boolean delete(String _id);

    HealthUnit findByName(String name);

    HealthUnit findByCNPJ(String cnpj);
    HealthUnit findById(String _id);
    ArrayList<HealthUnit> getAll();
}
