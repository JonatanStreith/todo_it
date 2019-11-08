package jonst.data;

public class TodoSequencer {

    private static int todoId;

    public static int nextTodoId(){
        todoId++;

        return todoId;                  //Yes, I *could* just write "return ++todoId;" and have it done with one line.
                                        //But this is better for comprehension.

    }

    public static void reset(){
        todoId = 0;
    }

}
