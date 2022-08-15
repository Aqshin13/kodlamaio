package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entites.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    Product getByProductName(String name);

    Product getByProductNameAndCategory_CategoryId(String name,int id);

    List<Product> getByProductNameOrCategory_CategoryId(String name, int id);

    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);


    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    List<Product> getByProductNameEndsWith(String productName);


    @Query(" from Product where productName=:productName and category.categoryId=:id")
    List<Product> getByNameAndCategory(@Param("productName") String name, @Param("id") int id);

}
