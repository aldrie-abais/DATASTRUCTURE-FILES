import java.util.Scanner;


public class act3ABAIS
{
	
	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        int[] numAr = new int[20];
        
        int addResult = 0;
        int subtractResult = 0;
        int multiplicationResult = 0;
        double divideResult = 0;
        
        
        
        for(int i = 0; i < numAr.length; i++){
            System.out.printf("Enter the Integer Number %d: ", i+1);
            numAr[i] = in.nextInt();
            
            if(i == 1){
                addResult = numAr[0] += numAr[1];
                subtractResult = numAr[0] -= numAr[1];
                multiplicationResult = numAr[0] *= numAr[1];
                divideResult = numAr[0] /= numAr[1];
            }
        
            if(i >= 2){
                addResult = addResult += numAr[i];
                subtractResult = subtractResult -= numAr[i];
                multiplicationResult = multiplicationResult *= numAr[i];
                divideResult = divideResult /= numAr[i];
            }
            
        }
        
        System.out.println();
        System.out.printf("The sum of the 20 Integers: %d\n", addResult);
        System.out.printf("The difference of the 20 Integers: %d\n", subtractResult);
        System.out.printf("The product of the 20 Integers: %d\n", multiplicationResult);
        System.out.printf("The quotient of the 20 Integers: %.2f\n", divideResult);


	}
}
