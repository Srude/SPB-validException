package com.spb.validException.service;

import com.spb.validException.data.dto.ProductDTO;
import com.spb.validException.data.dto.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO getProduct(Long number);
    ProductResponseDTO saveProduct(ProductDTO productDTO);
    ProductResponseDTO changeProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
