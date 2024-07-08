
package com.example.paystockbackend.product;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductDto {

    @Id
    @Column(nullable = false, unique = true)
    private Long renterCode;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductDetail> productDetails = new ArrayList<>();

    public Long getRenterCode() {
        return renterCode;
    }

    public void setRenterCode(Long renterCode) {
        this.renterCode = renterCode;
    }

    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void addProductDetail(ProductDetail productDetails) {

        this.productDetails.add(productDetails);
    }

    public void removeByProductCode(String productCode) {
        this.productDetails.removeIf(product -> product.getProductCode() == productCode);
    }

    public void setProductDetails(List<ProductDetail> details) {
        this.productDetails = details;
    }

}
