/******************************************************************************
NAME: Aldrie U. Abais
DESCRIPTION: StackNode
DATA: 03/28/2025
*******************************************************************************/
import java.util.Scanner;
import javax.swing.*;

class StackNode
{
    MyNode top;
    
    public StackNode()
    {
        top = null;
    }
    
    public boolean isFull()
    {
        return false;
    }
    
    public boolean isEmpty()
    {
        return top == null;
    }
    
    public boolean push(Object i)
    {
        MyNode newNode = new MyNode(i);
        if(isEmpty())
        {
            top = newNode;
        }else{
            MyNode tempTop = top;
            while(tempTop.next != null)
            {
                tempTop = tempTop.next;
            }
            tempTop.next = newNode;
        }
        System.out.println("Test1");
        return true;
    }
    
    public Object peek()
    {
        if(!isEmpty())
        {
            MyNode tempTop = top;
            while(tempTop.next != null)
            {
                tempTop = tempTop.next;
            }
            return tempTop.item.toString();
        }
        return null;
    }
    
    public Object pop()
    {
        Object toBeReturned;
        if(!isEmpty())
        {
            MyNode tempTop = top;
            MyNode previousTop = null;
            if(top.next == null){
                toBeReturned = top.item;
                top = null;
            }else{

            while(tempTop.next != null)
            {
                previousTop = tempTop;
                tempTop = tempTop.next;
            }
            toBeReturned = previousTop.next.item;
            previousTop.next = null;
            }
            
            return toBeReturned;
        }
        return false;
    }
    
    public String toString()
    {
      String result = "";
      if(!isEmpty())
      {
        MyNode tempTop = top;
        
        
        while(tempTop.next != null){
            tempTop = tempTop.next;
        }
        result += "[" + tempTop.item + "]\n";
        
        while(tempTop != top){   
            MyNode tempTop2 = top;
            while(tempTop2.next != tempTop){
                tempTop2 = tempTop2.next;
            }
            tempTop = tempTop2;
            result += "[" + tempTop.item + "]\n";
        }
      }
      return result;
    }

	public static void main(String[] args) {
	    StackNode SN = new StackNode();
	    Scanner in = new Scanner(System.in);
		
		boolean Anchor1 = false;
        boolean checker = false;
        int choice = 0;
		while(!Anchor1){
		    do{
    	        try{
		    System.out.println("\n====================\n");
		    System.out.println("====Infix to Postfix Converter====\n");
    		System.out.println(" Menu:\n");
    		System.out.println("1.Input Infix Expression: \n");
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
                Main main = new Main();
                String infixExpression = JOptionPane.showInputDialog("Enter content: ");
    		    String result = main.convertToPostfix(infixExpression);
                JOptionPane.showMessageDialog(null, "The Postfix of the given Infix Expression is: "+result, "Dequeue result.", JOptionPane.PLAIN_MESSAGE);
                // System.out.println("The Postfix of the given Infix Expression is: "+result);
    		}
    		else if(choice == 2){
    		    Anchor1 = true;
    		}else{
    		    System.out.println("Enter 1-2 only!");
    		}
		};
	}
	
	// public static void Create(Scanner in){
	    
	//     boolean checker = false;
	    
	//     StackNode SN = new StackNode();
	//     boolean Anchor2 = false;
    // 	    while(!Anchor2){
    	        
    // 	        boolean checker2 = false;
	    
    //             String[] Options = {
    //             	        "1.Push",
    //             	        "2.Peek",
    //             	        "3.Pop",
    //             	        "4.Display",
    //             	        "5.Go Back"
    //             	    };
                	                    	    
    //         	    int choice = 0;
    //                 checker2 = false;
    //         	    do{
    //         	        try{
    //         	            checker2 = false;
    //                 	    System.out.println("\n\nSub Menu:");
    //                 	    for(int i = 0; i < 5; i = i + 1){
    //                 	        System.out.println(Options[i]);
    //                 	    }
                    		
    //                 		System.out.print("\n\nChoose(1-5): ");
    //                 		choice = in.nextInt();
    //                 // 		in.nextLine();
    //         	        }catch(Exception e){
    //                 		checker2 = true;   	
    //             		    System.out.println("Enter 1-5 only!");
    //                 		in.next();
    //         	        }
    //         	    }while(checker2);
    	        
        	    
    //         		switch(choice){
    //         		    case 1:
            		        
    //         		        boolean checker22 = false;
    //         		        int toAdd = 0;
	    
    //                         do{
    //                             try{
    //                                 checker22 = false;
    //                                 System.out.println("How many do u want to add?: ");
    //                 		        toAdd = in.nextInt();
    //                 		        in.nextLine();
    //                             }catch(Exception e){
    //                         		checker22 = true;   	
    //                     		    System.out.println("You can only input integers.");
    //                         		in.next();
    //                             }
    //                         }while(checker22);
            		        
            		        
            		        
    //         		        for(int i = 0; i < toAdd; i++)
    //         		        {
    //         		            boolean checker3 = false;
    //         		            boolean checker222 = false;
	//                             String toBeAdded = "";
                        	            
    //                     	            do{
    //                         	            checker3 = false;
    //                         	            checker222 = false;
    //                         	            System.out.println("Enter an object to add: ");
    //                 		                toBeAdded = in.nextLine();
    //                 		                if(toBeAdded == ""){
    //                 		                    System.out.println("Need to add a proper input.\n");
    //                 		                }
    //                 		                else{
    //                     		                checker3 = true;
    //                 		                }
    //             		                }while(!checker3);
            		            
                		            
                		        
    //                 		        boolean tOrF;
    //                 		        tOrF = SN.push(toBeAdded);
    //             		            if(tOrF)
    //             		            {
    //             		                System.out.println("Successfully added!.");
    //     		                	    System.out.println("----------------\n\n");
    //             		            }
    //         		        }
            		        
            		        
    //         		    break;
            		    
    //         		    case 2:
            		        
    //         		        if(SN.peek() != null){
    //         		        String peekaboo = SN.peek().toString();
    //         		        System.out.println(""+peekaboo);
    //         		        }else{
    //         		            System.out.println("The stack is empty.");
    //         		        }
    //         		    break;
            		    
    //         		    case 3:
    //         		        boolean tOrF2 = SN.pop();
    //                             if(tOrF2)
    //         		            {
    //         		                System.out.println("Success.");
    //         		            }else
    //         		            {
    //         		                System.out.println("Failed.(The stack is empty)");
    //         		            }
    //         		    break;
    //         		    case 4:
    //         		        if(SN.isEmpty()){
    //         		            System.out.println("The stack is empty.");
    //         		        }else{
    //         		        System.out.println(SN);
    //         		        }
    //         		    break;
            		    
    //         		    case 5:
    //         		        Anchor2 = true;
    //         		    break;
    //         		}
    // 	    }
    // 	    return;
	// }
}
