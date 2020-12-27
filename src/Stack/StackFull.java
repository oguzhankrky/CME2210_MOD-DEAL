package Stack;
public class StackFull extends Exception 
{
	public StackFull()
	{
		super();
		System.err.println("Stack is full");
	}

}
