package kodlamaio.northwind.dataAccess.concretes;

import kodlamaio.northwind.entites.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}