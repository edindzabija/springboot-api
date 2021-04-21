package com.demo.fruitsapp.config;

import java.util.List;

import com.demo.fruitsapp.model.Fruit;
import com.demo.fruitsapp.repository.FruitRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FruitConfig {

    @Bean
    CommandLineRunner commandLineRunner(FruitRepository fruitRepository) {

        return args -> {
            Fruit apple = new Fruit("Apple", "appledesc", "secret");
            Fruit strawberry = new Fruit("Strawberry", "strawberry description", "secret");
            Fruit banana = new Fruit("Banana", "strawberry description", "secret");
            fruitRepository.saveAll(List.of(apple, strawberry, banana));
        };

    }
}
