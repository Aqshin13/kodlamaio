package kodlamaio.northwind.entites.dtos;


import kodlamaio.northwind.entites.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithCategoryDto {
    private int id;
    private String productName;
    private String categoryName;

}
