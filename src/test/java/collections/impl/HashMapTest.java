package collections.impl;

import collections.Map;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    //Класс для проверки логики работы односвязного списка в корзинах
    class Testo {
        private String name;
        public String getName() {
            return name;
        }
        public Testo(String name) {
            this.name = name;
        }
        @Override
        public int hashCode() {
            return 47;
        }
        @Override
        public boolean equals(Object obj) {
            return name.equals(((Testo) obj).getName());
        }
        @Override
        public String toString() {
            return "Testo{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private Map<Testo, String> map;
    private Testo testo = new Testo("Vasya");
    private Testo testo1 = new Testo("Vasya1");
    private Testo testo2 = new Testo("Vasya2");

    @Before
    public void setUp() throws Exception {
        map = new HashMap<>();
        map.insert(testo, "one");
        map.insert(testo1, "two");
        map.insert(testo2, "three");
    }

    @Test
    public void insert() {
        Testo piter = new Testo("Petya");

        map.insert(piter, "example");
        assertEquals("example", map.get(piter));

    }

    @Test
    public void get() {
        assertEquals("two", map.get(testo1));
        assertNull(map.get(new Testo("Petya")));
    }

    @Test
    public void delete() {
        assertTrue(map.delete(testo));
        assertNull(map.get(testo));


    }
}