package java.modules.heathUnit.repositories;

import java.modules.heathUnit.models.HeathUnit;

public interface IHeathUnitsRepository {
    public HeathUnit create(HeathUnit data);
    public void update(String _id);
    public HeathUnit delete(String _id);
    public HeathUnit findById(String _id);
    public HeathUnit[] findAll();
}
