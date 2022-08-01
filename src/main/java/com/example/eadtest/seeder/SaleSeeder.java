package com.example.eadtest.seeder;

import com.example.eadtest.entity.Sale;
import com.example.eadtest.repository.SaleRepository;
import com.example.eadtest.util.NumberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SaleSeeder {
    private static final int NUMBER_OF_SALES = 100;
    public static List<Sale> saleList = new ArrayList<>();
    final SaleRepository saleRepository;
    public void generate(){
        Faker faker = new Faker();
        int maxIndexOfProducts = ProductSeeder.productList.size() -1;
        int minIndexOfProducts = 0;
        for (int i = 0; i < NUMBER_OF_SALES; i++
        ) {
            Sale product = Sale.builder()
                    .salesmanName(faker.name().fullName())
                    .dos(faker.cat().name())
                    .salesmanID(UUID.randomUUID().toString())
                    .product(ProductSeeder.productList.get(NumberUtil.getRandomNumber(minIndexOfProducts, maxIndexOfProducts)))
                    .build();
            saleList.add(product);
        }
        saleRepository.saveAll(saleList);
    }
}
