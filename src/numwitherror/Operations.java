package numwitherror;

import java.lang.reflect.Method;

/**
 *
 * @author cccc1
 */
public class Operations {
            
    public static Method LOG10;
    public static Method SINE;
    public static Method COSINE;
    public static Method TANGENT;
    public static Method ADD;
    public static Method SUBTRACT;
    public static Method MULTIPLY;
    public static Method DIVIDE;
    public static Method POWER;

    /**
     * statically initialize the predefined operations
     */
    static{
        try{
            LOG10 = Operations.class.getMethod("LOG10", NumWithError.class);
            SINE = Operations.class.getMethod("SINE", NumWithError.class);
            COSINE = Operations.class.getMethod("COSINE", NumWithError.class);
            TANGENT = Operations.class.getMethod("TANGENT", NumWithError.class);
            ADD = Operations.class.getMethod("ADD", NumWithError.class, NumWithError.class);
            SUBTRACT = Operations.class.getMethod("SUBTRACT", NumWithError.class, NumWithError.class);
            MULTIPLY = Operations.class.getMethod("MULTIPLY", NumWithError.class, NumWithError.class);
            DIVIDE = Operations.class.getMethod("DIVIDE", NumWithError.class, NumWithError.class);
            POWER = Operations.class.getMethod("POWER", NumWithError.class, NumWithError.class);
        }
        catch(NoSuchMethodException | SecurityException e){
            System.out.println(e);
        }
    }
    
    /**
     * add two numbers
     * Ex result = a+b
     * @param a
     * @param b
     * @return 
     */
    public static final NumWithError ADD(NumWithError a, NumWithError b){
        
        NumWithError result = new NumWithError(a.getNum()+b.getNum(), a.getError()+b.getError());
        
        return result;
    }
    
    /**
     * subtract b from a
     * Ex result = a-b
     * @param a the number to be subtracted from
     * @param b the number to subtract
     * @return 
     */
    public static final NumWithError SUBTRACT (NumWithError a, NumWithError b){
        
        NumWithError result = new NumWithError(a.getNum()-b.getNum(), a.getError()+b.getError());
        
        return result;
    }
    
    /**
     * multiply a by b
     * Ex result = a*b
     * @param a
     * @param b
     * @return 
     */
    public static final NumWithError MULTIPLY(NumWithError a, NumWithError b){
        
        double resultTemp = a.getNum()*b.getNum(), 
            // Calculate the error based on the equation Δw/w = Δx/x+Δy/y and the associative property of multiplication
               errorTemp = resultTemp*(a.getError()/a.getNum() + b.getError()/b.getNum());
        
        
        NumWithError result = new NumWithError(resultTemp, errorTemp);
        
        return result;
    }
    
    /**
     * divide a by b 
     * Ex result = a/b
     * @param a the dividend
     * @param b the divisor
     * @return 
     */
    public static final NumWithError DIVIDE(NumWithError a, NumWithError b){
        
        double resultTemp = a.getNum()/b.getNum(), 
            // Calculate the error based on the equation Δw/w = Δx/x+Δy/y and the associative property of multiplication
               errorTemp = resultTemp*(a.getError()/a.getNum() + b.getError()/b.getNum());
        
        
        NumWithError result = new NumWithError(resultTemp, errorTemp);
        
        return result;
    }
    
    /**
     * take a to the power of b. 
     * Ex result = a^b
     * @param a the base
     * @param b the exponent
     * @return 
     */   
    public static final NumWithError POWER(NumWithError a, NumWithError b){
        
        double resultTemp = Math.pow(a.getNum(), b.getNum());
        
        NumWithError result = new NumWithError(resultTemp, resultTemp*b.getNum()*a.getError()/a.getNum());
        
        return result;
    }
    
    /**
     * take the base 10 log of a
     * @param a 
     * @return 
     */
    public static final NumWithError LOG10(NumWithError a){
        double resultTemp = Math.log10(a.getNum()),
                   errorTemp = Math.log10(a.getNum()+a.getError())-resultTemp;
        
            NumWithError result = new NumWithError(resultTemp, errorTemp);
        
            return result;
    }
    
    /**
     * take the sine of a in radians
     * @param a
     * @return 
     */
    public static final NumWithError SINE(NumWithError a){
        double resultTemp = Math.sin(a.getNum()),
                   errorTemp = Math.sin(a.getNum()+a.getError())-resultTemp;
        
            NumWithError result = new NumWithError(resultTemp, errorTemp);
        
            return result;
    }
    
    /**
     * take the cosine of a in radians
     * @param a
     * @return 
     */
    public static final NumWithError COSINE(NumWithError a){
        double resultTemp = Math.cos(a.getNum()),
                   errorTemp = Math.cos(a.getNum()+a.getError())-resultTemp;
        
            NumWithError result = new NumWithError(resultTemp, errorTemp);
        
            return result;
    }
    
    /**
     * take the tangent of a in radians
     * @param a
     * @return 
     */
    public static final NumWithError TANGENT(NumWithError a){
        double resultTemp = Math.tan(a.getNum()),
                   errorTemp = Math.tan(a.getNum()+a.getError())-resultTemp;
        
            NumWithError result = new NumWithError(resultTemp, errorTemp);
        
            return result;
    }
    
}
