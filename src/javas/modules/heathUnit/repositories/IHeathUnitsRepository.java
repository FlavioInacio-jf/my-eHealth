package javas.modules.heathUnit.repositories;

import javas.modules.heathUnit.models.HeathUnit;

public interface IHeathUnitsRepository {
    public HeathUnit create(HeathUnit data);
    public void update(String _id);
    public HeathUnit delete(String _id);
    public HeathUnit findById(String _id);
    public HeathUnit[] findAll();
}
