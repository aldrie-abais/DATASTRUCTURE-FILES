/******************************************************************************
NAME: Aldrie U. Abais
DESCRIPTION: 
DATA: 03/28/2025
*******************************************************************************/
import java.util.Scanner;

class StackArray
{
    private Object[] items;
    private int count;
    
    public StackArray(int size)
    {
        if(size > 50 || size < 5)
        {
            size = 10;
        }
            items = new Object[size];
            count =0;
    }
    
    public boolean isFull()
    {
        return count == items.length;
    }
    
    public boolean isEmpty(){
        return count == 0;
    }
    
    public boolean push(Object value)
    {
        if(!isFull())
        {
            items[count] = value;
            count = count + 1;
            return true;
        }
        return false;
    }
    
    public Object peek()
    {
        if(!isEmpty())
        {
            return items[count-1];
        }
        return null;
    }
    
    public boolean pop()
    {
        if(!isEmpty())
        {
            items[count-1] = null;
            count = count - 1;
            return true;
        }
        return false;
    }
    
    public String toString()
    {
        String result = "";
        for(int i = count-1; i>=0; i = i - 1)
        {
            result = result + "[" + items[i] + "]\n";
        }
        return result;
    }


	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    StackArray SA = new StackArray(10);
		
		System.out.println("MyStackArray\n");
		System.out.println("Menu:\n");
		System.out.println("1.Create\n");
		System.out.println("2.Exit\n");
		boolean Anchor2 = false;
		do{
    		System.out.print("Choose: ");
    		int choice = in.nextInt();
    		
    		if(choice == 1)
    		{
    		    Create(SA, in);
    		}
    		else{
    		    Anchor2 = true;
    		}
		}while(!Anchor2);
	}
	
	public static void Create(StackArray SA, Scanner in){
	    
	    boolean Anchor2 = false;
	   // System.out.print("Enter the Size of the stack: ");
	   // int Size = in.nextInt();
	   // in.nextLine();
	    
	   // SA = new StackArray(Size);
    	    do{
        	    String[] Options = {
        	        "1.Push",
        	        "2.Peek",
        	        "3.Pop",
        	        "4.Display",
        	        "5.Go Back"
        	    };
        	    
        	    for(int i = 0; i < 5; i = i + 1){
        	        System.out.println(Options[i]);
        	    }
        	    
        	    int choice;
        		
        		System.out.print("\n\nChoose: ");
        		choice = in.nextInt();
        		in.nextLine();
        		
        		switch(choice){
        		    case 1:
        		        System.out.println("Enter an object to add: ");
        		        String toBeAdded = in.nextLine();
        		        
        		        boolean tOrF;
        		        tOrF = SA.push(toBeAdded);
        		            if(tOrF)
        		            {
        		                System.out.println("Success.");
        		            }else
        		            {
        		                System.out.println("Failed.");
        		            }
        		    break;
        		    
        		    case 2:
        		        String string = SA.peek().toString();
        		        System.out.println(""+string);
        		    break;
        		    
        		    case 3:
        		        boolean tOrF2 = SA.pop();
                            if(tOrF2)
        		            {
        		                System.out.println("Success.");
        		            }else
        		            {
        		                System.out.println("Failed.");
        		            }
        		    break;
        		    case 4:
        		        System.out.println(SA);
        		    break;
        		    
        		    case 5:
        		        Anchor2 = true;
        		    break;
        		}
    	    }while(!Anchor2);
	    return;
	}
}



















