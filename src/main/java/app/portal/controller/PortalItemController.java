package app.portal.controller;

import app.manager.service.ItemParamItemService;
import app.manager.service.ItemParamService;
import app.manager.service.ItemService;
import app.model.TaoTaoResult;
import app.pojo.Item;
import app.pojo.ItemDesc;
import app.pojo.ItemParam;
import app.pojo.ItemParamItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xdcao on 2017/6/7.
 */
@Controller
@RequestMapping(value = "/portal/item")
public class PortalItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemParamItemService itemParamItemService;



    @RequestMapping(value = "/{itemId}")
    public ModelAndView showItemInfo(@PathVariable Long itemId) throws IOException {
        Item item=itemService.getItemBaseById(itemId);
//        if (item!=null){
//            return new TaoTaoResult(200,"ok",item);
//        }else {
//            return new TaoTaoResult(200,"ok",null);
//        }
        ItemDesc itemDesc=itemService.getItemDescById(itemId);

        ItemParamItem itemParamItem= itemParamItemService.getItemParamItemByItemId(itemId);

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("item",item);
        map.put("itemDesc",itemDesc);
        map.put("itemParamItem",itemParamItem);

        ModelAndView modelAndView=new ModelAndView("portal/item",map);
        return modelAndView;
    }

    @RequestMapping(value = "/desc/{itemId}")
    @ResponseBody
    public ItemDesc getItemDesc(@PathVariable Long itemId){
        ItemDesc itemDesc= itemService.getItemDescById(itemId);
        return itemDesc;
    }


}
