# PrefixExpressions
 You are given a prefix expression. Write a program which evaluates it.
 Question can be found on :https://www.codeeval.com/open_challenges/7/
 
#Running PrefixExpressions (Make sure you have java and gradle installed)

=>Using the terminal/command line, clone PrefixExpressions 

=>cd in the PrefixExpressions directory

=>type "gradle build" to build PrefixExpressions

=>type "java -cp build/classes/main PrefixExpressions data/data.txt" to rund and pass data/data.txt as a command line arguement
   *modify data/data.txt to evaluate expressions you want
   
   
Sample Output:
Andrewss-MacBook-Pro:PrefixExpressions aafful$ java -cp build/classes/main PrefixExpressions data/data.txt
					
			+ * + - 1 2 4 3 6 = 15
					
			+ - * 2 3 4 5 = 10
					
			* + 2 3 4 = 20
					
			* + 1 7 3 = 24
 
 
