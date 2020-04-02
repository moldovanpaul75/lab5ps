package unit;

import Data.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {


    private Assertions Assert;

    @Test
    public void test(){
        Employee e = new Employee();
        Assert.assertEquals(e.getEmployeesbyId(1), "Mircea Peia");
    }
}