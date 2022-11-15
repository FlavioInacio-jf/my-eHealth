package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;

import java.util.ArrayList;

import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertTrue(unidade.equals(this.repository.findByCNPJ(unidade.getCNPJ())));
        this.repository.delete(unidade.getId());
    }

    @Test
    public void testUpdate(){
        Address endereco = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "987909123");

        HealthUnit unidade = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21. 987. 127/0001-24", endereco);

        this.repository.create(unidade);
        unidade.setName("UBS SE");
        unidade.setCNPJ("21. 987. 127/0001-25");
        unidade.setId("teste");
        unidade.setType(UnitTypeEnum.UBS);
        this.repository.update(unidade);

        assertTrue(this.repository.findByCNPJ(unidade.getCNPJ()).equals(unidade));

    }

    @Test 
    public void testDelete(){
        IHealthUnitRepository repository2 = new HealthUnitRepository();

        Address endereco = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "987909123");

        HealthUnit unidade = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21. 987. 127/0001-24", endereco);
        
        this.repository.create(unidade);
        this.repository.delete(unidade.getId());
        assertEquals(repository, repository2);

    }

    @Test
    public void testFindByName(){
        Address endereco = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "987909123");

        HealthUnit unidade = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21. 987. 127/0001-24", endereco);

        this.repository.create(unidade);
        assertTrue(unidade.equals(this.repository.findByName(unidade.getName())));
        this.repository.delete(unidade.getId());
    }

    @Test
    public void testFindByCNPJ(){
        Address endereco = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "987909123");

        HealthUnit unidade = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21. 987. 127/0001-24", endereco);
        
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
        Address endereco = new Address("Rua flavao", "Bairro Oliveira",
         "Aracaju", "Sergipe", "987909123");

        Address endereco2 = new Address("Abbey Road", "Farolandia",
         "Liverpool", "Teste", "8329831298");

         Address endereco3 = new Address("Salvador", "Aruana",
         "Joao pessoa", "Paraiba", "1232342134342"); 

        HealthUnit unidade = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21. 987. 127/0001-24", endereco);

        HealthUnit unidade2 = new HealthUnit(null,UnitTypeEnum.UBS,
    "UBS Inglaterra", "12. 768. 132/9991-38", endereco2);

        HealthUnit unidade3 = new HealthUnit(null,UnitTypeEnum.UPA,
    "UPA Paraiba", "56. 198. 789/1243-57", endereco3);

        ArrayList<HealthUnit> listunidades = new ArrayList<>();
        listunidades.add(unidade);
        listunidades.add(unidade2);
        listunidades.add(unidade3);

        this.repository.create(unidade);
        this.repository.create(unidade2);
        this.repository.create(unidade3);

        assertEquals(listunidades, this.repository.getAll());
    }
}
