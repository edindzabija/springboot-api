package com.demo.fruitsapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.demo.fruitsapp.model.Fruit;
import com.demo.fruitsapp.model.dto.FruitDto;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

public class FruitDtoUnitTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertFruitEntityToFruitDto() {
        Fruit fruit = new Fruit();
        fruit.setId(1L);
        fruit.setName("testFruit");
        fruit.setDescription("test description");

        FruitDto fruitDto = modelMapper.map(fruit, FruitDto.class);
        assertEquals(fruit.getId(), fruitDto.getId());
        assertEquals(fruit.getName(), fruitDto.getName());
        assertEquals(fruit.getDescription(), fruitDto.getDescription());
    }

    @Test
    public void whenConvertFruitDtoToEntity() {
        FruitDto fruitDto = new FruitDto();
        fruitDto.setId(1L);
        fruitDto.setName("Test Fruit");
        fruitDto.setDescription("Test Description");

        Fruit fruit = modelMapper.map(fruitDto, Fruit.class);
        assertEquals(fruitDto.getId(), fruit.getId());
        assertEquals(fruitDto.getName(), fruit.getName());
        assertEquals(fruitDto.getDescription(), fruit.getDescription());

    }

}
