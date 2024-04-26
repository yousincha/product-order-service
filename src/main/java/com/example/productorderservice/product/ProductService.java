package com.example.productorderservice.product;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
class ProductService {
    private final ProductPort productPort;

    ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Transactional
    public void addProduct(final AddProductRequest request){
        final Product product = new Product(request.name(),request.price(), request.discountPolicy());

        productPort.save(product);
    }
}
