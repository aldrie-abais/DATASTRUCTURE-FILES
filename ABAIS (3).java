class MyArrayList{
    private Object[] items;
    private int count;
    
    public MyArrayList(){
        this(10);
    }
    
    public MyArrayList(int size){
        //min = 5, max = 50
        if(size >= 5 && size <= 50){
            items = new Object[size];
        }
        else{
            items = new Object[10];
        }
        count = 0;
    }
    
    private boolean isFull(){
        return count == items.length;
    }

    private boolean isEmpty(){
        return count == 0;
    }
    
    private boolean isLocationValid(int location){
        return location >= 0&& location <= count -1;
    }    
    
    public boolean add(Object i){
        if(!isFull()){
            items[count] = i;
            count = count+1;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean search(Object o){
        if(!isEmpty()){
            for(int i = 0; i < count; i++){
                if(items[i].toString().equals(o.toString())){
                    return true;
                    //exit loop
                }
            }
            // if the loop ends, item not existing
            return false;
        }
        return false;
    }    

    public int searchPart2(Object o){
        if(!isEmpty()){
            for(int i = 0; i < count; i++){
                if(items[i].toString().equals(o.toString())){
                    return i;
                    //exit loop
                }
            }
        }
        return -1;
    }
    
    public Object get(int location){
        if(!isEmpty() && isLocationValid(location)){
            return items[location];
        }
        else{
            return null;
        }
    }
    
    public boolean remove(Object o){
        if(!isEmpty()){
            int loc = searchPart2(o);
                if(loc != -1){
                    items[loc] = items[count-1];
                    items[count-1] = null;
                    count = count-1;
                    return true;
                }
                else{
                    return false;
                }
        }
        else{
            return false;
        }
    }
    
    public boolean remove(int location){
        if(!isEmpty() && isLocationValid(location)){
            items[location] = items[count-1];
            items[count-1] = null;
            count = count - 1;
            return true;
        }
        
        return false;
    }
    
    public void display(){
        if(!isEmpty()){
            for(int i = 0; i < count; i++){
                System.out.println("" + items[i]);
            }
        }
    }
    
    public boolean edit(Object a, Object b){
        if(!isEmpty()){
            int loc = searchPart2(a);
                if(loc != -1){        
                    items[loc] = b;
                    return true;
                }
            return false;    
        }
        return false;

    }
}

public class ABAIS
{
	public static void main(String[] args) {
		MyArrayList array = new MyArrayList(5);
		array.add("Abais");
		array.add("Barral");
		array.add("Laroco");
		array.add("Satorre");
		array.add("Gesim");
		
		array.display();
		
		array.edit("Abais", "Aldrie");
		
		System.out.println();
		
		array.display();
	}
}