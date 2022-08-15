package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entites.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>("Data listelendi", productDao.findAll());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort=Sort.by(Sort.Direction.DESC,"productName");

        return new SuccessDataResult<List<Product>>("Data listelendi", productDao.findAll(sort));
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("Urun Eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String name) {
        return new SuccessDataResult<Product>("Data Geldi",
                productDao.getByProductName(name));
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String name, int id) {
        return new SuccessDataResult<Product>("Data Geldi",
                productDao.getByProductNameAndCategory_CategoryId(name, id));
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String name, int id) {
        return new SuccessDataResult<List<Product>>("Data listelendi",
                productDao.getByProductNameOrCategory_CategoryId(name, id));
    }

    @Override
    public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>("Data listelendi",
                productDao.getByCategory_CategoryIdIn(categories));
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>("Data listelendi",
                productDao.getByProductNameContains(productName));
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>("Data listelendi",
                productDao.getByProductNameStartsWith(productName));
    }

    @Override
    public DataResult<List<Product>> getByProductNameEndsWith(String productName) {
        return new SuccessDataResult<List<Product>>("Data listelendi",
                productDao.getByProductNameEndsWith(productName));
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String name, int id) {
        return new SuccessDataResult<List<Product>>("Data listelendi",
                productDao.getByNameAndCategory(name, id));
    }


}
