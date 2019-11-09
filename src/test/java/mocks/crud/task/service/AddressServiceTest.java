package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressServiceTest {
    private AddressService addressService;

    @Before
    public void init(){
        addressService = new AddressService();
    }

    @Test
    public void saveAddressAndGetAll(){
        addressService.save(UtilsRelativesCrowd.family1);
        addressService.save(UtilsRelativesCrowd.family2);
        addressService.save(UtilsRelativesCrowd.family3);
        addressService.save(UtilsRelativesCrowd.family4);

        assertEquals(4, addressService.findAll().size());
    }

    @Test
    public void findById(){
        addressService.save(UtilsRelativesCrowd.family3);
        addressService.save(UtilsRelativesCrowd.family1);
        addressService.save(UtilsRelativesCrowd.family4);
        assertEquals(UtilsRelativesCrowd.family3, addressService.findById(UtilsRelativesCrowd.family3.getId()));
        assertNull(addressService.update(new Address(6L,"Коломяжский")));

    }

    @Test
    public void deleteByAddress(){
        addressService.save(UtilsRelativesCrowd.family3);
        addressService.save(UtilsRelativesCrowd.family1);
        addressService.save(UtilsRelativesCrowd.family4);

        assertEquals(3, addressService.findAll().size());
        addressService.delete(UtilsRelativesCrowd.family1);
        assertEquals(2, addressService.findAll().size());
        assertEquals(UtilsRelativesCrowd.family3, addressService.findById(UtilsRelativesCrowd.family3.getId()));
        assertEquals(UtilsRelativesCrowd.family4, addressService.findById(UtilsRelativesCrowd.family4.getId()));
    }

    @Test
    public void update(){
        addressService.save(UtilsRelativesCrowd.family4);
        assertEquals("Токсово, Привокзальная",addressService.findById(4L).getAddress());

        Address old = addressService.update(new Address(4L,"New-York, Manhattan"));
        assertEquals("Токсово, Привокзальная",old.getAddress());

        assertEquals(1, addressService.findAll().size());
        assertEquals("New-York, Manhattan",addressService.findById(4L).getAddress());
        assertNull(addressService.update(new Address(6L,"Коломяжский")));
    }



}