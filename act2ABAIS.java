import java.util.Scanner;

class act2ABAIS
{
	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        int vowelCount = 0;
        int consonantCount = 0;
        
        
        System.out.printf("Enter a text: ");
        String text = in.nextLine().toLowerCase();
        
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if(c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u'){
                vowelCount++;
            }
            else if(c == 'b'||c == 'c'||c == 'd'||c == 'f'||c == 'g'||c == 'h'||c == 'j'||c == 'k'||c == 'l'||c == 'm'||c == 'n'||c == 'p'||c == 'q'||c == 'r'||c == 's'||c == 't'||c == 'v'||c == 'w'||c == 'x'||c == 'y'||c == 'z')
            {
                consonantCount++;
            }
        }
        
        System.out.printf("Vowel count: %d", vowelCount);
        System.out.printf("Consonant count: %d", consonantCount);

	}
}