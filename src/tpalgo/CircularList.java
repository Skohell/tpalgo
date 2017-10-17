package tpalgo;

public class CircularList<Type> 
{

    private class Cell<Type> 
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
	
	private void setNext(Cell<Type> next)
	{
		mNext = next;
	}
	
	
	@Override
	public String toString() 
	{
		return mData.toString();
	}
}
	
	private Cell<Type> list;
	
	public CircularList()
	{
		list = null;
	}
	
	@Override
	public String toString()
	{
		String msg = "";
		Cell<Type> cur = list;
		
		if(list==null)
			return "Empty list.";
		do
		{
			msg +=" "+cur.toString();
			cur = cur.getNext();
		} while(cur != list);
		
		
		return msg;
		
	}
	
	public void pushFront(Type data)
	{
		Cell<Type> c = new Cell<>(data,list);
		
		if(list == null)
			c.setNext(c);
		
		Cell<Type> last = getLastCell();
		if(last != null)
                    last.setNext(c);
		
		list = c;
	}
	
	public void pushBack(Type data)
	{
		Cell<Type> c = new Cell<>(data,list);
		
		if(list==null)
                {
                    c.setNext(c);
                    list = c;
                }
		Cell<Type> last = getLastCell();
		if(last != null)
                    last.setNext(c);
		
                c.setNext(list);
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

	public Type popFront()
	{
		if(list == null)
			return null;
		
		Type front = list.getData();
		
		getLastCell().setNext(list.getNext());
		
		list = list.getNext();
		

		return front;
	}
	
	public Type popBack()
	{
		Type back;
		
		if(list == null)
			return null;
		
		if(list.getNext() == null)
		{
			back = list.getData();
			list = null;
			return back;			
		}
			
		Cell<Type> cur = list;
		
		while(cur.getNext().getNext() != list)
			cur = cur.getNext();
		
		back = cur.getNext().getData();
		cur.setNext(list);
		
		return back;
			
	}
	
	public Type popData(Type data)
	{
		Type prev;
		
		if(list == null)
			return null;
		
		if(list.getData().equals(data))
		{
			prev = list.getData();
			list = null;
			return prev;			
		}
			
		Cell<Type> cur = list;
		
		while(!cur.getNext().getData().equals(data))
			cur = cur.getNext();
		
		prev = cur.getNext().getData();
		cur.setNext(cur.getNext().getNext());
		
		return prev;
	}
	
	private Cell<Type> getLastCell()
	{
		Cell<Type> cell = list;
		
		if(cell == null)
			return null;
		
		while(cell.getNext()!=list)
			cell = cell.getNext();
		
		return cell;
	}
        
        public Type elect(int step)
        {
            if(list == null)
                return null;
            
            while(list.getNext() != list)
            {
                for(int i = 0; i < step-1; i++)
                {
                    list = list.getNext();
                }
                
                System.out.println(popFront() + " is eliminated...\n");
                
            }
            
            System.out.println(list.getData().toString() + " is elected !\n");
            return list.getData();
        }
        
} 