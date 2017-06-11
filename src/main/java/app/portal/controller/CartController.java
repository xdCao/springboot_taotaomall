package app.portal.controller;

import app.manager.service.ItemService;
import app.model.TaoTaoResult;
import app.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xdcao on 2017/6/11.
 */
@Controller
public class CartController {


    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/cart/add/{itemId}")
    public ModelAndView addCart(@PathVariable Long itemId){
        Item item=itemService.getItemBaseById(itemId);

        return new ModelAndView("portal/cart");
    }


}
