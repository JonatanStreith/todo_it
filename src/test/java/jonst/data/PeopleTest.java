package jonst.data;

import jonst.model.Person;
import jonst.model.Todo;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PeopleTest {

    //Note: Methods don't test well when testing the whole class because they affect the same data. Test methods separately.

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


    @Test
    public void removePersonTest() {

        People listA = new People();

        int idToRemove = 2;

        Person result1 = listA.AddPerson("Esther", "Bright");
        Person result2 = listA.AddPerson("Asra", "Nox");
        Person result3 = listA.AddPerson("Big", "Ape");
        Person result4 = listA.AddPerson("Dread", "Wing");





        int lengthBefore = listA.findAll().length;  //Get length before we delete something.

        listA.RemovePerson(idToRemove);

        int lengthAfter = listA.findAll().length;  //Get length after







        assertTrue(lengthBefore == lengthAfter + 1);    //We've deleted one item, so the array should be one shorter
        assertNull(listA.findById(idToRemove));                 //If an item id is invalid, findById() returns a null object. Ergo, if we've deleted it, we should get a null.

    }


}
