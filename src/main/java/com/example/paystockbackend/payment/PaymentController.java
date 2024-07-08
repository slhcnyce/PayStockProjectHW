package com.example.paystockbackend.payment;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paystockbackend.model.StatusModel;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public StatusModel makePayment(@RequestBody PaymentDto payment) {

        return paymentService.updateProduct(payment);

    }

    @GetMapping("/{renterCode}")
    public Optional<PaymentEntity> getPaymentByRenterCode(@PathVariable Long renterCode) {

        return paymentService.getPaymentByRenterCode(renterCode);
    }
}
