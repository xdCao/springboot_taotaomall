package app.controller;

import app.model.DataGridResult;
import app.pojo.Item;
import app.service.ItemService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xdcao on 2017/5/23.
 */
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{itemId}")
    public Item getOneItem(@PathVariable long itemId){
        return itemService.getItemById(itemId);
    }

    @RequestMapping(value = "/item/list")
    public DataGridResult getItemListByPage(@RequestParam Integer page,@RequestParam Integer rows){
        return itemService.getItemListByPage(page,rows);
    }

}
