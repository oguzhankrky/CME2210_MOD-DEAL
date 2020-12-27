package Stack;
public class StackEmpty extends Exception 
{
       public StackEmpty()
       {
    	   super();
    	   System.err.println("Stack is Empty");
       }
}
