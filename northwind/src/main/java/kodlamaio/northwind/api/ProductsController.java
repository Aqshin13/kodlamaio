package kodlamaio.northwind.api;


import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entites.concretes.Product;
import kodlamaio.northwind.entites.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductService productService;


    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }


    @PostMapping("add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam("name") String name) {
        return productService.getByProductName(name);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam("id") int id,
                                                          @RequestParam("name") String name) {
        return productService.getByNameAndCategory(name, id);
    }

    @GetMapping("/getByProductNameAndCategory")
    public DataResult<Product> getByProductNameAndCategory(@RequestParam("id") int id,
                                                           @RequestParam("name") String name) {
        return productService.getByProductNameAndCategory_CategoryId(name, id);
    }


    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam("name") String name) {
        return productService.getByProductNameContains(name);
    }

    @GetMapping("getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

        return productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllDesc")
    DataResult<List<Product>> getAllSorted(){
        return productService.getAllSorted();
    }



    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return productService.getProductWithCategoryDetails();
    }
}
