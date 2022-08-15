package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entites.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {


    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAllSorted();


    DataResult<List<Product>> getAll(int pageNo,int pageSize);


    Result add(Product product);

    DataResult<Product> getByProductName(String name);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String name, int id);

    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String name, int id);

    DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByProductNameEndsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String name, int id);
}
