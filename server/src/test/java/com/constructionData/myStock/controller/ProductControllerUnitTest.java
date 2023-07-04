package com.constructionData.myStock.controller;

import com.constructionData.myStock.model.DTO.ProductDTO;
import com.constructionData.myStock.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductControllerUnitTest {

    @Mock
    private ProductService productService;
    private ProductController productController;
    private List<ProductDTO> productList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productController = new ProductController(productService);

        ProductDTO product1 = ProductDTO.builder()
                .productTechCode("123")
                .categoryType("parketta")
                .productName("Tölgy-nature")
                .quantity(25.0)
                .quantityType("nm")
                .relatedUnit("19")
                .roomNameOfInstallation("nappali")
                .timeOfRecord(LocalDateTime.now())
                .build();

        ProductDTO product2 = ProductDTO.builder()
                .productTechCode("1234")
                .categoryType("parketta")
                .productName("Tölgy-nature")
                .quantity(20.0)
                .quantityType("nm")
                .relatedUnit("18")
                .roomNameOfInstallation("nappali")
                .timeOfRecord(LocalDateTime.now())
                .build();

        this.productList = new ArrayList<>();
        this.productList.add(product1);
        this.productList.add(product2);
    }
    @Test
    void getAllProducts_isProductAdded_productsListedSuccessfully() {
        when(productService.getAllProducts()).thenReturn(productList);
        assertEquals(productList, productController.getAllProducts());
    }

    @Test
    void findProductById_WithValidId_productFindSuccessfully() {
        // Mock the productService to return a valid product
        ProductDTO mockProduct = new ProductDTO();
        when(productService.getProductById(1L)).thenReturn(mockProduct);

        // Create the controller and call the method
        ProductController controller = new ProductController(productService);
        ResponseEntity<ProductDTO> response = controller.findProductById(1L);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertSame(mockProduct, response.getBody());

        // Verify that the productService method was called with the correct id
        verify(productService, times(1)).getProductById(1L);
    }

    @Test
    void findProductById_WithInvalidId_ShouldReturn_NotFOUND() {
        // Mock the productService to return null
        when(productService.getProductById(2L)).thenReturn(null);

        // Create the controller and call the method
        ProductController controller = new ProductController(productService);
        ResponseEntity<ProductDTO> response = controller.findProductById(2L);

        // Verify the response
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());

        // Verify that the productService method was called with the correct id
        verify(productService, times(1)).getProductById(2L);
    }

    @Test
    void createProduct_WithNullParameters_ShouldReturnBadRequest() {
        // Act
        ResponseEntity<?> response = productController.createProduct(null);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void createProduct_WithValidParameters_ShouldReturnCreated() {
        // Arrange
        ProductDTO newProduct = ProductDTO.builder()
                .buildingId("VII.")
                .relatedUnit("1")
                .categoryType("string")
                .productName("string")
                .quantity(2.0)
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

        // Act
        ResponseEntity<?> response = productController.createProduct(newProduct);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void createProduct_WithMissingTwoParameters_ShouldReturnBadRequestWithMessage() {
        // Arrange
        ProductDTO newProduct = ProductDTO.builder()
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

        // Act
        ResponseEntity<?> response = productController.createProduct(newProduct);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        String expectedErrorMessage = "Validation error: productName - must not be blank\n" +
                "Validation error: buildingId - must not be null\n" +
                "Validation error: quantity - must be greater than 0\n";

        String responseBody = (String) response.getBody();
        String[] expectedLines = expectedErrorMessage.split("\n");
        String[] actualLines = responseBody.split("\n");

        // Compare the lines in any order
        Arrays.sort(expectedLines);
        Arrays.sort(actualLines);

        assertEquals(Arrays.toString(expectedLines), Arrays.toString(actualLines));
    }

    @Test
    void createProduct_WithMissingSevenParameters_ReturnBadRequestWithMessage() {
        // Arrange
        ProductDTO newProduct = ProductDTO.builder()
                .deliveryType("string")
                .roomPlanCode("string")
                .timeOfOrder(LocalDateTime.now())
                .deliveryNoteId("string")
                .timeOfArrivedAtSite(LocalDateTime.now())
                .placeOfStorage("string")
                .timeOfInstalled(LocalDateTime.now())
                .build();

        // Act
        ResponseEntity<?> response = productController.createProduct(newProduct);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        String expectedErrorMessage = "Validation error: productName - must not be blank\n" +
                "Validation error: productTechCode - must not be blank\n" +
                "Validation error: roomNameOfInstallation - must not be blank\n" +
                "Validation error: quantity - must be greater than 0\n" +
                "Validation error: categoryType - must not be blank\n" +
                "Validation error: buildingId - must not be null\n" +
                "Validation error: relatedUnit - must not be null\n" +
                "Validation error: quantityType - must not be blank\n";

        String responseBody = (String) response.getBody();
        String[] expectedLines = expectedErrorMessage.split("\n");
        String[] actualLines = responseBody.split("\n");

        // Compare the lines in any order
        Arrays.sort(expectedLines);
        Arrays.sort(actualLines);

        assertEquals(Arrays.toString(expectedLines), Arrays.toString(actualLines));
    }

    @Test
    void updateProduct_ValidId_ReturnsUpdatedProduct() {
        // Arrange
        long productId = 1;
        ProductDTO updatedProduct = ProductDTO.builder().productName("Updated Product").quantity(10.99).build();
        // Set the fields of updatedProduct as required for the test

        ProductDTO existingProduct = ProductDTO.builder().productName("Existing Product").quantity(9.99).build();
        // Set the fields of existingProduct as required for the test

        ProductDTO updatedDatabaseProduct = ProductDTO.builder().productName("Updated Product").quantity(10.99).build();
        // Set the fields of updatedDatabaseProduct as required for the test

        when(productService.getProductById(productId)).thenReturn(existingProduct);
        when(productService.updateProduct(existingProduct, updatedProduct)).thenReturn(updatedDatabaseProduct);

        // Act
        ResponseEntity<ProductDTO> response = productController.updateProduct(productId, updatedProduct);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedDatabaseProduct, response.getBody());

        // Verify that the productService method was called with the correct parameters
        verify(productService, times(1)).getProductById(productId);
        verify(productService, times(1)).updateProduct(existingProduct, updatedProduct);
    }


    @Test
    void updateProduct_InvalidId_ReturnsNotFound() {
        // Arrange
        long invalidId = 100L;

        ProductDTO updatedProduct = ProductDTO.builder().productName("Updated Product").quantity(10.99).build();

        when(productService.getProductById(invalidId)).thenReturn(null);

        // Act
        ResponseEntity<ProductDTO> response = productController.updateProduct(invalidId, updatedProduct);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());

        // Verify that the productService method was called with the correct parameters
        verify(productService, times(1)).getProductById(invalidId);
        verify(productService, never()).updateProduct(any(), any());
    }

    @Test
    public void deleteProduct_WhenProductExists_ReturnsStatusOK()  {
        // Arrange
        Long productId = 1L;
        when(productService.deleteProduct(productId)).thenReturn(true);

        // Act
        ResponseEntity<Boolean> response = productController.deleteProduct(productId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(true, response.getBody());
        verify(productService, times(1)).deleteProduct(productId);
    }

    @Test
    public void deleteProduct_WhenProductDoesNotExist_ReturnsNotFound()  {
        // Arrange
        Long productId = 1L;
        when(productService.deleteProduct(productId)).thenReturn(false);

        // Act
        ResponseEntity<Boolean> response = productController.deleteProduct(productId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(false, response.getBody());
        verify(productService, times(1)).deleteProduct(productId);
    }
}