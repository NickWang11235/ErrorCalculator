package numwitherror;

import java.lang.reflect.Method;

/**
 * This program is designed to perform calculations with numbers that has an error associated with them.
 * @author cccc1
 */
public class NumWithError {
    
    private final double num, error;

    /**
     * Constructs a number that has a value and an inaccuracy
     * @param num the number value
     * @param error absolute value of the error
     */
    public NumWithError(double num, double error) {
        this.num = num;
        this.error = error;
    }
    
    /**
     * construct a number with a string
     * @param str the string can contain a "±" for number with error. If no error is attached, it is default to be 0.
     */
    public NumWithError(String str){
        
       String[] strs  = str.split("±");
       
       double a = Double.valueOf(strs[0]);
       double b = 0;
       
       if(strs.length == 2)
           b = Double.valueOf(strs[1]);
       
       this.num = a;
       this.error = b;
        
    }
    
    public double getNum() {
        return num;
    }

    public double getError() {
        return error;
    }
    
    /**
     * calculate the result of the operation, provided with the operation that is being performed and the numbers to perform it on.
     * once the parameters are passed in, the objects in nums is then passed in to the Method object m, which is then called upon with no implicit parameter.
     * @param m the predefined method. Stored in the Operations class
     * @param nums the parameters that are being passed in
     * @return the resulting number with an inaccuracy
     * @throws Exception 
     */
    public static NumWithError calculate(Method m, NumWithError... nums) throws Exception{
        
        NumWithError result = (NumWithError)m.invoke(null, nums);
        return result;
        
    }
    
//    @Override
//    public String toString(){
//        char plusminussign = '\u00B1';
//        return Math.round(this.num*100000000.0)/100000000.0+ " " + plusminussign + " " + Math.round(this.error*100000000.0)/100000000.0;
//    }
//    
    @Override
    public String toString(){
        char plusminussign = '\u00B1';
        return this.num+ " " + plusminussign + " " + this.error;
    }
    
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        
        NumWithError a = new NumWithError(2,0);
        NumWithError b = new NumWithError(4,0);
        
        
        System.out.println(NumWithError.calculate(Operations.POWER,a,b));
    }      
    
}
