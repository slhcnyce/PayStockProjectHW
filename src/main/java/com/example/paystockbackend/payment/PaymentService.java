package com.example.paystockbackend.payment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.paystockbackend.model.StatusModel;
import com.example.paystockbackend.product.ProductDetail;
import com.example.paystockbackend.product.ProductDto;
import com.example.paystockbackend.product.ProductRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final ProductRepository productRepository;

    public PaymentService(PaymentRepository paymentRepository, ProductRepository productRepository) {
        this.paymentRepository = paymentRepository;
        this.productRepository = productRepository;
    }

    public void deleteProduct(Long renterCode) {
        try {
            paymentRepository.deleteById(renterCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StatusModel updateProduct(PaymentDto paymentDto) {
        ProductDto product = getProductByRenterCode(paymentDto.getRenterCode());
        if (product != null) {

            var paymentRepo = paymentRepository.findByRenterCode(paymentDto.getRenterCode());
            if (paymentRepo == null) {
                paymentRepo = new PaymentEntity();
                paymentRepo.setRenterCode(paymentDto.getRenterCode());
            }

            PaymentListDto paymentListDto = new PaymentListDto(paymentDto.getDate(), paymentDto.getPrice());
            paymentRepo.addPaymentDetail(paymentListDto);
            paymentRepository.save(paymentRepo);

            updateProductDetailById(paymentDto);
            return new StatusModel(true);

        }
        return new StatusModel(false);
    }

    public ProductDto getProductByRenterCode(Long renterCode) {
        try {
            return productRepository.findById(renterCode).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteProductById(Long renterCode, String productCode) {
        ProductDto product = productRepository.findByRenterCode(renterCode);
        if (product != null) {
            product.removeByProductCode(productCode);

        }
    }

    public void updateProductDetailById(PaymentDto paymentDto) {
        ProductDto product = productRepository.findByRenterCode(paymentDto.getRenterCode());
        Map<String, ProductDetail> newDetailsMap = new HashMap<>();
        for (ProductDetail detail : paymentDto.getProductDetails()) {
            newDetailsMap.put(detail.getProductCode(), detail);
        }

        // Update product quantities
        for (ProductDetail existingDetail : product.getProductDetails()) {
            ProductDetail newDetail = newDetailsMap.get(existingDetail.getProductCode());
            if (newDetail != null) {
                var quantity = existingDetail.getProductQuantity() - newDetail.getProductQuantity();
                if (quantity == 0) {
                    deleteProductById(existingDetail.getRenterCode(), existingDetail.getProductCode());
                } else {
                    existingDetail.setProductQuantity(quantity);
                }

            }
        }

        // Save the updated product details
        productRepository.save(product);

    }

    public Optional<PaymentEntity> getPaymentByRenterCode(Long renterCode) {

        try {
            return paymentRepository.findById(renterCode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
