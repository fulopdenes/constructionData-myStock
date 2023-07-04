package com.constructionData.myStock.service;

import com.constructionData.myStock.model.DTO.ProductDTO;
import com.constructionData.myStock.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceUnitTest {
    @Mock
    private ProductRepository mockProductRepository;

    private ProductService mockProductService;

    private List<ProductDTO> mockProductList;

    @BeforeEach
    void setUp_beforeEach() {

        // create Mock
        MockitoAnnotations.openMocks(this);

        mockProductService = new ProductService(mockProductRepository);

        ProductDTO newProduct1 = ProductDTO.builder()
                .relatedUnit("1")
                .categoryType("string")
                .quantityType("string")
                .productTechCode("string")
                .deliveryType("string")
                .roomNameOfInstallation("string")
                .roomPlanCode("string")
                .timeOfOrder(LocalDateTime.now())
                .deliveryNoteId("string")
                .timeOfArrivedAtSite(LocalDateTime.now())
                .placeOfStorage("string")
                .timeOfInstalled(LocalDateTime.now())
                .build();

        ProductDTO newProduct2 = ProductDTO.builder()
                .relatedUnit("1")
                .categoryType("string")
                .quantityType("string")
                .productTechCode("string")
                .deliveryType("string")
                .roomNameOfInstallation("string")
                .roomPlanCode("string")
                .timeOfOrder(LocalDateTime.now())
                .deliveryNoteId("string")
                .timeOfArrivedAtSite(LocalDateTime.now())
                .placeOfStorage("string")
                .timeOfInstalled(LocalDateTime.now())
                .build();


        this.mockProductList = new ArrayList<>();
        this.mockProductList.add(newProduct1);
        this.mockProductList.add(newProduct2);


    }
    @Test
    void getAllProducts() {
        when(mockProductService.getAllProducts()).thenReturn(mockProductList);
        assertEquals(mockProductList, mockProductService.getAllProducts());
    }

    @Test
    void getProductById() {
        when(mockProductRepository.findById(1L)).thenReturn(Optional.ofNullable(mockProductList.get(0)));
        assertEquals(mockProductList.get(0), mockProductService.getProductById(1L));
    }

    @Test
    public void testDeleteProduct_DeletionSuccessful() {
        // Mock data
        Long productId = 1L;

        // Mock the productRepository.findById(id) method
        ProductDTO product = new ProductDTO();
        when(mockProductRepository.findById(productId)).thenReturn(Optional.of(product));

        // Perform the deleteProduct operation
        boolean isDeleted = mockProductService.deleteProduct(productId);

        // Verify the productRepository methods were called correctly
        verify(mockProductRepository, times(1)).findById(productId);
        verify(mockProductRepository, times(1)).deleteById(productId);

        // Verify the deletion was successful
        assertTrue(isDeleted);
    }

    @Test
    public void testDeleteProduct_DeletionFailed() {
        // Mock data
        Long productId = 1L;

        // Mock the productRepository.findById(id) method to return an empty Optional
        when(mockProductRepository.findById(productId)).thenReturn(Optional.empty());

        // Perform the deleteProduct operation
        boolean isDeleted = mockProductService.deleteProduct(productId);

        // Verify the productRepository methods were called correctly
        verify(mockProductRepository, times(1)).findById(productId);
        verify(mockProductRepository, never()).deleteById(productId);

        // Verify the deletion failed
        assertFalse(isDeleted);
    }

    @Test
    public void testCreateProduct_ReturnsCreatedProduct() {
        // Mock data
        ProductDTO newProduct = ProductDTO.builder()
                .productName("string")
                .relatedUnit("1")
                .categoryType("string")
                .quantityType("string")
                .productTechCode("string")
                .deliveryType("string")
                .roomNameOfInstallation("string")
                .roomPlanCode("string")
                .timeOfOrder(LocalDateTime.now())
                .deliveryNoteId("string")
                .timeOfArrivedAtSite(LocalDateTime.now())
                .placeOfStorage("string")
                .timeOfInstalled(LocalDateTime.now())
                .build();

        newProduct.setProductName("Test Product");
        newProduct.setProductTechCode("ABC123");
        // Set other properties of newProduct...

        // Mock the productRepository.save(createdNewProduct) method
        ProductDTO createdProduct = mockProductList.get(1);
        when(mockProductRepository.save(any(ProductDTO.class))).thenReturn(createdProduct);

        // Perform the createProduct operation
        ProductDTO result = mockProductService.createProduct(newProduct);

        // Verify the productRepository.save() method was called correctly
        verify(mockProductRepository, times(1)).save(any(ProductDTO.class));

        // Verify the result
        assertNotNull(result);
        assertEquals(createdProduct, result);
    }

    @Test
    public void testUpdateProduct_ReturnsUpdatedProduct() {
        // Mock data
        ProductDTO existingProduct = mockProductList.get(1);
        existingProduct.setProductName("Existing Product");
        existingProduct.setQuantity(10.0);
        // Set other properties as needed for testing

        ProductDTO newProduct = ProductDTO.builder()
                .productName("string")
                .relatedUnit("2")
                .categoryType("string")
                .quantity(0.0)
                .quantityType("string")
                .productTechCode("string")
                .deliveryType("string")
                .roomNameOfInstallation("string")
                .roomPlanCode("string")
                .timeOfOrder(LocalDateTime.now())
                .deliveryNoteId("string")
                .timeOfArrivedAtSite(LocalDateTime.now())
                .placeOfStorage("string")
                .timeOfInstalled(LocalDateTime.now())
                .build();

        newProduct.setProductName("Updated Product");
        newProduct.setQuantity(20.0);
        // Set other properties as needed for testing

        // Mock the productRepository.save() method
        ProductDTO savedProduct = mockProductList.get(1);
        when(mockProductRepository.save(any(ProductDTO.class))).thenReturn(savedProduct);

        // Perform the updateProduct operation
        ProductDTO updatedProduct = mockProductService.updateProduct(existingProduct, newProduct);

        // Verify the productRepository.save() method was called with the existing product
        verify(mockProductRepository, times(1)).save(existingProduct);

        // Verify the updated product has the expected values
        assertEquals(newProduct.getProductName(), updatedProduct.getProductName());
        assertEquals(newProduct.getQuantity(), updatedProduct.getQuantity());
        // Verify other properties as needed

        // Verify the lastTimeOfModified property is set to the current time
        assertEquals(LocalDateTime.now().getMinute(), updatedProduct.getLastTimeOfModified().getMinute());

        // Verify the returned product is the same as the saved product
        assertEquals(savedProduct, updatedProduct);
    }
}