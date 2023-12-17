package org.internetStore.service;

import org.internetStore.dal.DataAccessLayer;
import org.internetStore.models.entities.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    @Autowired
    private DataAccessLayer dataAccessLayer;
    public List<Basket> getBasket() {
        return dataAccessLayer.getBasketFromDatabase();
    }
    public String addProductToBasket(long productId) {
        return dataAccessLayer.newBasketToDatabase(dataAccessLayer.getProductFromDatabaseByID(productId));
    }
    public void dropProductFromBasket(long productId) {
        dataAccessLayer.dropProductFromBasketByID(productId);
    }

}
