import java.util.*;

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
    

    
    public boolean edit(Object a, Object b){
        if(!isEmpty()){
            int loc = searchPart2(a);
                if(loc != -1){        
                    items[loc] = b;
                    return true;
                }
        }
        return false;

    }
    
    public boolean edit(int location, Object new2){
        if(!isEmpty() && isLocationValid(location)){
            items[location] = new2;
            return true;
        }
        return false;
        
    }
}

public class ABAISArrayListMenu
{
	public static void main(String[] args) {
// 		array.add("Abais");
// 		array.add("Barral");
// 		array.add("Laroco");
// 		array.add("Satorre");
// 		array.add("Gesim");
		
// 		array.display();
		
// 		array.edit("Abais", "Aldrie");
		
// 		System.out.println();
		
// 		array.display();

        Scanner in = new Scanner(System.in);
        
		MyArrayList array = new MyArrayList(5);
		
		array.add("Abais");
		array.add("Barral");
		array.add("Laroco");
		array.add("Satorre");
		array.add("Gesim");		
        
        int secondChoice = 0;
        boolean back = false;
        
        
        do{
        System.out.println("MyArrayList Menu:\n1. Create Array\n2. Exit");
        int choice = in.nextInt();

            switch(choice){
                case 1:
                    secondChoice = secondChoice(in, secondChoice);
                    in.nextLine();
                        switch(secondChoice){
                            case 1:
                                String addition;
                                
                                for(int i = 0; i < 5; i++){
                                    System.out.println("\nAdd an element to the array: ");
                                    addition = in.nextLine();
                                    implementAdd(array, addition);
                                }
                                back = true;
                            break;
                            case 2:
                                String searchFor;
                                System.out.println("\nEnter a word to be search: ");
                                searchFor = in.nextLine();
                                implementSearch(array, searchFor);
                                back = true;
                            break;
                            case 3:
                                String searchFor2;
                                System.out.println("\nEnter the location of the word to be search: ");
                                searchFor2 = in.nextLine();
                                implementSearch2(array, searchFor2); 
                                back = true;
                            break;
                            
                            default:
                                back = true;
                            break;
                        }
                break;
                
    	}
    }while(!back);
}
	
    public static void callSecondArrayMenu(){
        String[] secondMenu = {
            "1. Add",
            "2. Search",
            "3. SearchPart2",
            "4. Remove 1",
            "5. Remove 2",
            "6. edit 1",
            "7. edit 2",
            "8. get",
            "9. GoBack",
        };
        
        System.out.println("\n\n");
        
        System.out.println("Main Menu:\n---------------");
        for(int i = 0; i < secondMenu.length; i++)
            System.out.println("" + secondMenu[i]);
    }
    
    public static int secondChoice(Scanner in, int secondChoice){
        callSecondArrayMenu();
        
        System.out.println("Choose: ");
        return secondChoice = in.nextInt();
    }
    
    public static void implementAdd(MyArrayList array, String addition){
        array.add(addition);
    }
    
    public static void implementSearch(MyArrayList array, String searchFor){
        if(array.search(searchFor))
            System.out.println("The word " + searchFor + " has been Found!");
    }
    
    public static void implementSearch2(MyArrayList array, String searchFor2){
        array.searchPart2(searchFor2);
            System.out.println("The location of the word " + searchFor2 + " has been Found!");        
    }    
}
