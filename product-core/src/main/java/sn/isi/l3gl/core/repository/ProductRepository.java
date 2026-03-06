package sn.isi.l3gl.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.l3gl.core.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
