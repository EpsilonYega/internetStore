package org.internetStore.dal;

import org.internetStore.models.entities.productEntities.Product;

import java.util.List;

public class DataAccessLayer {
    public List<Product> getProductsFromDatabase(){
        //Савелий Палыч, достаньте все продукты из таблички "Продукт" и поместите их в этот список
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products
        List<Product> productList = null;
        return productList;
    }
    public Product getProductFromDatabaseByID(int id){
        //Савелий Палыч, достаньте продукт из таблички "Продукт" по id и поместите его в этот продукт
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products/0
        Product product = null;
        return product;
    }
    public void newProductToDatabase(){
        //Я пока не придумал ничего, пока тут нет моих пакостей можешь создать продукт вручную и кинуть в БД
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products/new
    }
    public void updateProductFromDatabaseByID(int id){
        //Измени пакость на новую пакость, тоже пока вручную
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products/update/0
    }
    public void dropProductFromDatabaseByID(int id){
        //УДАЛИ ПАКОСТЬ, УДАЛИ ПАКОСТЬ, УДАЛИИИИИИИИИИИИИИИИ ПААААААААААКООООООООООООООООООСТЬ
        //Чтобы запустить нажми зеленую кнопочку, дождись пока все пенисы появятся в консоли и введи в поисковик урл: http://localhost:8080/main/products/drop/0
    }
}
