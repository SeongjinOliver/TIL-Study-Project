package com.example.jpashoporder.service;

import com.example.jpashoporder.domain.item.Book;
import com.example.jpashoporder.domain.item.Item;
import com.example.jpashoporder.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        //변경감지에 의해서 데이터를 변경하는 방법
        Item findItem = itemRepository.findOne(itemId); // 영속상태
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
        //커밋을 하면서 flush를 날림
    }

    @Transactional
    public Item updateMergeItem(Long itemId, Book param) {
        //변경감지에 의해서 데이터를 변경하는 방법
        Item findItem = itemRepository.findOne(itemId); // 영속상태
        findItem.setPrice(param.getPrice());
        findItem.setName(param.getName());
        findItem.setStockQuantity(param.getStockQuantity());
        //커밋을 하면서 flush를 날림
        return findItem; //merge를 했으니까 영속성 컨텍스트에서 관리되는 객체
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
