package kz.kuzmin.glavnaya.glavnaya.Controllers;

import kz.kuzmin.glavnaya.glavnaya.Model.Category;

import kz.kuzmin.glavnaya.glavnaya.Model.ItemModel;
import kz.kuzmin.glavnaya.glavnaya.Service.CategoryService;
import kz.kuzmin.glavnaya.glavnaya.Service.CountryService;
import kz.kuzmin.glavnaya.glavnaya.Service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CountryService countryService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "/")
    public String indexPage(Model model) {


        model.addAttribute("tovary", itemService.getItems());
        return "index";
    }

    @GetMapping(value = "/additem")
    public String addItem(Model model) {
        model.addAttribute("countries", countryService.GetCountries());

        return "additem";
    }

    @PostMapping(value = "/additem")
    public String addItem(@RequestParam(name = "name") String itemName,
                          @RequestParam(name = "price") double price,
                          @RequestParam(name = "amount") int amount,
                          @RequestParam(name = "urlValue") String urlValue,
                          @RequestParam(name = "country.id") Long id) {
        itemService.addItem(itemName, price, amount, urlValue, id);
        return "redirect:/additem";
    }

    @PostMapping(value = "/additem-v2")
    public String additem(ItemModel itemModel) {
        itemService.addItem(itemModel);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{idshka}/{urlValue}.html")
    public String details(@PathVariable(name = "idshka") Long id,
                          @PathVariable(name = "urlValue") String urlValue,
                          Model model) {

        ItemModel itemModel = itemService.getItem(id);
        model.addAttribute("item", itemModel);
        model.addAttribute("countries", countryService.GetCountries());

        List<Category> categories = categoryService.getCategories();
        categories.removeAll(itemModel.getCategories());

        model.addAttribute("categories", categories);
        return "details";

    }

    @PostMapping(value = "/saveitem")
    public String saveItem(ItemModel itemModel) {

        itemModel = itemService.saveItem(itemModel);
        return "redirect:/details/" + itemModel.getId() + "/" + itemModel.getUrlValue() + ".html";
    }

    @PostMapping(value = "/deleteitem")
    public String deleteItem(@RequestParam(name = "id") Long id) {
        itemService.deleteItem(id);
        return "redirect:/";

    }

    @GetMapping(value = "/search")
    public String search(@RequestParam(name = "key", defaultValue = "", required = false) String key,
                         Model model) {
        model.addAttribute("tovary", itemService.search(key));

        return "search";
    }

    @PostMapping(value = "/assign-category")
    public String assignCategory(@RequestParam(name = "category_id") Long categoryId,
                                 @RequestParam(name = "item_id") Long itemId) {
        ItemModel itemModel = itemService.assignCategory(categoryId, itemId);

        return "redirect:/details/" + itemModel.getId() + "/" + itemModel.getUrlValue() + ".html";

    }

    @PostMapping(value = "/remove-category")
    public String removeCategory(@RequestParam(name = "category_id") Long categoryId,
                                 @RequestParam(name = "item_id") Long itemId) {
        ItemModel itemModel = itemService.removeCategory(categoryId, itemId);

        return "redirect:/details/" + itemModel.getId() + "/" + itemModel.getUrlValue() + ".html";

    }
}
