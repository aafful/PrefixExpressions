
import java.util.ArrayList;
import java.util.Stack;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by aafful on 1/7/15.
 */
public class PrefixExpressions {

    public static void main(String[] args) throws Exception {
        if (args.length < 1)
            throw new IllegalArgumentException("You need to passs a File expression as a command-line argument");

        File cmdFile = new File(args[0]);
        if (!cmdFile.exists())
            throw new Exception("The specified file does not exist: " + cmdFile.getAbsolutePath());

        PrefixExpressions expr = new PrefixExpressions();
        expr.parseExpressionsFromFile(cmdFile);


   //For testing purposes
       /* PrefixExpressions expr = new PrefixExpressions();
        expr.calculateResults("+ * + - 1 2 4 3 6");
        expr.calculateResults("+ - * 2 3 4 5");
        expr.calculateResults("* + 2 3 4");
        expr.calculateResults("* + 1 7 3");*/
    }

    /*
    * Main Algorithm that does the computation
    * */
    private void calculateResults(String stringToSplit) {

        String[] digits = stringToSplit.split("\\D+"); //Get all the values in the String
        Stack<Integer> digitVals = new Stack<Integer>();

        for(int i=digits.length-1; i>0; i--){
            digitVals.push(Integer.parseInt(digits[i]));
        }

        String[] nonDigits = stringToSplit.split("\\d+");
        String operators = nonDigits[0].replaceAll("\\s","");//Get the Math operators fron non digits

        int num1,num2;

        for (int i=operators.length()-1; i>=0; i--){
            char token = operators.charAt(i);
            if(token == '+'){
                num1 = digitVals.pop();
                num2 = digitVals.pop();
                digitVals.push(num2+num1);
            }
            else if(token == '*'){
                num1 = digitVals.pop();
                num2 = digitVals.pop();
                digitVals.push(num2*num1);
            }
            else if(token == '/'){
                num1 = digitVals.pop();
                num2 = digitVals.pop();
                digitVals.push(num2/num1);
            }
        }

        int results = digitVals.peek();//Should be the last val on the stack
        System.out.println(stringToSplit+" = "+results);
    }

    /*
    * In case we pass an expression in a File, we want to be able to calculate the results for each
    * */

    private void parseExpressionsFromFile(File file){
        ArrayList<String> input = new ArrayList<String>();
        BufferedReader br = null;

        try{
            String line;
            br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                input.add(line.trim());
            }
        }catch(Exception e){
            throw new RuntimeException("Error while reading file");
        }finally{
            try{
                br.close();
            }catch(Exception e){}
        }

        //Calculate Prefix for each String command
        int inputSize = 0;
        for(String line : input) {
            if (inputSize <= 40)
                calculateResults(line);
                inputSize++;
        }
    }
}
