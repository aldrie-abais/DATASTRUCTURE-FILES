import javax.swing.*;

class QueueArray
{
    
      private Object[] items;
	   private int count;
	
		public QueueArray(int size){
		    items = new Object[size];
		    count = 0;
		}
		
		public boolean isEmpty(){
		    return count == 0;
		}
		
		public boolean isFull(){
		    return count == items.length;
		}
		
		public boolean enqueue(Object i){
		    if(!isFull()){
		        items[count] = i;
		        count = count + 1;
		        return true;
		    }
		    return false;
		}
	
		public boolean dequeue(){
		    if(!isEmpty()){
		        if(count == 1){
		            items[0] = null;
		        }
		        else{
    		        for(int i = 0; i < count -1; i = i + 1){
    		            items[i] = items[i+1];
    		        }
    		        items[count -1] = null;
    		    }
    		    count = count -1;
    		    return true;
		    }
		    return false;
		}    
		
		public String display(){
		    String result = "[";
    		    for(int i = 0; i < count; i = i + 1){
    		        result = result + items[i];
    		        if(i < count - 1){
    		            result = result + ",";
    		        }
    		    }
    		    result = result + "]";
    		    return result;
		}
		
    
	public static void main(String[] args) {
      boolean isDoneDone = false;
		while(!isDoneDone){
		
         String firstChoice = JOptionPane.showInputDialog("Menu:\n\n1.Create\n2.Exit");
   		
      
      
         switch(firstChoice){
            case "1":
               String QueueS = JOptionPane.showInputDialog("Enter the size of Queue: ");
               int QueueSize = Integer.parseInt(QueueS);
               QueueArray QA = new QueueArray(QueueSize);
               
               boolean isDone = false;
               while(!isDone){
               
                  String secondChoice = JOptionPane.showInputDialog("Menu: \n1.Enqueue\n2.Dequeue\n3.Display\n4.Exit");
                  
                     switch(secondChoice){
                        
                     
                        
                            case "1":
                              String QInput = JOptionPane.showInputDialog("Enter content: ");  
                              QA.enqueue(QInput);
                            break;
                            
                            case "2":
                              QA.dequeue();
                            break;
                            
                            case "3":
                              JOptionPane.showMessageDialog(null, QA.display(), "QueueArray contents", JOptionPane.PLAIN_MESSAGE);
                            break;
                            
                            case "4":
                              isDone = true;
                            break;
                      }
                 }
               break;
   
            
            case "2":
               System.out.print("Exiting...");
            break;
         }
         }
	}
}