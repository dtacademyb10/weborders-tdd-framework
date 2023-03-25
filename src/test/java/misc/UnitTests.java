package misc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {


    @Test
    public void testAdd1(){
        Operations operations = new Operations();
        int result = operations.add(2,3);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void testAdd2(){
        Operations operations = new Operations();
        int result = operations.add(0,-2);
        Assert.assertEquals(result, -2);
    }
}
