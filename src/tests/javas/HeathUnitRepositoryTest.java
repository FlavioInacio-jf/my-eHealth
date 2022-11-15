package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;


import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeathUnitRepositoryTest {
    
    public IHealthUnitRepository repository; 

    public HeathUnitRepositoryTest(){
        this.repository = new HealthUnitRepository();
    }

    @Test
    public void testCreate(){
        Address endereco = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "98790-123");

        HealthUnit unidade = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21.987.127/0001-24", endereco);
        
        this.repository.create(unidade);
        assertTrue(unidade.equals(this.repository.findById(unidade.getId())));
        this.repository.delete(unidade.getId());
    }

    @Test
    public void testUpdate(){
        Address endereco = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "987909123");

        HealthUnit unidade = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21.987.127/0001-24", endereco);

        this.repository.create(unidade);
        unidade.setName("UBS SE");
        unidade.setCNPJ("21.987.127/0001-25");
        unidade.setType(UnitTypeEnum.UBS);
        this.repository.update(unidade);
        assertTrue(this.repository.findByCNPJ(unidade.getCNPJ()).equals(unidade));
        this.repository.delete(unidade.getId());

    }

    @Test 
    public void testDelete(){
        Address endereco = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "987909123");
        HealthUnit healthUnit = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21.987.127/0001-24", endereco);
        
        this.repository.create(healthUnit);
        this.repository.delete(healthUnit.getId());
        assertNull(this.repository.findById(healthUnit.getId()));
    }

    @Test
    public void testFindByCNPJ(){
        Address endereco = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "987909123");

        HealthUnit unidade = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21.444.127/0001-24", endereco);
        
        this.repository.create(unidade);
        assertTrue(unidade.equals(this.repository.findByCNPJ(unidade.getCNPJ())));
        this.repository.delete(unidade.getId());

    }

    @Test
    public void testFindById(){
        Address endereco = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "987909123");

        HealthUnit unidade = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21. 987. 127/0001-24", endereco);

        this.repository.create(unidade);
        assertTrue(unidade.equals(this.repository.findById(unidade.getId())));
        this.repository.delete(unidade.getId());

    }

    @Test
    public void testGetAll(){
        Address addressHealthUnit1 = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "987909123");

        Address addressHealthUnit2 = new Address("Abbey Road", "Farolandia",
         "Liverpool", "Teste", "8329831298");

        Address addressHealthUnit3 = new Address("Salvador", "Aruana",
         "Joao pessoa", "Paraiba", "1232342134342"); 

        HealthUnit healthUnit1 = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21.987.127/0001-24", addressHealthUnit1);

        HealthUnit healthUnit2 = new HealthUnit(null,UnitTypeEnum.UBS,
    "UBS Inglaterra", "12.768.132/9991-38", addressHealthUnit2);

        HealthUnit healthUnit3 = new HealthUnit(null,UnitTypeEnum.UPA,
    "UPA Paraiba", "56.198.789/1243-57", addressHealthUnit3);

        this.repository.create(healthUnit1);
        this.repository.create(healthUnit2);
        this.repository.create(healthUnit3);

        assertTrue(this.repository.getAll().contains(healthUnit1));
        assertTrue(this.repository.getAll().contains(healthUnit2));
        assertTrue(this.repository.getAll().contains(healthUnit3));

        this.repository.delete(healthUnit1.getId());
        this.repository.delete(healthUnit2.getId());
        this.repository.delete(healthUnit3.getId());
    }
}
