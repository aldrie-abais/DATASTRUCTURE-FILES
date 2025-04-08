import java.util.Scanner;

class act1ABAIS
{
	
	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        int evenCounter = 0;
        int oddCounter = 0;
        int zeroCounter = 0;
        int negativeCounter = 0;
        int positiveCounter = 0;
        
        int[] numAr = new int[20];
        
        for(int i = 0; i < numAr.length; i++){
            System.out.printf("Enter the Integer Number %d: ", i+1);
            numAr[i] = in.nextInt();
        }
        
        for(int i = 0; i < numAr.length; i++){
            if(numAr[i] % 2 == 0){
                evenCounter++;
            }
            if(numAr[i] % 2 == 1){
                oddCounter++;
            }
            if(numAr[i] == 0){
                zeroCounter++;
            }
            if(numAr[i] >= 1){
                positiveCounter++;
            }
            if(numAr[i] < 0){
                negativeCounter++;
            }
        }
        
        System.out.printf("Even numbers quantity: %d\n", evenCounter);
        System.out.printf("Odd numbers quantity: %d\n", oddCounter);
        System.out.printf("Zero numbers quantity: %d\n", zeroCounter);
        System.out.printf("Negative numbers quantity: %d\n", negativeCounter);
        System.out.printf("Positive numbers quantity: %d\n", positiveCounter);




	}
}
