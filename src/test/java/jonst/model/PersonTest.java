package jonst.model;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Person
 */
public class PersonTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void Person() {

        int personId = 555;
        String firstName = "Alex";
        String lastName = "Hawkwind";

        Person testCase = new Person(personId, firstName, lastName);

    }
}
