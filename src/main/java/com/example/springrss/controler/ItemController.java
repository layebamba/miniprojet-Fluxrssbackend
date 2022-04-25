package com.example.springrss.controler;


import com.example.springrss.model.Item;
import com.example.springrss.repository.ItemRepository;
import com.example.springrss.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
@Autowired
     ItemRepository repository;

private  final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems( String title) {

        try {
            List<Item> items = new ArrayList<Item>();
            if (title == null)
                repository.findAll().forEach(items::add);
            else
                repository.findByTitleContaining(title).forEach(items::add);
            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    //methodes/////


    @PostMapping()
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        try {
            Item _item = repository
                    .save(new Item(
                            item.getTitle(),
                            item.getPubdate(),
                            item.getDescription(),
                            item.getGuid(),
                            item.getLink(),
                            item.getContent(),

                            item.getCredit()));
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    ////put method


    @PutMapping("/update")
    public ResponseEntity<Item> updateItem( @RequestBody Item item) {

        Item UpdateItem = itemService.updateItem(item);
        return new ResponseEntity<>(UpdateItem,HttpStatus.OK);

    }




}
