package com.demo.fruitsapp;

import com.demo.fruitsapp.model.Fruit;
import com.demo.fruitsapp.model.dto.FruitDto;
import com.demo.fruitsapp.service.FruitService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FruitResource {

    @Autowired
    private final FruitService fruitService;

    @Autowired
    private ModelMapper modelMapper;

    public FruitResource(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/fruits")
    public List<FruitDto> getAllFruit() {
        List<Fruit> fruits = fruitService.getAllFruit();
        return fruits.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/fruits/{id}")
    public FruitDto getFruitById(@PathVariable("id") Long id) {
        return convertToDto(fruitService.getFruitById(id));
    }

    @PostMapping("/fruits")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public FruitDto addFruit(@RequestBody FruitDto fruitDto) throws ParseException {
        Fruit fruit = convertToEntity(fruitDto);
        Fruit fruitCreated = fruitService.addFruit(fruit);
        return convertToDto(fruitCreated);
    }

    @PutMapping("/fruits")
    @ResponseStatus(HttpStatus.OK)
    public FruitDto updateFruit(@RequestBody FruitDto fruitDto) throws ParseException {
        Fruit fruit = convertToEntity(fruitDto);
        fruitService.updateFruit(fruit);
        return fruitDto;
    }

    @DeleteMapping("/fruits/{id}")
    public void deleteFruit(@PathVariable("id") Long id) {
        fruitService.deleteFruit(id);
    }

    private FruitDto convertToDto(Fruit fruit) {
        FruitDto fruitDto = modelMapper.map(fruit, FruitDto.class);
        return fruitDto;
    }

    private Fruit convertToEntity(FruitDto fruitDto) throws ParseException {
        Fruit fruit = modelMapper.map(fruitDto, Fruit.class);
        return fruit;
    }

}
