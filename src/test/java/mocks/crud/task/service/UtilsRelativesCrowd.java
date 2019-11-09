package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;

public class UtilsRelativesCrowd {
    public static Address family1 = new Address(1L,"Питер, Науки");
    public static Address family2 = new Address(2L,"Питер, Восстания");
    public static Address family3 = new Address(3L,"Питер, Гражданский");
    public static Address family4 = new Address(4L,"Токсово, Привокзальная");

    public static Person sonBoris = new Person("Борис",19, family1);
    public static Person sonMax = new Person("Максим",17, family1);
    public static Person daughterIren = new Person("Ирина",15, family1);

    public static Person motherElena = new Person("Елена",37, family1);
    public static Person fatherVladimir = new Person("Владимир",39, family1);

    public static Person grandFatherPetr = new Person("Пётр",60, family2);
    public static Person grandMotherVera = new Person("Вера",58, family2);

    public static Person someNeighborVasia = new Person("Василия",45, family3);


}
