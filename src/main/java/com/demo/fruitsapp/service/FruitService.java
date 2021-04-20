package com.demo.fruitsapp.service;

import com.demo.fruitsapp.exception.FruitNotFoundException;
import com.demo.fruitsapp.model.Fruit;
import com.demo.fruitsapp.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    @Autowired
    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public List<Fruit> getAllFruit() {
        return fruitRepository.findAllByOrderByIdAsc();
    }

    public Fruit updateFruit(Fruit fruit) {
        Fruit existingFruit = fruitRepository.findById(fruit.getId()).orElse(null);

        if (existingFruit == null) {
            throw new FruitNotFoundException("Fruit does not exist");
        }
        if (fruit.getName() != null) {
            existingFruit.setName(fruit.getName());

        }
        if (fruit.getDescription() != null) {
            existingFruit.setDescription(fruit.getDescription());
        }
        return fruitRepository.save(existingFruit);
    }

    public Fruit getFruitById(Long id) {
        return fruitRepository.findFruitById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit by id: " + id + " was not found!"));
    }

    public void deleteFruit(Long id) {
        boolean exists = fruitRepository.existsById(id);
        if (!exists) {
            throw new FruitNotFoundException("Fruit with id: " + id + " does not exist");
        }
        fruitRepository.deleteById(id);
    }

}
