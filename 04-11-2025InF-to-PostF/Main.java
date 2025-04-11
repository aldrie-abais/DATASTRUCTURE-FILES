
    public class Main{
        public static int precedence(char ch)
        {
            if(ch=='+' || ch=='-')
            {
                return 1;
            }
            else if(ch=='*' || ch=='/')
            {
                return 2;
            }
            return 0;
        }

        public static String convertToPostfix(String exp)
        {
            StackNode operators = new StackNode();
            String Result = ""; //postFix
            // String newResult = ""; //new_postFix

            for(int i = 0; i < exp.length(); i++)
            {
                char ch = exp.charAt(i);

                if(ch=='(') 
                    operators.push(ch);            
                else if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')) 
                    Result += ch+""; 
                else if(ch==')')
                { 
                    while(operators.peek().toString().charAt(0) != '(' )
                    { // STEP 5 of Algorithm.
                        String op = operators.pop().toString();
                        Result += op + "";
                    } 
                    operators.pop();
                }
                else if(ch=='+' || ch=='-' || ch== '*' || ch== '/') 
                { // check precedence of each operator with top of the stack and process them.
                    while(!operators.isEmpty() && !operators.peek().equals('(') && precedence(ch) <= precedence(operators.peek().toString().charAt(0)))
                    {
                        String op = operators.pop().toString();
                        Result += op;
                    } 
                    operators.push(ch);                 
                } 
                    
            } // If the operator stack still has some elements in it process them too Repeat Step 5. 
                while(!operators.isEmpty())
                    {
                        char op = operators.pop().toString().charAt(0);

                        

                        Result += op;

                    }
                    return Result;
                }
        

                public static void main(String args[])
                {
                    // We pass Uppercase Infix
                    String infixExpression = "2+1(3+5)";
                    System.out.println("The Infix Expression is: "+infixExpression);
                    String result = convertToPostfix(infixExpression);
                    System.out.println("The Postfix of the given Infix Expression is: "+result);

                    System.out.println();
                }
            
        
}