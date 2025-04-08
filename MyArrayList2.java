// NAME: ALDRIE U. ABAIS
// DESCRIPTION: ACT 7
// DATE: 02-28-2025

import java.util.*;

class MyArrayList{
    private Object[] items;
    public int count;

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

    public boolean add(Object o){
        if(!isFull()){
                    items[count] = o;
                    count = count+1;
                    return true;
            }
        return false;
    }

    public int search(Object o){
        if(!isEmpty()){
            for(int i = 0; i < count; i++){
                if(items[i].toString().equals(o.toString())){
                    return 1;
                    //exit loop
                }
            }
            // if the loop ends, item not existing
            return 0;
        }
        return -1;
    }

    public int searchPart2(Object o){
        if(!isEmpty()){
            for(int i = 0; i < count; i++){
                if(items[i].toString().equals(o.toString())){
                    return i;///////////////////////////////////////////////////////////////

                }
            }
            return 0;
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

    public int remove1(Object o){
        if(!isEmpty()){
            int loc = searchPart2(o);
            if(loc > 0){
                items[loc-1] = items[count-1];
                items[count-1] = null;
                count = count-1;
                return 1;
            }
                return 0;
        }
        return -1;
    }

    public boolean remove2(int location){///////////////////////////////////////////////////////////////
        if(!isEmpty() && isLocationValid(location)){
            items[location] = items[count-1];
            items[count-1] = null;
            count = count - 1;
            return true;
        }

        return false;
    }

    public boolean display(){
        if(!isEmpty()){
            for(int i = 0; i < count; i++){
                System.out.printf("%d. %s\n", i+1, items[i]);
            }
            return true;
        }

        return false;
    }

    public int edit(Object a, Object b){
        if(!isEmpty()){
            int loc = searchPart2(a);
            if(loc >= 0){
                items[loc] = b;
                return 1;
            }
            return 0;
        }
        return -1;
    }

    public int edit(int location, Object new2){
        if(!isEmpty()){
            if(isLocationValid(location)) {
                items[location] = new2;
                return 1;
            }
            return 0;
        }
        return -1;
    }
    
    public boolean increase(int addSize){
        if(addSize > 0 && (items.length + addSize) <= 50)
        {
            Object[] temp = new Object[items.length + addSize];
            for(int i = 0; i<count; i++)
            {
                temp[i] = items[i];
            }
            items = null;
            items = temp;
            return true;
        }
        return false;
    }
    
    public boolean insert(Object o, int index){
        String tempElement;
        String tempElement2;
        int lastLoc= getCount()-1;
        tempElement = getElement(index);
        tempElement2 = getElement(lastLoc);
        edit(lastLoc, tempElement);
        edit(index, o);
        return true;
    }

    public int getCount(){
        return count;
    }

    public boolean addCount(){
        count--;
        return true;
    }

    public int getSize(){
        return items.length;
    }

    public String getElement(int i){
        return items[i].toString();
    }

}

public class MyArrayList2
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyArrayList array;

        boolean back = false;
        int choice = -1;
        boolean checker = false;

        do{
            try{
                do{

                    System.out.println("\n=================");
                        System.out.println("MyArrayList Menu:\n=================\n1. Create Array\n2. Exit");
                        System.out.print("Enter your choice: ");

                        if(choice !=1 || choice !=2 ){
                            choice = in.nextInt();
                            in.nextLine(); // Consume newline

                            if (choice == 1) {
                                System.out.print("Enter array length: ");
                                int arrLength = in.nextInt();
                                array = new MyArrayList(arrLength);
                                do{
                                    back = secondChoice(in, array, back);
                                }while(back);
                            }
                            else if(choice == 2){
                                System.out.println("Exiting program...");
                                back = true;
                            }
                            else {
                                System.out.println("Invalid input. Please enter 1 or 2.");
                                in.next();
                                back = false;
                            }
                        }
                }while(!back);
                checker = false;
            }catch(Exception e){
                checker = true;
                System.out.println("You can only input integers.");
                in.next();
            }
        }while(checker);

    }

