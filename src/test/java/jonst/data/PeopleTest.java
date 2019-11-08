package jonst.data;

import jonst.model.Person;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class PeopleTest {


    @Test
    public void addPersonTest() {
        People classA = new People();

        String firstName = "Esther", lastName = "Bright";

        Person result = classA.AddPerson(firstName, lastName);

        assertNotNull(result);


        assertEquals(1, result.getPersonId());
        assertEquals("Esther", result.getFirstName());
        assertEquals("Bright", result.getLastName());
        assertEquals("Bright", classA.findAll()[0].getLastName());  //Can test that data has been added to the actual array, too

    }

    @Test
    public void sizeTest() {
        People classA = new People();


        assertEquals(0, classA.size());


        String firstName = "Esther", lastName = "Bright";

        Person result = classA.AddPerson(firstName, lastName);

        assertEquals(1, classA.size());         //We've created one entry, so we assume one is the right size

    }

    @Test
    public void findAllTest() {
        People classA = new People();


        String firstName = "Esther", lastName = "Bright";

        Person result = classA.AddPerson(firstName, lastName);

        Person[] test = classA.findAll();



        assertNotNull(test);
        assertEquals(1, test[0].getPersonId());
        assertEquals("Esther", test[0].getFirstName());
        assertEquals("Bright", test[0].getLastName());


    }

    @Test
    public void findByIdTest() {
        People classA = new People();
        String firstName = "Esther", lastName = "Bright";

        Person result = classA.AddPerson(firstName, lastName);

        Person test = classA.findById(1);

        assertNotNull(test);
        assertEquals(1, test.getPersonId());
        assertEquals("Esther", test.getFirstName());
        assertEquals("Bright", test.getLastName());

    }

    @Test
    public void clearTest() {
        People classA = new People();

        String firstName = "Esther", lastName = "Bright";

        Person result = classA.AddPerson(firstName, lastName);


        classA.clear();

        Person[] test = classA.findAll();       //Get the now empty array

        assertTrue(test.length == 0);   //See if that array is zero length

    }

}
