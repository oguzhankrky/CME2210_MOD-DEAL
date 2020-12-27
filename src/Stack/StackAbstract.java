package Stack;
public abstract class StackAbstract 
{
	public abstract Object peek() throws StackEmpty;
	public abstract Object pop() throws StackEmpty;
	public abstract void push(Object data);
	public abstract boolean isEmpty();
	
	public double evalPostfix(String expression) throws StackEmpty
	{
		String[] exp = expression.split(" ");
		
		for(int i=0;i<exp.length;i++)
		{
			String str = exp[i];
			
			if(str.matches("(-?[0-9]+.?[0-9]*){1,20}"))
			{
				this.push(str);
			}
			else
			{
				
				double num1 = Double.parseDouble(this.pop().toString());
				double num2 = Double.parseDouble(this.pop().toString());
				
				if(str.equals("+"))
				{
					this.push(num2 + num1);
				}
				else if(str.equals("-"))
				{
					this.push(num2 - num1);
				}
				else if(str.equals("*"))
				{
					this.push(num2 * num1);
				}
				else if(str.equals("/"))
				{
					this.push(num2 / num1);
				}
			}
		}
		
		return Double.parseDouble(this.pop().toString());
	}
	
}
