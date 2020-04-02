package unit;

import Data.Bug;
import Data.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BugTest {

    private Assertions Assert;

    @Test
    public void testAddBug(){
        Bug b = new Bug();
        Assert.assertEquals(b.addBug(1,1,"test bug"), true);
    }
}