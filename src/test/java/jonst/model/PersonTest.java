package jonst.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for Person
 */
public class PersonTest
{


    @Test
    public void PersonTest() {

        int personId = 555;
        String firstName = "Alex";
        String lastName = "Hawkwind";

        Person testCase = new Person(personId, firstName, lastName);        //Test if we can create a person

        assertNotNull(testCase);        //Check to see if it was made at all

        assertEquals(555, testCase.getPersonId());          //Check to see if Id is right
        assertEquals("Alex", testCase.getFirstName());      //Check to see if firstName is right
        assertEquals("Hawkwind", testCase.getLastName());   //Check to see if lastName is right

    }
}
