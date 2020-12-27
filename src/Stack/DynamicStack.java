package Stack;
import java.util.ArrayList;
import java.util.List;

public class DynamicStack extends StackAbstract //implements IStack
{
	private List<Object> contents;
	
	public DynamicStack() 
	{
	     contents = new ArrayList<Object>(); 	
	}
	
	@Override
	public Object peek() throws StackEmpty 
	{
        if(isEmpty()) new StackEmpty();
		
		return contents.get(contents.size()-1);
	}

	@Override
	public Object pop() throws StackEmpty  
	{
        if(isEmpty()) new StackEmpty();
		
		Object retVal = contents.get(contents.size()-1);
		contents.remove(contents.size()-1);
		
		return retVal;
	}

	@Override
	public void push(Object data) 
	{
		contents.add(data);
	}

	@Override
	public boolean isEmpty() 
	{
		return contents.size() == 0;
	}

}
