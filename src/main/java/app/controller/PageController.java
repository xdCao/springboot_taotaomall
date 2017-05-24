package app.controller;

import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xdcao on 2017/5/23.
 */
@Controller
public class PageController {

    @RequestMapping(value = "/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/{page}")
    public ModelAndView page(@PathVariable String page){
        return new ModelAndView(page);
    }


}
