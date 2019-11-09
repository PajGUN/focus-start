package mocks.crud.task.service;

import mocks.crud.task.model.Person;
import mocks.crud.task.repository.CrudRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private CrudRepository <Long, Person> personRepository;

    private PersonService personService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        personService = new PersonService(new AddressService(), personRepository);
    }

    @Test
    public void findAllRelatives(){
        UtilsRelativesCrowd.daughterIren.addRelatives(UtilsRelativesCrowd.motherElena);
        UtilsRelativesCrowd.daughterIren.addRelatives(UtilsRelativesCrowd.fatherVladimir);
        UtilsRelativesCrowd.fatherVladimir.addRelatives(UtilsRelativesCrowd.grandFatherPetr);
        UtilsRelativesCrowd.motherElena.addRelatives(UtilsRelativesCrowd.grandMotherVera);

        assertEquals(4, personService.findAllRelatives(UtilsRelativesCrowd.daughterIren).size());
    }

    @Test
    public void getAddress(){
        assertEquals(UtilsRelativesCrowd.family1, UtilsRelativesCrowd.daughterIren.getAddress());
    }

    @Test
    public void save(){
        Mockito.doNothing().when(personRepository).save(UtilsRelativesCrowd.someNeighborVasia);
        personRepository.save(UtilsRelativesCrowd.someNeighborVasia);
        Mockito.verify(personRepository, Mockito.times(1)).save(UtilsRelativesCrowd.someNeighborVasia);
    }

    @Test
    public void findById(){
        Mockito.when(personRepository.findById(4L)).thenReturn(UtilsRelativesCrowd.motherElena);
        assertEquals(UtilsRelativesCrowd.motherElena, personRepository.findById(4L));
        Mockito.verify(personRepository, Mockito.times(1)).findById(4L);
    }

    @Test
    public void findAll(){
        List<Person> people = new ArrayList<>();
        people.add(UtilsRelativesCrowd.daughterIren);
        people.add(UtilsRelativesCrowd.sonBoris);
        people.add(UtilsRelativesCrowd.sonMax);

        Mockito.when(personRepository.findAll()).thenReturn(people);
        assertEquals(3, personRepository.findAll().size());
        Mockito.verify(personRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void update(){
        Person person1 = new Person("Дима",31,UtilsRelativesCrowd.family4);
        Person person2 = new Person("Дима",32,UtilsRelativesCrowd.family4);
        Mockito.when(personRepository.update(person1)).thenReturn(person2);
        assertNotEquals(person1, personRepository.update(person1));
        Mockito.verify(personRepository, Mockito.times(1)).update(person1);
    }

    @Test
    public void delete(){
        Mockito.doNothing().when(personRepository).delete(UtilsRelativesCrowd.sonBoris);
        personRepository.delete(UtilsRelativesCrowd.sonBoris);
        Mockito.verify(personRepository, Mockito.times(1)).delete(UtilsRelativesCrowd.sonBoris);
    }

}