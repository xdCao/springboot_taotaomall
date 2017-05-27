package app.controller;

import app.model.DataGridResult;
import app.model.TaoTaoResult;
import app.pojo.Item;
import app.service.ItemService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    public TaoTaoResult saveItem(Item item,String desc){
        return itemService.insertItem(item, desc);
    }

}
