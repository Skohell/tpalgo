package tpalgo;

public class CircularList<Type> 
{
	
	private Cell<Type> list;
	
	public CircularList()
	{
		list = null;
	}
	
	@Override
	public String toString()
	{
		String msg = new String("");
		Cell<Type> cur = list;
		
		if(list==null)
			return new String("Empty list.");
		do
		{
			msg +=" "+cur.toString();
			cur = cur.getNext();
		} while(cur != list);
		
		
		return msg;
		
	}
	
	public void pushFront(Type data)
	{
		Cell<Type> c = new Cell<Type>(data,list);
		
		if(list == null)
			c.setNext(c);
		
		Cell<Type> last = getLastCell();
		if(last != null)
			last.setNext(c);
		
		list = c;
	}
	
	public void pushBack(Type data)
	{
		Cell<Type> c = new Cell<Type>(data,list);
		
		if(list==null)
			c.setNext(c);
		
		Cell<Type> last = getLastCell();
		if(last != null)
			last.setNext(c);
		
	}
	
	public Boolean containsData(Type data)
	{
		Cell <Type> cell = list;
		
		do
		{
			if(cell.getData() == data)
				return true;
			cell = cell.getNext();
		} while(cell != list);
		
		return false;
	}

	public Cell<Type> popFront()
	{
		if(list == null)
			return null;
		
		Cell<Type> front = new Cell<Type>(list.getData(),list.getNext());
		
		getLastCell().setNext(list.getNext());
		
		list = list.getNext();
		

		return front;
	}
	
	public Cell<Type> popBack()
	{
		Cell<Type> back;
		
		if(list == null)
			return null;
		
		if(list.getNext() == null)
		{
			back = new Cell<Type>(list.getData(),list.getNext());
			list = null;
			return back;			
		}
			
		Cell<Type> cur = list;
		
		while(cur.getNext().getNext() != list)
			cur = cur.getNext();
		
		back = new Cell<Type>(cur.getNext().getData(),list);
		cur.setNext(list);
		
		return back;
			
	}
	
	public Cell<Type> popData(Type data)
	{
		Cell<Type> prev;
		
		if(list == null)
			return null;
		
		if(list.getData().equals(data))
		{
			prev = new Cell<Type>(list.getData(),list.getNext());
			list = null;
			return prev;			
		}
			
		Cell<Type> cur = list;
		
		while(!cur.getNext().getData().equals(data))
			cur = cur.getNext();
		
		prev = new Cell<Type>(cur.getNext().getData(),cur.getNext().getNext());
		cur.setNext(cur.getNext().getNext());
		
		return prev;
	}
	
	public Cell<Type> getLastCell()
	{
		Cell<Type> cell = list;
		
		if(cell == null)
			return null;
		
		while(cell.getNext()!=list)
			cell = cell.getNext();
		
		return cell;
	}
} 