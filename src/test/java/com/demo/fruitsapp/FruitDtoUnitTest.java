package com.demo.fruitsapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.demo.fruitsapp.model.Fruit;
import com.demo.fruitsapp.model.dto.FruitDto;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

public class FruitDtoUnitTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertFruitEntityToFruitDto_thenCorrect() {
        Fruit fruit = new Fruit();
        fruit.setId(1L);
        fruit.setName("testFruit");
        fruit.setDescription("test description");

        FruitDto fruitDto = modelMapper.map(fruit, FruitDto.class);
        assertEquals(fruit.getId(), fruitDto.getId());
        assertEquals(fruit.getName(), fruitDto.getName());
        assertEquals(fruit.getDescription(), fruitDto.getDescription());
    }

}
