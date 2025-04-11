import javax.swing.*;

class QueueNode
{
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
        MyNode newNode = new MyNode(i);
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

    public boolean dequeue(){
        if(!isEmpty()){
            if(top != null && top.next == null){
                top = null;
            }else{
                top = top.next;
            }
            count = count -1;
            return true;
        }
        return false;
    }

    public String display(){
        String result = "[";
            MyNode tempTop = top;
            if(tempTop.next == null){
                result += tempTop.item;
            }else {
                while(tempTop.next != null) {
                    result += tempTop.item += ", ";
                    tempTop = tempTop.next;

                }
                result += tempTop.item;
            }
        result = result + "]";
        return result;
    }

    public static void main(String[] args) {
        boolean isDoneDone = false;
        while(!isDoneDone) {

            String firstChoice;
            int checkPoint = 0;

            do {
                if(checkPoint >= 1){
                    JOptionPane.showMessageDialog(null, "You can only choose 1-2.");
                }
                checkPoint++;
                firstChoice = JOptionPane.showInputDialog("Menu:\n\n1.Create\n2.Exit");
            }while(!firstChoice.equals("1") && !firstChoice.equals("2"));


            switch (firstChoice) {
                case "1":
//                    String QueueS = JOptionPane.showInputDialog("Enter the size of Queue: ");
//                    int QueueSize = Integer.parseInt(QueueS);
                    QueueNode QN = new QueueNode();

                    boolean isDone = false;
                    while (!isDone) {

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

                        switch (secondChoice) {

                            case "1":
                                String QInput = JOptionPane.showInputDialog("Enter content: ");
                                QN.enqueue(QInput);
                                break;

                            case "2":
                                boolean result = false;
                                result = QN.dequeue();
                                if(!result){
                                    JOptionPane.showMessageDialog(null, "The queue is already empty.", "Dequeue result.", JOptionPane.PLAIN_MESSAGE);
                                }
                                break;

                            case "3":
                                JOptionPane.showMessageDialog(null, QN.display(), "QueueNode contents", JOptionPane.PLAIN_MESSAGE);
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
