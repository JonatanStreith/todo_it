package jonst.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class PersonSequencerTest {

    @Test
    public void nextPersonIdTest() {

        int first = PersonSequencer.nextPersonId();     //First should be 1
        int second = PersonSequencer.nextPersonId();    //Second should be 2
        int third = PersonSequencer.nextPersonId();     //Third should be 3

        assertTrue(first == 1);
        assertTrue(second == 2);
        assertTrue(third == 3);

    }


    @Test
    public void resetTest() {

        PersonSequencer.reset();

        int expectedToBeOne = PersonSequencer.nextPersonId();   //We don't have a getter, but this will do well enough. Should return 1, assuming it tested right earlier.

        assertEquals(1, expectedToBeOne);

    }
}
