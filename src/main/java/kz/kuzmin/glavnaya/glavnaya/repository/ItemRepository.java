package kz.kuzmin.glavnaya.glavnaya.repository;

import jakarta.transaction.Transactional;
import kz.kuzmin.glavnaya.glavnaya.Model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<ItemModel, Long> {

    List<ItemModel> findAllByPriceGreaterThanEqualAndAmountGreaterThanEqual(double price, int amount);

    List<ItemModel> findAllByNameContainingOrderByPriceDesc(String key);

    List<ItemModel> findAllByNameContainingOrderByNameAsc(String key);

   // @Query(value = "SELECT itemObj FROM ItemModel itemObj " +
    //        " WHERE itemObj.price >= :priceParam AND itemObj.amount >= :ampuntParam ORDER BY itemObj.name ASC")
    //List<ItemModel> allItems(@Param("priceParam") double price,
    //                         @Param("amountParam") int amount);

}
