package com.constructionData.myStock;

import com.constructionData.myStock.model.Product;
import com.constructionData.myStock.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MyStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyStockApplication.class, args);

    }

    //TODO: dataGeneration should be better organized separate.

//    @Configuration
//    public static class WebConfig implements WebMvcConfigurer {
//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/**")
//                    .allowedOrigins("*")
//                    .allowedMethods("GET", "POST", "PUT", "DELETE");
//        }
//    }


//    @Bean
//    CommandLineRunner commandLineRunner2(ProductRepository productRepository) {
//        return (args) -> {
//            Product product1 = Product.builder()
//                    .productTechCode("123")
//                    .category("parketta")
//                    .productName("Tölgy-nature")
//                    .quantity(25.0)
//                    .quantityType("nm")
//                    .relatedUnit("19")
//                    .roomNameOfInstallation("nappali")
//                    .timeOfRecord(LocalDateTime.now())
//                    .build();
//            productRepository.save(product1);
//
//            Product product2 = Product.builder()
//                    .productTechCode("456")
//                    .category("csempe")
//                    .productName("Kerámia")
//                    .quantity(24.0)
//                    .quantityType("nm")
//                    .relatedUnit("18")
//                    .roomNameOfInstallation("fürdő")
//                    .timeOfRecord(LocalDateTime.now())
//                    .build();
//            productRepository.save(product2);
//
//            Product product3 = Product.builder()
//                    .productTechCode("789")
//                    .category("csaptelep")
//                    .productName("Monocomanda")
//                    .quantity(1.0)
//                    .quantityType("pc")
//                    .relatedUnit("17")
//                    .roomNameOfInstallation("fürdő-01")
//                    .timeOfRecord(LocalDateTime.now())
//                    .build();
//            productRepository.save(product3);
//
//            Product product4 = Product.builder()
//                    .productTechCode("Zumba BZA4")
//                    .category("Mosogató csaptelep")
//                    .productName("FERRO NOVASERVIS")
//                    .quantity(2.0)
//                    .quantityType("pc")
//                    .relatedUnit("20")
//                    .roomNameOfInstallation("nappali")
//                    .timeOfRecord(LocalDateTime.now())
//                    .build();
//            productRepository.save(product4);
//
//            Product product5 = Product.builder()
//                    .productTechCode("BSRV4-80 B SET")
//                    .category("zuhanykabin")
//                    .productName("Brilliant BSRV4")
//                    .quantity(2.0)
//                    .quantityType("pc")
//                    .relatedUnit("21")
//                    .roomNameOfInstallation("fürdő-nagy")
//                    .timeOfRecord(LocalDateTime.now())
//                    .build();
//            productRepository.save(product5);
//
//            Product product6 = Product.builder()
//                    .productTechCode("ONAS-190D040061406")
//                    .category("mosdószekrény")
//                    .productName("Onas Kim 40")
//                    .quantity(1.0)
//                    .quantityType("pc")
//                    .relatedUnit("21")
//                    .roomNameOfInstallation("fürdő-01")
//                    .timeOfRecord(LocalDateTime.now())
//                    .build();
//            productRepository.save(product6);
//        };
//
//    }

}

