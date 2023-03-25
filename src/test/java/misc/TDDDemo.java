package misc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TDDDemo {


    @Test
    public void testDivide(){
        Operations operations = new Operations();
        int result = operations.divide(10,2);
        Assert.assertEquals(result,5);
    }

    @Test (expectedExceptions = ArithmeticException.class)
    public void testDivide2(){
        Operations operations = new Operations();
        int result = operations.divide(10,0);

    }

}
