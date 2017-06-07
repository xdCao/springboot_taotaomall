package app.portal.controller;

import app.manager.service.ItemService;
import app.model.TaoTaoResult;
import app.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xdcao on 2017/6/7.
 */
@Controller
@RequestMapping(value = "/portal/item")
public class PortalItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/{itemId}")
    @ResponseBody
    public ModelAndView getItem(@PathVariable Long itemId){
        Item item=itemService.getItemBaseById(itemId);
//        if (item!=null){
//            return new TaoTaoResult(200,"ok",item);
//        }else {
//            return new TaoTaoResult(200,"ok",null);
//        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("item",item);
        ModelAndView modelAndView=new ModelAndView("portal/item",map);
        return modelAndView;
    }

}
