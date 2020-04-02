package unit;

import Data.Employee;
import Data.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Assertions Assert;

    @Test
    public void testGetProductById(){
        Product p = new Product();
        Assert.assertEquals(p.getProductbyId(1), "product1 product1");
    }

    @Test
    public void testAddProduct(){
        Product p = new Product();
        Assert.assertEquals(p.addProduct("testproduct", "testproduct"), true);
    }

    @Test
    public void testUpdateProduct(){
        Product p = new Product();
        Assert.assertEquals(p.updateProduct(1, "product1", "product1"), true);
    }

    @Test
    public void testDeleteProduct(){
        Product p = new Product();
        Assert.assertEquals(p.deleteProduct(3), true);
    }




}