    public static void callSecondArrayMenu(){
        String[] secondMenu = {
                "1. Add",
                "2. Search",
                "3. SearchPart2",
                "4. Remove 1",
                "5. Remove 2",
                "6. Edit 1",
                "7. Edit 2",
                "8. Get",
                "9. Display Array Contents & Count",
                "10. Increase array size",
                "11. Insert",
                "0. GoBack",
        };

        System.out.println("\n\n");

        System.out.println("Main Menu:\n---------------");
        for(int i = 0; i < secondMenu.length; i++)
            System.out.println("" + secondMenu[i]);
    }

    public static boolean secondChoice(Scanner in, MyArrayList array, boolean back){
        callSecondArrayMenu();

        System.out.print("Choose: ");
        int secondChoice = in.nextInt();
        in.nextLine();

        switch(secondChoice){
            case 1:
                int fixedCount, lackingElement;
                fixedCount = array.getCount();
                lackingElement = array.getSize() - fixedCount;

                if(array.getSize() >= fixedCount){

                    String addition;
                    boolean isExist = false;
                    for(int i = 0; i < lackingElement; i++){
                        while(true){
                            isExist= false;
                            System.out.printf("\nAdd an element to the array (%d / %d): ", array.getCount() + 1, array.getSize());
                            addition = in.nextLine().toString();
                            for(int a = 0; a < array.count; a++){
                                if(addition.equalsIgnoreCase(array.getElement(a))){
                                    isExist= true;
                                }
                            }
                            if(isExist){
                               System.out.println("This element already exist. Try again."); 
                            }else{
                               array.add(addition);
                               break;
                            }
                            
                        }
                       
                    }
                    System.out.println("Back to menu");
                    back = true;
                }
                if(array.getSize() == fixedCount){
                    System.out.println("Cannot add! The array is already full.");
                    back = true;
                }
                back = true;
                break;
            case 2:
                String searchFor;
                System.out.println("\nEnter a word to be search: ");
                searchFor = in.nextLine();

                if(array.search(searchFor) == 1){
                    System.out.println("The word " + searchFor + " has been found!");
                }
                if(array.search(searchFor) == 0){
                    System.out.println("The word " + searchFor + " has not found!");
                }
                if(array.search(searchFor) == -1){
                    System.out.println("Sorry but the array is currently empty.");
                }

                back = true;

                break;
            case 3:
                String searchFor2;
                System.out.println("\nEnter the word u want to be located: ");
                searchFor2 = in.nextLine();

                if(array.searchPart2(searchFor2) > 0){
                    System.out.printf("The word %s is on position no.%d: ", searchFor2, array.searchPart2(searchFor2));
                }
                else if(array.searchPart2(searchFor2) == 0){
                    System.out.println("The element located  " + searchFor2 + " has not found!");
                }
                else if(array.searchPart2(searchFor2) == -1){
                    System.out.println("Sorry but the array is currently empty.");
                }


                back = true;

                break;

            case 4:
                String remove;
                System.out.print("Enter the element u want to remove: ");
                remove = in.nextLine();

                if(array.remove1(remove) == 1){
                    System.out.printf("The element %s has been removed!", remove);
                }
                else if(array.remove1(remove) == 0){
                    System.out.printf("The element %s has not been found!", remove);
                }
                else if(array.remove1(remove) == -1){
                    System.out.println("Sorry but the array is currently empty.");
                }

                back = true;
                break;

            case 5:

                boolean checker2 = false;

                do{
                    try{
                        int toBeRemove2;
                        System.out.println("\nEnter the location of the element u want to be removed: ");
                        toBeRemove2 = in.nextInt();

                        if(array.remove2(toBeRemove2)){
                            System.out.printf("The element located at %d has been removed!", toBeRemove2);
                        }else{
                            System.out.print("The there is no element in that location!");
                        }
                        checker2 = false;
                    }catch(Exception e){
                        checker2 = true;
                        System.out.println("You can only input integers.");
                        in.next();
                    }
                }while(checker2);


                back = true;
                break;
            case 6:

                boolean checker = false;

                do{
                    try{

                        String toEdit = "";
                        String toReplace = "";

                        System.out.print("Enter the element u want to edit:");
                        toEdit = in.nextLine();
                        boolean isExist = false;
                        while(true){
                            isExist = false;
                            System.out.print("\nEnter the element u want to replace it with: ");
                            toReplace =  in.nextLine().toString();
                             for(int a = 0; a < array.count; a++){
                                if(toReplace.equalsIgnoreCase(array.getElement(a))){
                                    isExist= true;
                                }
                            }
                            if(isExist){
                               System.out.println("This element already exist. Try again."); 
                            }else{
                               array.edit(toEdit, toReplace);
                                if(array.edit(toEdit, toReplace) == 1){
                                    System.out.printf("The element %s has been successfully replaced with the element %s.", toEdit, toReplace);
                                }
                               break;
                            }
                        }
                           
                        if(array.edit(toEdit, toReplace) == 0) {
                            System.out.printf("Sorry but the element %s has not found.", toEdit);
                        }else if(array.edit(toEdit, toReplace) == -1){
                            System.out.printf("Sorry but the array is currently empty.", toEdit);
                        }

                        checker = false;
                    }catch(Exception e){
                        checker = true;
                        System.out.println("You can only input integers.");
                        in.next();
                    }
                }while(checker);

                back = true;
                break;

            case 7:
                int locToEdit =0;
                String toReplace2 = "";
                boolean checker3 = false;

                do{
                    try{


                        System.out.print("Enter the location of the element u want to edit:");
                        locToEdit = in.nextInt();
                        in.nextLine();
                        checker3 = false;
                    }catch(Exception e){
                        checker3 = true;
                        System.out.println("You can only input integers.");
                        in.next();
                    }
                }while(checker3);

                    boolean isExist2 = false;
                        while(true){
                            isExist2 = false;
                            System.out.print("\nEnter the element u want to replace it with: ");
                            toReplace2 =  in.nextLine().toString();
                             for(int a = 0; a < array.count; a++){
                                if(toReplace2.equalsIgnoreCase(array.getElement(a))){
                                    isExist2= true;
                                }
                            }
                            if(isExist2){
                               System.out.println("This element already exist. Try again."); 
                            }else{
                               array.edit(locToEdit, toReplace2);
                                if(array.edit(locToEdit, toReplace2) == 1){
                                    System.out.printf("The element %s has been successfully replaced with the element %s.", locToEdit, toReplace2);
                                }
                               break;
                            }
                        }

                

                if(array.edit(locToEdit, toReplace2) == 0) {
                    System.out.printf("Sorry but the element located on position %s has not found.", locToEdit);
                }else if(array.edit(locToEdit, toReplace2) == -1){
                    System.out.print("Sorry but the array is currently empty.");
                }

                back = true;
                break;

            case 8:

                boolean checker4 = false;

                do{
                    try{
                        checker4 = false;
                        System.out.print("Enter location of the element u want to see: ");
                        int loc = in.nextInt();
                        in.nextLine();
                        System.out.printf("the element on that location is %s. ",array.get(loc));
                    }catch(Exception e){
                        checker4 = true;
                        System.out.println("You can only input integers.");
                        in.next();
                    }
                }while(checker4);
                back = true;
                break;

            case 0:
                    return false;
            case 9:
                System.out.println("\nArray Elements:");
                for(int i = 0; i < array.getCount(); i++){
                    System.out.printf("%s\n", array.getElement(i));
                }
                System.out.printf("Count: %d" +
                        "\n", array.getCount());
                back = true;
                break;
                
            case 10:
                int addArrSize;
                System.out.print("Increase array size by: ");
                addArrSize = in.nextInt();
                
                array.increase(addArrSize);
                back = true;
                break;
                
            case 11:
                String toInsert;
                int insertLoc;
                
                boolean isExist = false;
                        while(true){
                            isExist = false;
                            System.out.print("Enter an element u want to insert: ");
                            toInsert = in.nextLine();
                             for(int a = 0; a < array.count; a++){
                                if(toInsert.equalsIgnoreCase(array.getElement(a))){
                                    isExist= true;
                                }
                            }
                            if(isExist){
                               System.out.println("This element already exist. Try again."); 
                            }else{
                               break;
                            }
                        }
                
                
                
                System.out.print("Enter the location where you want the elment to be inserted: ");
                insertLoc = in.nextInt();
                
                array.increase(1);
                array.add(toInsert);
                array.insert(toInsert, insertLoc);
                back = true;
                break;

        }
        return back;
    }
}
