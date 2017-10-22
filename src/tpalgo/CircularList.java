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
	
    private Cell<Type> first;
    private Cell<Type> last;

    public CircularList()
    {
        first = null;
        last = null;
    }

    @Override
    public String toString()
    {
        String msg = "";
        Cell<Type> cur = first;

        if(first==null)
                return "Empty list.";
        do
        {
            msg +=" "+cur.toString();
            cur = cur.getNext();
        } while(cur != first);


        return msg;

    }

    public void pushFront(Type data)
    {
        Cell<Type> c = new Cell<>(data,first);

        if(first == null)
        {
            c.setNext(c);
            last = c;
        } else {
            last.setNext(c);
        }

        first = c;
    }

    public void pushBack(Type data)
    {
        Cell<Type> c = new Cell<>(data,first);

        if(first==null)
        {
            c.setNext(c);
            first = c;
        } else {
            last.setNext(c);
            c.setNext(first);
        }
        last = c;
    }

    public Boolean containsData(Type data)
    {
        Cell <Type> cell = first;

        do
        {
            if(cell.getData().equals(data))
                    return true;
            cell = cell.getNext();
        } while(cell != first);

        return false;
    }

    public Type popFront()
    {
        if(first == null)
            return null;

        Type front = first.getData();

        last.setNext(first.getNext());

        first = first.getNext();


        return front;
    }

    public Type popBack()
    {
        Type back;

        if(first == null)
            return null;

        Cell<Type> cur = first;

        while(cur.getNext() != last)
            cur = cur.getNext();

        back = last.getData();
        cur.setNext(first);
        last = cur;

        return back;

    }

    public Type popData(Type data)
    {
        Type prev;

        if(first == null)
            return null;

        if(first.getData().equals(data))
        {
            prev = first.getData();
            first = first.getNext();
            last.setNext(first);
            return prev;			
        }

        Cell<Type> cur = first;

        while(!cur.getNext().getData().equals(data))
        {
            if(cur == last)
                return null;
            cur = cur.getNext();
        }

        prev = cur.getNext().getData();
        cur.setNext(cur.getNext().getNext());

        return prev;
    }

    public Type elect(int step, boolean output)
    {
        if(first == null)
            return null;

        int cpt = 0;
        
        
        while(first.getNext() != first)
        {
            for(int i = 0; i < step-1; i++)
            {
                first = first.getNext();
                last = last.getNext();
                cpt++;
            }

            Type val = popFront();

            if(output)
            {
                System.out.println(val.toString() + " is eliminated...");

            }

        }


        System.out.println(first.getData().toString() + " is elected ! (cpt="+cpt+")");
        return first.getData();
    }
        
} 