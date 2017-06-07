package app.manager.controller;

import app.model.DataGridResult;
import app.model.TaoTaoResult;
import app.pojo.Item;
import app.manager.service.ItemService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public TaoTaoResult saveItem(Item item,String desc,String itemParams) throws IOException, SolrServerException {
        return itemService.insertItem(item, desc,itemParams);
    }

}
