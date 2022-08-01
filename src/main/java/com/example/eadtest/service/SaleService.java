package com.example.eadtest.service;

import com.example.eadtest.entity.Sale;
import com.example.eadtest.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleService {
    final SaleRepository saleRepository;
    public Page<Sale> findAll(int page, int limit, String sortBy) {
        return saleRepository.findAll(PageRequest.of(page -1, limit));
    }
    public Optional<Sale> findById(long id){return saleRepository.findById(String.valueOf(id));}
}
