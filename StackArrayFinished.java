/******************************************************************************
NAME: Aldrie U. Abais
DESCRIPTION: Stack
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
    
    public int getSize()
    {
        return items.length;
    }
    
    public int getRemainingSlots()
    {
        return items.length - count;
    }


	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
		
		boolean Anchor1 = false;
        boolean checker = false;
        int choice = 0;
		while(!Anchor1){
		    do{
    	        try{
		    System.out.println("\n====================\n");
		    System.out.println("====MyStackArray====\n");
    		System.out.println(" Menu:\n");
    		System.out.println("1.Create\n");
    		System.out.println("2.Exit\n");
		    
    	            checker = false;
    	            System.out.print("Choose(1-2): ");
    		        choice = in.nextInt();
    	        }catch(Exception e){
            		checker = true;   	
        		    System.out.println("Enter 1-2 only!");
            		in.next();
    	        }
    	    }while(checker);
		    
    		
    		if(choice == 1)
    		{
    		    Create(in);
    		}
    		else if(choice == 2){
    		    Anchor1 = true;
    		}else{
    		    System.out.println("Enter 1-2 only!");
    		}
		};
	}
	
	public static void Create(Scanner in){
	    
	    boolean checker = false;
	    int stackSize = 0;
	    
	    do{
	        try{
	            checker = false;
                System.out.println("\nEnter the size of the stack(5-50): ");
        	    stackSize = in.nextInt();
	        }catch(Exception e){
        		checker = true;   	
    		    System.out.println("You can only input integers.");
        		in.next();
	        }
	    }while(checker);
	    
	    
	    
	    StackArray SA = new StackArray(stackSize);
	    boolean Anchor2 = false;
    	    while(!Anchor2){
    	        
    	        boolean checker2 = false;
	    
                String[] Options = {
                	        "1.Push",
                	        "2.Peek",
                	        "3.Pop",
                	        "4.Display",
                	        "5.Go Back"
                	    };
                	                    	    
                	    int choice = 0;
	    
        	    do{
        	        try{
        	            checker = false;
                	    System.out.println("\n\nSub Menu:");
                	    for(int i = 0; i < 5; i = i + 1){
                	        System.out.println(Options[i]);
                	    }
                		
                		System.out.print("\n\nChoose(1-5): ");
                		choice = in.nextInt();
                		in.nextLine();
        	        }catch(Exception e){
                		checker2 = true;   	
            		    System.out.println("Enter 1-5 only!");
                		in.next();
        	        }
        	    }while(checker2);
    	        
        	    
            		switch(choice){
            		    case 1:
            		        System.out.println("How many do u want to add?: ");
            		        int toAdd = in.nextInt();
            		        in.nextLine();
            		        
            		        for(int i = 0; i < toAdd; i++)
            		        {
            		            if(SA.getRemainingSlots() != 0){
                		            System.out.println("Enter an object to add: ");
                		            String toBeAdded = in.nextLine();
                		        
                    		        boolean tOrF;
                    		        tOrF = SA.push(toBeAdded);
                		            if(tOrF)
                		            {
                		                System.out.println("Successfully added!.");
        		                	    System.out.println("Available space: " + SA.getRemainingSlots());
        		                	    System.out.println("----------------\n\n");
                		            }
            		            }else
            		            {
            		                System.out.println("Cannot add anymore! (Already Full).");
            		                break;
            		            }
            		        }
            		        
            		        
            		    break;
            		    
            		    case 2:
            		        
            		        if(SA.peek() != null){
            		        String peekaboo = SA.peek().toString();
            		        System.out.println(""+peekaboo);
            		        }else{
            		            System.out.println("The stack is empty.");
            		        }
            		    break;
            		    
            		    case 3:
            		        boolean tOrF2 = SA.pop();
                                if(tOrF2)
            		            {
            		                System.out.println("Success.");
            		            }else
            		            {
            		                System.out.println("Failed.(The stack is empty)");
            		            }
            		    break;
            		    case 4:
            		        if(SA.isEmpty()){
            		            System.out.println("The stack is empty.");
            		        }else{
            		        System.out.println(SA);
            		        }
            		    break;
            		    
            		    case 5:
            		        Anchor2 = true;
            		    break;
            		}
    	    }
    	    return;
	}
}
