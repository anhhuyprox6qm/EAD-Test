package com.example.eadtest.seeder;

import com.example.eadtest.entity.Product;
import com.example.eadtest.repository.ProductRepository;
import com.example.eadtest.util.NumberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductSeeder {
    private static final int NUMBER_OF_PRODUCTS = 100;
    public static List<Product> productList = new ArrayList<>();
    final ProductRepository productRepository;
    public void generate() {
        Faker faker = new Faker();
        for (int i = 0; i < NUMBER_OF_PRODUCTS; i++
        ) {
            Product product = Product.builder()
                    .name(faker.name().title())
                    .dateOfManf(LocalDateTime.now().minusDays(NumberUtil.getRandomNumber(1, 30)))
                    .description(faker.weather().description())
                    .price(NumberUtil.getRandomNumber(100000, 1000000))
                    .build();
            productList.add(product);
        }
        productRepository.saveAll(productList)
    }
}
