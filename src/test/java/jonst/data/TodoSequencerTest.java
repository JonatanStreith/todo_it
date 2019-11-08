package jonst.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TodoSequencerTest {

    @Test
    public void nextPersonIdTest() {

        int first = TodoSequencer.nextTodoId();     //First should be 1
        int second = TodoSequencer.nextTodoId();    //Second should be 2
        int third = TodoSequencer.nextTodoId();     //Third should be 3

        assertTrue(first == 1);
        assertTrue(second == 2);
        assertTrue(third == 3);

    }


    @Test
    public void resetTest() {

        TodoSequencer.reset();

        int expectedToBeOne = TodoSequencer.nextTodoId();   //We don't have a getter, but this will do well enough. Should return 1, assuming it tested right earlier.

        assertEquals(1, expectedToBeOne);

    }
}
