package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품수정() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;
        final UpdateProductRequest request = ProductSteps.상품수정요청_생성();

        productService.updateProduct(productId, request);

        final ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        final GetProductResponse productResponse = response.getBody();
        assertThat(productResponse.name()).isEqualTo("상품 수정");
        assertThat(productResponse.price()).isEqualTo(2000);

    }


//    private static class StubProductPort implements ProductPort {
//        public Product getProduct_will_return;
//
//        @Override
//        public void save(final Product product) {
//
//        }
//
//        @Override
//        public Product getProduct(final Long productId) {
//            return getProduct_will_return;
//        }
//    }
}
