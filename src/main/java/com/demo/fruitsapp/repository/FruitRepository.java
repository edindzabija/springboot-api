package com.demo.fruitsapp.repository;

import com.demo.fruitsapp.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    public List<Fruit> findAllByOrderByIdAsc();

    Optional<Fruit> findFruitById(Long id);

    void deleteFruitById(Long id);

}
