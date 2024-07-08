package com.example.paystockbackend.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paystockbackend.model.StatusModel;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public StatusModel createProduct(@RequestBody ProductDetail productDetails) {
        System.out.println("create Product");
        System.out.println(productDetails.getRenterCode());
        System.out.println(productDetails);
        return productService.createProduct(productDetails.getRenterCode(), productDetails);
    }

    // Update and Delete methods can be implemented similarly

    @GetMapping("/{renterCode}")
    public ProductDto getProductByRenterCode(@PathVariable Long renterCode) {

        return productService.getProductByRenterCode(renterCode);
    }

    @PostMapping("/makePayment")
    public StatusModel makePayment(@RequestBody ProductDetail productDetails) {
        System.out.println("create Product");
        System.out.println(productDetails.getRenterCode());
        System.out.println(productDetails);
        return productService.createProduct(productDetails.getRenterCode(), productDetails);
    }
}