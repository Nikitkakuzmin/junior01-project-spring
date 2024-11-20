package kz.kuzmin.glavnaya.glavnaya.Controllers;

import kz.kuzmin.glavnaya.glavnaya.DB.DBConnector;
import kz.kuzmin.glavnaya.glavnaya.beans.Someitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {
    @Autowired
    private Someitem item;

    @Autowired
    private DBConnector dbConnector;
    @GetMapping(value = "/other")
    public  String Otherpage(Model model){
        System.out.println(item.GetData());

        return "index";
    }

    @GetMapping(value = "/change")
    public  String Change(){
        item.setName("LOL");
        item.setAmount(11);

        return "redirect:/";
    }

    @GetMapping(value = "/beanshowfromother")
    public String beanshow(Model model){
        model.addAttribute("names", item.GetData());
        return "beanshow";
    }

}
