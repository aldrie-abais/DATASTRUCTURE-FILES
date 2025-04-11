import javax.swing.*;
import java.util.Scanner;

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
        Scanner in = new Scanner(System.in);
        boolean isDoneDone = false;
        while(!isDoneDone){
            String firstChoice;
            int checkPoint = 0;

            do {
                if(checkPoint >= 1){
                    JOptionPane.showMessageDialog(null, "You can only choose 1-2.");
                }
                    checkPoint++;
                    firstChoice = JOptionPane.showInputDialog("Menu:\n\n1.Create\n2.Exit");
            }while(!firstChoice.equals("1") && !firstChoice.equals("2"));



            switch(firstChoice){
                case "1":
                    int QueueSize = 0;
                    boolean checker;

                    do {
                        checker = false;
                        try {
                            String QueueS = JOptionPane.showInputDialog("Enter the size of Queue: ");
                            if (QueueS == null) {
                                JOptionPane.showMessageDialog(null, "Operation cancelled.");
                                return; // Or break / exit depending on what you want
                            }
                            QueueSize = Integer.parseInt(QueueS);
                        } catch (NumberFormatException e) {
                            checker = true;
                            JOptionPane.showMessageDialog(null, "You can only input an integer.");
                        }
                    } while (checker);
                    QueueArray QA = new QueueArray(QueueSize);

                    boolean isDone = false;
                    while(!isDone){

                        String secondChoice = "";
                        do {
                            if(secondChoice == null){
                                isDone = true;
                            }
                            secondChoice = JOptionPane.showInputDialog("Menu: \n1.Enqueue\n2.Dequeue\n3.Display\n4.Exit");

                            if (!secondChoice.equals("1") && !secondChoice.equals("2") &&
                                    !secondChoice.equals("3") && !secondChoice.equals("4")) {
                                JOptionPane.showMessageDialog(null, "You can only choose 1–4.");
                            }

                        }while(!firstChoice.equals("1") && !firstChoice.equals("2") && !firstChoice.equals("3") && !firstChoice.equals("4"));

                        switch(secondChoice){

                            case "1":
                                String QInput = JOptionPane.showInputDialog("Enter content: ");
                                QA.enqueue(QInput);
                                break;

                            case "2":
                                boolean result = false;
                                result = QA.dequeue();
                                if(!result){
                                    JOptionPane.showMessageDialog(null, "The queue is already empty.", "Dequeue result.", JOptionPane.PLAIN_MESSAGE);
                                }
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
