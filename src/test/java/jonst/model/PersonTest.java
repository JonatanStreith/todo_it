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

        Person testCase = new Person(personId, firstName, lastName);

        assertNotNull(testCase);

        assertEquals(555, testCase.getPersonId());
        assertEquals("Alex", testCase.getFirstName());
        assertEquals("Hawkwind", testCase.getLastName());

    }
}
