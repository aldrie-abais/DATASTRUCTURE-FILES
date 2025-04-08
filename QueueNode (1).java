

class QueueNode
{
	public static void main(String[] args) {
	private MyNode top;
	private int count;
    	
    	public QueueNode(){
    	    top = null;
    	    count = 0;
    	}
    	
    	public boolean isEmpty(){
    	    return top == null;
    	}
    	
    	public boolean isFull(){
    	    return false;
    	}
    	
    	public boolean enqueue(Object i){
    	    MyNode newNode = new MyNode();
    	    if(isEmpty()){
    	        top = newNode;
    	    }else{
    	        MyNode tempTop = top;
    	        while(tempTop.next != null){
    	            tempTop = tempTop.next;
    	        }
    	        tempTop.next = newNode;
    	    }
    	    count = count + 1;
    	    return true;
    	}
	}
}