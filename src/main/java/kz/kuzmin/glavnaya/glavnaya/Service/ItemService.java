package kz.kuzmin.glavnaya.glavnaya.Service;


import kz.kuzmin.glavnaya.glavnaya.Model.Category;
import kz.kuzmin.glavnaya.glavnaya.Model.Country;
import kz.kuzmin.glavnaya.glavnaya.Model.ItemModel;
import kz.kuzmin.glavnaya.glavnaya.repository.CategoryRepository;
import kz.kuzmin.glavnaya.glavnaya.repository.CountryRepository;
import kz.kuzmin.glavnaya.glavnaya.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service

public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CategoryService categoryService;

    public List<ItemModel> getItems() {
        return itemRepository.findAllByPriceGreaterThanEqualAndAmountGreaterThanEqual(0, 0);
    }

    public ItemModel addItem(ItemModel item) {
        return itemRepository.save(item);

    }

    public ItemModel addItem(String itemName,
                             double price,
                             int amount,
                             String urlValue,
                             Long id) {

        Country country = countryService.getCountry(id);
        ItemModel itemModel = new ItemModel();
        itemModel.setName(itemName);
        itemModel.setAmount(amount);
        itemModel.setPrice(price);
        itemModel.setUrlValue(urlValue);
        itemModel.setCountry(country);

         return addItem(itemModel);

    }

    public  ItemModel getItem(Long id){
        return itemRepository.findById(id).orElse(null);
    }

    public ItemModel saveItem(ItemModel itemModel){
        return itemRepository.save(itemModel);

    }

    public void deleteItem(Long id){
        itemRepository.deleteById(id);

    }

    public List<ItemModel> search(String key) {
        return itemRepository.findAllByNameContainingOrderByNameAsc(key);
    }

    public  ItemModel assignCategory(Long category_id,Long itemId){
        ItemModel itemModel = getItem(itemId);
        Category category = categoryService.getCategory(category_id);

        itemModel.getCategories().add(category);

        return itemRepository.save(itemModel);

    }

    public  ItemModel removeCategory(Long category_id,Long itemId){
        ItemModel itemModel = getItem(itemId);
        Category category = categoryService.getCategory(category_id);

        itemModel.getCategories().remove(category);

        return itemRepository.save(itemModel);

    }
}
