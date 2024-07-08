package com.example.paystockbackend.product;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.paystockbackend.model.StatusModel;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public StatusModel createProduct(Long renterCode, ProductDetail productDetails) {
        try {
            ProductDto product = getProductByRenterCode(renterCode);
            if (product != null) {
                var productList = product.getProductDetails();
                var isExist = false;
                for (int i = 0; i < productList.size(); i++) {
                    isExist = productList.get(i).getProductCode().equals(productDetails.getProductCode());
                }
                if (isExist) {
                    for (int i = 0; i < productList.size(); i++) {
                        if (productList.get(i).getProductCode().equals(productDetails.getProductCode())) {
                            productList.set(i, productDetails);

                            break; // Stop searching once found and replaced
                        }
                    }
                } else {
                    productList.add(productDetails);
                }

                productRepository.save(product);
                return new StatusModel(true);
            } else {
                ProductDto newProduct = new ProductDto();
                newProduct.setRenterCode(renterCode);
                newProduct.addProductDetail(productDetails);
                productRepository.save(newProduct);
                return new StatusModel(true);
            }
        } catch (DataIntegrityViolationException e) {
            // Handle specific exception for data integrity violation (e.g., unique
            // constraint violation)
            // You can log the exception or return an appropriate response/status here
            e.printStackTrace(); // Example: Print the stack trace
            return new StatusModel(false);
        } catch (Exception e) {
            // Handle generic exception
            e.printStackTrace();
            return new StatusModel(false);
        }
    }

    public ProductDto getProductByRenterCode(Long renterCode) {
        try {
            return productRepository.findById(renterCode).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteProduct(Long renterCode) {
        try {
            productRepository.deleteById(renterCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Long renterCode, ProductDetail productDetails) {
        ProductDto product = getProductByRenterCode(renterCode);
        if (product != null) {
            var productList = product.getProductDetails();
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductCode().equals(productDetails.getProductCode())) {
                    productList.set(i, productDetails);

                    break; // Stop searching once found and replaced
                }
            }
            productRepository.save(product);

        }
    }
}