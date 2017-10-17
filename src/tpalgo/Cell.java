package tpalgo;

public class Cell<Type> 
{
	
	private Type mData;
	private Cell<Type> mNext;
	
	public Cell(Type data, Cell<Type> next)
	{
		mData = data;
		mNext = next;
	}
	
	public Type getData()
	{
		return mData;
	}
	
	public Cell<Type> getNext()
	{
		return mNext;
	}
	
	public void setNext(Cell<Type> next)
	{
		mNext = next;
	}
	
	
	@Override
	public String toString() 
	{
		return mData.toString();
	}
}