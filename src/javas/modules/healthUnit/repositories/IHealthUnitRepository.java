package javas.modules.healthUnit.repositories;

import javas.modules.healthUnit.models.HealthUnit;

import java.util.ArrayList;

public interface IHealthUnitRepository {
    HealthUnit create(HealthUnit data);
    boolean update(HealthUnit data);
    boolean delete(String _id);

    HealthUnit findByCNPJ(String cnpj);
    HealthUnit findById(String _id);
    ArrayList<HealthUnit> getAll();
}
