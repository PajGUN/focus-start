package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class AddressService implements CrudRepository<Long, Address> {

    private List<Address> addresses = new ArrayList<>();

    @Override
    public void save(Address element) {
        //todo написать реализацию
        addresses.add(element);
    }

    @Override
    public Address findById(Long id) {
        //todo написать реализацию
        for (Address address : addresses) {
            if (address.getId().equals(id)) return address;
        }
        return null;
    }

    @Override
    public List<Address> findAll() {
        //todo написать реализацию
        return addresses;
    }

    @Override
    public Address update(Address element) {
        //todo написать реализацию
        //Предположу что метод должен возвращать старый адрес, т.к новый имеется в аргументе.
        for (Address address : addresses) {
            if (address.getId().equals(element.getId())){
                Address oldAdr = new Address(address.getId(), address.getAddress());
                address.setAddress(element.getAddress());
                return oldAdr;
            }
        }
        return null;
    }

    @Override
    public void delete(Address element) {
        //todo написать реализацию
        addresses.remove(element);
    }
}
