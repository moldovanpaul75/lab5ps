import Data.Bug;
import Data.Employee;
import Data.Product;

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.getEmployees();


        Product p = new Product();
        p.addProduct("product3", "product3");
        p.deleteProduct(2);
        p.updateProduct(1, "product45", "this is product 45");
        p.getProducts();

        Bug b = new Bug();
        b.getBugs();
    }
}
