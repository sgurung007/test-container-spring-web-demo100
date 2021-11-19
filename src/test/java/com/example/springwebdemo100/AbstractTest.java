package com.example.springwebdemo100;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
public class AbstractTest {

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer()
            .withUsername("root")
            .withPassword("root")
            .withDatabaseName("test");

    @BeforeAll
    public static void setup() {
        container.start();
    }

    @AfterAll
    public static void shutdown() {
        container.stop();
    }

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spirng.datasource.password", container::getPassword);
        registry.add("spirng.datasource.username", container::getUsername);
    }


}
