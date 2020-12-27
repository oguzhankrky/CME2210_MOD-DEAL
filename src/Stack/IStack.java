package Stack;
public interface IStack 
{
	public Object peek() throws StackEmpty;
	public Object pop() throws StackEmpty;
	public void push(Object data);
	public boolean isEmpty();
}
