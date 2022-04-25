package com.example.springrss.repository;

import com.example.springrss.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByTitleContaining(String title);

}
