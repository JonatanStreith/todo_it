package jonst.data;

import jonst.model.Person;
import jonst.model.Todo;

import java.util.Arrays;

public class TodoItems {

    private static Todo[] todoArray = new Todo[0];


    public int size() {

        return todoArray.length;
    }


    public Todo[] findAll() {

        return todoArray;
    }

    public Todo findById(int todoId) {


        for (Todo todd : todoArray) {
            if (todd.getTodoId() == todoId)
                return todd;
        }
        return null;        //If it can't find that Id, return a null object. A method that invokes findById() must be prepared to get a null object and respond properly.
                            //After all, it needs to return SOMETHING.
    }

    public Todo AddTodo(String description) {

        Todo newTodo = new Todo(TodoSequencer.nextTodoId(), description);    //Creates a new todo, using the nextTodoId to get a fresh number


        todoArray = Arrays.copyOf(todoArray, todoArray.length + 1);   //Increase the array size by one


        todoArray[todoArray.length - 1] = newTodo;   //Puts the new task last in the array

        return newTodo;
    }


    public void clear() {

        todoArray = new Todo[0];
        TodoSequencer.reset();        //We need to reset the Id counter if we clear the array, right?

    }


    public Todo[] findByDoneStatus(boolean doneStatus) {

        Todo[] chosenTodos = new Todo[0];       //Make a blank array

        for (Todo todd : todoArray) {

            if (todd.isDone() == doneStatus) {

                chosenTodos = Arrays.copyOf(chosenTodos, chosenTodos.length + 1);   //Increase the array size by one

                chosenTodos[chosenTodos.length - 1] = todd;
            }
        }

        return chosenTodos;
    }


    public Todo[] findByAssignee(int personId) {

        Todo[] chosenTodos = new Todo[0];       //Make a blank array

        for (Todo todd : todoArray) {

            if (todd.getAssignee().getPersonId() == personId) {

                chosenTodos = Arrays.copyOf(chosenTodos, chosenTodos.length + 1);   //Increase the array size by one

                chosenTodos[chosenTodos.length - 1] = todd;
            }
        }

        return chosenTodos;
    }


    public Todo[] findByAssignee(Person assignee) {

        Todo[] chosenTodos = new Todo[0];       //Make a blank array

        for (Todo todd : todoArray) {

            if (todd.getAssignee() == assignee) {

                chosenTodos = Arrays.copyOf(chosenTodos, chosenTodos.length + 1);   //Increase the array size by one

                chosenTodos[chosenTodos.length - 1] = todd;
            }
        }

        return chosenTodos;
    }

    public Todo[] findUnassigned() {

        Todo[] chosenTodos = new Todo[0];       //Make a blank array

        for (Todo todd : todoArray) {

            if (todd.getAssignee() == null) {

                chosenTodos = Arrays.copyOf(chosenTodos, chosenTodos.length + 1);   //Increase the array size by one

                chosenTodos[chosenTodos.length - 1] = todd;
            }
        }

        return chosenTodos;
    }


    public void RemoveItem(int removedId) {

        Todo[] editedArray = new Todo[todoArray.length - 1];  //Get a fresh array to put stuff into; make it one space shorter
        int currentSpot = 0;                                  //Count which spot we're on right now.

        for (Todo todd : todoArray) {

            if (todd.getTodoId() != removedId) {
                editedArray[currentSpot] = todd;        //If an entry isn't the one we want to remove, save it to the new set.
                currentSpot++;                          //Then increase the counter so it'll know to use a fresh spot for the next iteration.
            }                                           //If an entry *is* the one we want to remove, it'll just skip over that.

            todoArray = editedArray;    //COpy the results into the main array

        }


    }


}
