package com.example.springrss.service;

import com.example.springrss.model.Item;
import com.example.springrss.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private  final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item updateItem(Item item){
        return itemRepository.save(item);
    }

}
