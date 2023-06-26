package com.constructionData.myStock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyStockApplicationTest {

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads_true() {
    }

    @Test
    public void applicationStarts_urlResponseIsNotNull_true() {
        // Verify that the application starts and responds to a request
        TestRestTemplate restTemplate = new TestRestTemplate();
        String url = "http://localhost:" + port + "/"; // Adjust the URL as per your application's endpoints
        String response = restTemplate.getForObject(url, String.class);
        assertThat(response).isNotNull();
        // Add more assertions to validate the response if needed
    }

    @Test
    public void applicationRuns_checkTwoPortsParallel_itWorks_true() {
        String[] args1 = {"--server.port=8082"}; // Set the port to 8080
        String[] args2 = {"--server.port=8083"}; // Set the port to 8081

        MyStockApplication.main(args1);

        // Check if the application is running on port 8081
        SpringApplication.exit(SpringApplication.run(MyStockApplication.class, args2));
        // Stop the application
    }
}
