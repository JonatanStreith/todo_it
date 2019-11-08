package jonst.data;


import jonst.model.Person;
import jonst.model.Todo;
import org.junit.Test;

import static org.junit.Assert.*;

public class TodoItemsTest {


    @Test
    public void addTodoTest() {
        TodoItems listA = new TodoItems();

        String description = "Feed the dog.";

        Todo result = listA.AddTodo(description);

        assertNotNull(result);

        assertEquals(1, result.getTodoId());
        assertEquals("Feed the dog.", result.getDescription());

        assertEquals("Feed the dog.", listA.findAll()[0].getDescription());  //Can test that data has been added to the actual array, too

    }

    @Test
    public void sizeTest() {
        TodoItems listA = new TodoItems();



        assertEquals(0, listA.size());


        String description = "Feed the dog.";

        Todo result = listA.AddTodo(description);

        assertEquals(1, listA.size());         //We've created one entry, so we assume one is the right size

    }

    @Test
    public void findAllTest() {
        TodoItems listA = new TodoItems();



        String description = "Feed the dog.";

        Todo result = listA.AddTodo(description);

        Todo[] test = listA.findAll();



        assertNotNull(test);
        assertEquals(1, test[0].getTodoId());
        assertEquals("Feed the dog.", test[0].getDescription());



    }

    @Test
    public void findByIdTest() {
        TodoItems listA = new TodoItems();

        String description = "Feed the dog.";

        Todo result = listA.AddTodo(description);

        Todo test = listA.findById(1);

        assertNotNull(test);
        assertEquals(1, test.getTodoId());
        assertEquals("Feed the dog.", test.getDescription());


    }

    @Test
    public void clearTest() {
        TodoItems listA = new TodoItems();


        String description = "Feed the dog.";

        Todo result = listA.AddTodo(description);


        listA.clear();

        Todo[] test = listA.findAll();       //Get the now empty array

        assertTrue(test.length == 0);   //See if that array is zero length

    }

}
