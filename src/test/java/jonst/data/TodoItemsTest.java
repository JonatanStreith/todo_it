package jonst.data;


import jonst.model.Person;
import jonst.model.Todo;
import org.junit.Test;

import static org.junit.Assert.*;

public class TodoItemsTest {

        //Note: Methods don't test well when testing the whole class because they affect the same data. Test methods separately.

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

    @Test
    public void findByDoneStatusTest() {

        TodoItems listA = new TodoItems();

        //Let's say we've fed the dog but haven't watered the plants.

        String description = "Feed the dog.";
        Todo feedDog = listA.AddTodo(description);
        feedDog.setDone(true);

        description = "Water the plants.";
        Todo waterPlants = listA.AddTodo(description);


        Todo[] doneTasks = listA.findByDoneStatus(true);
        Todo[] undoneTasks = listA.findByDoneStatus(false);

        assertEquals(feedDog, doneTasks[0]);
        assertEquals(waterPlants, undoneTasks[0]);
    }

    @Test
    public void findByAssigneeIdTest() {
        TodoItems listA = new TodoItems();

        Person dogworker = new Person(1, "Esther", "Bright");
        Person plantworker = new Person(2, "Asra", "Nox");


        //Esther feeds the dog while Asra waters the plants.

        String description = "Feed the dog.";
        Todo feedDog = listA.AddTodo(description);
        feedDog.setAssignee(dogworker);

        description = "Water the plants.";
        Todo waterPlants = listA.AddTodo(description);
        waterPlants.setAssignee(plantworker);

        Todo[] dogTasks = listA.findByAssignee(dogworker);
        Todo[] plantTasks = listA.findByAssignee(plantworker);

        assertEquals(feedDog, dogTasks[0]);
        assertEquals(waterPlants, plantTasks[0]);

    }

    @Test
    public void findByAssigneeTest() {
        TodoItems listA = new TodoItems();

        Person dogworker = new Person(1, "Esther", "Bright");
        Person plantworker = new Person(2, "Asra", "Nox");


        //Esther feeds the dog while Asra waters the plants.

        String description = "Feed the dog.";
        Todo feedDog = listA.AddTodo(description);
        feedDog.setAssignee(dogworker);

        description = "Water the plants.";
        Todo waterPlants = listA.AddTodo(description);
        waterPlants.setAssignee(plantworker);

        Todo[] dogTasks = listA.findByAssignee(1);
        Todo[] plantTasks = listA.findByAssignee(2);

        assertEquals(feedDog, dogTasks[0]);
        assertEquals(waterPlants, plantTasks[0]);

    }

    @Test
    public void findUnassignedTest() {
        TodoItems listA = new TodoItems();

        Person dogworker = new Person(1, "Esther", "Bright");
        Person plantworker = new Person(2, "Asra", "Nox");


        //Esther feeds the dog while Asra waters the plants.

        String description = "Feed the dog.";
        Todo feedDog = listA.AddTodo(description);
        feedDog.setAssignee(dogworker);

        description = "Water the plants.";
        Todo waterPlants = listA.AddTodo(description);
        //waterPlants.setAssignee(plantworker);     //Asra isn't assigned this time!

        Todo[] unassignedTasks = listA.findUnassigned();


        assertEquals(waterPlants, unassignedTasks[0]);


    }

    @Test
    public void removeItemTest() {

        TodoItems listA = new TodoItems();

        int idToRemove = 2;

        Todo result1 = listA.AddTodo("Feed the dog.");
        Todo result2 = listA.AddTodo("Water the plants.");
        Todo result3 = listA.AddTodo("Slay the goblin that keeps eating our children.");
        Todo result4 = listA.AddTodo("Pick up the mail.");





        int lengthBefore = listA.findAll().length;  //Get length before we delete something.

        listA.RemoveItem(idToRemove);

        int lengthAfter = listA.findAll().length;  //Get length after







        assertTrue(lengthBefore == lengthAfter + 1);    //We've deleted one item, so the array should be one shorter
        assertNull(listA.findById(idToRemove));                 //If an item id is invalid, findById() returns a null object. Ergo, if we've deleted it, we should get a null.

    }
}
