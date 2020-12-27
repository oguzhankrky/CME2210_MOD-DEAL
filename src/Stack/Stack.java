package Stack;
import java.util.Vector;

public class Stack extends StackAbstract //implements IStack
{
	private Vector contents;
	
	public Stack()
	{
		contents = new Vector();
	}

	@Override
	public Object peek() throws StackEmpty 
	{
		if(isEmpty()) new StackEmpty();
		
		return contents.elementAt(contents.size()-1);
	}

	@Override
	public Object pop() throws StackEmpty {

		if(isEmpty()) new StackEmpty();
		
		Object retVal = contents.elementAt(contents.size()-1);
		contents.removeElementAt(contents.size()-1);
		
		return retVal;
	}

	@Override
	public void push(Object data) 
	{
		contents.addElement(data);
	}

	@Override
	public boolean isEmpty() {
		
		return contents.size() == 0;
	}

}
