
public class Notation {
	
	private static int size = 0;

	public Notation()	{}

	
	/**
	public static java.lang.String convertInfixToPostfix(java.lang.String infix)
                                              throws InvalidNotationFormatException
	Convert an infix expression into a postfix expression
	Parameters:
	infix - the infix expression in string format
	Returns:
	the postfix expression in string format
	Throws:
	InvalidNotationFormatException - if the infix expression format is invalid
	 
	 * 
	 * 
	*/
	public static String convertInfixToPostfix (String infix) throws InvalidNotationFormatException
	{
		size = infix.length();
		NotationQueue<String> postfix = new NotationQueue<String>(size);
		NotationStack<String> operatorStack= new NotationStack<String>(size);
		
		
		try
		{
			
			for(int i=0; i< infix.length(); i++)
			{
			
				if(infix.charAt(i) ==' ')
				{
					continue;
				}
				
				else if(infix.charAt(i) == '*' || infix.charAt(i) == '/'|| infix.charAt(i) =='+'|| infix.charAt(i) =='-') 
				{
					switch(infix.charAt(i))
					{
					
					case '+' : 
						if(operatorStack.top()== "-")
						{
							postfix.enqueue(operatorStack.top());
							operatorStack.pop();
							operatorStack.push("+");
						}
						else if(operatorStack.top()== "/") {
							postfix.enqueue(operatorStack.top());
							operatorStack.pop();
							operatorStack.push("+");
						}
						
						
						
						else
						{
							operatorStack.push("+");
						}
						break;
						
					case '-' : 
						if(operatorStack.top()== "+")
						{
							postfix.enqueue(operatorStack.top());
							operatorStack.pop();
							operatorStack.push("-");
						}
						else if(operatorStack.top()== "*") {
							postfix.enqueue(operatorStack.top());
							operatorStack.pop();
							operatorStack.push("-");
						}
						else if(operatorStack.top()== "/") {
							postfix.enqueue(operatorStack.top());
							operatorStack.pop();
							operatorStack.push("-");
						}
					
						else
						{
							operatorStack.push("-");
						}
						break;
					
					case '*': 
						if(operatorStack.isEmpty() || !(operatorStack.top()== "/")) 
						{
							operatorStack.push("*");
						}
						else if(operatorStack.top()== "/")
						{
							postfix.enqueue(operatorStack.top());
							operatorStack.pop();
							operatorStack.push("*");
						}
						break;
					
					case '/':  
						if(operatorStack.top()== "*")
						{
							postfix.enqueue(operatorStack.top());
							operatorStack.pop();
							operatorStack.push("/");
						}
						else
						{
							operatorStack.push("/");
						}
						break;
					
					}
						
					
				}
				
				else if(infix.charAt(i) == '(')
				{
					operatorStack.push("(");
				}
				else if(Character.isDigit(infix.charAt(i)))
				{
					postfix.enqueue(String.valueOf(infix.charAt(i)));
				}
				
				else if(infix.charAt(i) == ')') 
				{
					if((operatorStack.toString().contains("("))) 
					{
						int size= operatorStack.size(); 
						for(int j=0; j <  size; j++)
						{
							if(operatorStack.top()== "+")
							{
								postfix.enqueue(operatorStack.top());
								operatorStack.pop();
							}
							
							else if(operatorStack.top()== "-") {
								postfix.enqueue(operatorStack.top());
								operatorStack.pop();
							}
							else if(operatorStack.top()== "*") {
								postfix.enqueue(operatorStack.top());
								operatorStack.pop();
							}
							else if(operatorStack.top()== "/") {
								postfix.enqueue(operatorStack.top());
								operatorStack.pop();
							}
							
							else if (operatorStack.top()=="(")
							{
								operatorStack.pop();
								break;
							}
						}
					}
					else
					{
						throw new InvalidNotationFormatException();
					}
				}
			}
			for(int i=0; i< operatorStack.size(); i++)
			{
				postfix.enqueue(operatorStack.top());
				operatorStack.pop();
			}
		}
		catch (QueueOverflowException e) {
			e.getMessage();
		} catch (StackOverflowException e) {
			e.getMessage();
		} catch (StackUnderflowException e) {
			e.getMessage();
		}
		
		return postfix.toString();
	}

	/**
	 * public static java.lang.String convertPostfixToInfix(java.lang.String postfix)
                                              throws InvalidNotationFormatException
	Convert the Postfix expression to the Infix expression
	Parameters:
	postfix - the postfix expression in string format
	Returns:
	the infix expression in string format
	Throws:
	InvalidNotationFormatException - if the postfix expression format is invalid
	 * @param postfix
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix)throws InvalidNotationFormatException
	{
		NotationStack<String> stack = new NotationStack<>(postfix.length());
		try {
			for (int i = 0; i < postfix.length(); i++) {
			
				if (postfix.charAt(i) == ' ') {
					continue;
				}
				else if (Character.isDigit(postfix.charAt(i))) {
					stack.push(Character.toString(postfix.charAt(i)));
				
				}
				else if ((postfix.charAt(i) == '*' || postfix.charAt(i) == '/' || postfix.charAt(i) == '+' || postfix.charAt(i)== '-') && stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}
					
				else if (postfix.charAt(i) == '*' || postfix.charAt(i) == '/' || postfix.charAt(i) == '+' || postfix.charAt(i) == '-') {
					String first = stack.pop();
					String second = stack.pop();
					String s = "(" + second + postfix.charAt(i) + first + ")";
					stack.push(s);
					}
				}
			
			}catch(StackUnderflowException | StackOverflowException e) {
				throw new InvalidNotationFormatException();
			}

		
		return stack.toString();
	}

	/**
	 * public static double evaluatePostfixExpression(java.lang.String postfixExpr)
                                        throws InvalidNotationFormatException
	Evaluates a postfix expression from a string to a double
	Parameters:
		postfixExpr - the postfix expression in String format
	Returns:
		the evaluation of the postfix expression as a double
	Throws:
		InvalidNotationFormatException - if the postfix expression format is invalid
	 * @param postfixExpr
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{

		NotationStack<Double> stack = new NotationStack<>(postfixExpr.length());
		char[] array = postfixExpr.toCharArray();
		
		
		try {
				for(char x: array) {
					if(Character.isDigit(x)) {
						stack.push(Double.parseDouble(Character.toString(x)));
					}
					if (x == '*' || x == '/' || x == '+' || x == '-') {
						if (stack.size() <=0) {
						throw new InvalidNotationFormatException();
					}
				
					double two = stack.pop();
					double one = stack.pop();

					switch(x) {
					
					case '+':
						stack.push(one + two);
						break;
					
					case '-' :
						stack.push(one - two);
						break;
					
					case '*':
						stack.push(two* one);
						break;
						
					case '/':
						stack.push(one / two);
						break;
					
					}
					
						
				}
				}
				
			}catch (StackOverflowException | StackUnderflowException e) {
				throw new InvalidNotationFormatException();
			}
			double number = Double.parseDouble(stack.toString());
			
				return number;
		} 

	
		
}