package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;
import mocks.crud.task.repository.AdvancedRepository;
import mocks.crud.task.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonService implements AdvancedRepository {

    private AddressService addressService;

    private CrudRepository<Long, Person> personRepository;

    public PersonService(AddressService addressService, CrudRepository<Long, Person> personRepository) {
        this.addressService = addressService;
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllRelatives(Person person) {
        //todo написать реализацию

        List<Person> result = new ArrayList<>();
        for (Person p : person.getRelatives()){
            if (p.getRelatives().size()==0) result.add(p);
            else {
                result.add(p);
                result.addAll(findAllRelatives(p));
            }
        }
        return result;
    }

    @Override
    public Address getAddress(Person person) {
        //todo написать реализацию
        return person.getAddress();
    }

    public void save(Person element) {
        //todo написать реализацию
        personRepository.save(element);
    }

    public Person findById(Long id) {
        //todo написать реализацию
        return personRepository.findById(id);
    }

    public List<Person> findAll() {
        //todo написать реализацию
        return personRepository.findAll();
    }

    public Person update(Person element) {
        //todo написать реализацию
        return personRepository.update(element);
    }

    public void delete(Person element) {
        //todo написать реализацию
        personRepository.delete(element);
    }
}
