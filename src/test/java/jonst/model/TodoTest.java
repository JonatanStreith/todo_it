package jonst.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;


public class TodoTest {

    @Test
    public void TodoTest() {

        int todoId = 34;
        String description = "Reverse the polarity of the neutron flow.";
        boolean done = false;
        Person assignee = new Person(555, "Alex", "Hawkwind");      //Create an assignee to play with


        Todo test = new Todo(todoId, description);  //test if we can make a Todo object

        assertNotNull(test);    //make sure we created it successfully
        assertEquals(34, test.getTodoId());    //Make sure it has the right id
        assertEquals("Reverse the polarity of the neutron flow.", test.getDescription());   //Make sure it has the right descr.
        assertTrue(test.getAssignee()== null);  //Check to see that no assignee exists initially
        assertFalse(test.isDone());     //Check to see that it's not flagged as done initially

        test.setAssignee(assignee);     //Test if we can assign an assignee. As this is somewhat complex, it could mess up.
        test.setDone(true);             //Test if we can change

        assertNotNull(test.getAssignee());      //Check if assignee added properly, and is right one
        assertEquals(555, test.getAssignee().getPersonId());
        assertTrue(test.isDone());  //Check to see if setDone() worked properly.

    }
}
