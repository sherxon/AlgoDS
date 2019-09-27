import org.junit.Assert;
import org.junit.Test;
// White Box Testing
public class TestingJunit {
    First first =new First();

    // Test  if (a == null || a.length == 0)
    @Test
    public void TestFirst1(){
        Assert.assertEquals(0,first.solution(null));
    }

    // Test  if (a == null || a.length == 0)
    @Test
    public void TestFirst2(){
        Assert.assertEquals(0,first.solution([]));
    }

    // Test if (a.length == 1)
    @Test
    public void TestFirst3(){
        Assert.assertEquals(1,first.solution([{1,1}]);
    }

    // Test for and if
    @Test
    public void TestFirst4(){
        Assert.assertEquals(4,first.solution([{1,1},{-1,1},{-1,-1},{1,-1}]));
    }

    // Test seta.add
    @Test
    public void TestFirst5(){
        Assert.assertEquals(2,first.solution([{1,1},{4,4},{1,4}]));
    }

    // Test setb.add
    @Test
    public void TestFirst6(){
        Assert.assertEquals(2,first.solution([{-1,1},{-4,4},{-1,4}]));
    }

    // Test setc.add
    @Test
    public void TestFirst7(){
        Assert.assertEquals(2,first.solution([{-1,-1},{-4,-4},{-1,-4}]));
    }

    // Test setd.add
    @Test
    public void TestFirst8(){
        Assert.assertEquals(2,first.solution([{1,-1},{4,-4},{1,-4}]));
    }
}