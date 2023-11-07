package com.muhittinu.app;

import com.muhittinu.controller.CategoryController;
import com.muhittinu.controller.CustomerController;
import com.muhittinu.controller.ProductController;
import com.muhittinu.controller.ProductDetailController;
import com.muhittinu.entitiy.Customer;
import com.muhittinu.service.ProductDetailService;
import com.muhittinu.util.BAUtils;

import java.util.HashMap;

public class Menu {

    private final CustomerController customerController;
    private final CategoryController categoryController;
    private final ProductController productController;
    private final ProductDetailController productDetailController;
    public Menu(){
        this.customerController=new CustomerController();
        this.categoryController=new CategoryController();
        this.productController=new ProductController();
        this.productDetailController = new ProductDetailController();
    }
    public void menu(){
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Admin");
        menuItems.put(2,"Customer");
        int key = BAUtils.menu(menuItems);
        switch (key){
            case 1:
                adminMenu();
                break;
            case 2:
                customerMenu();
                break;
        }
    }

    private void customerMenu() {
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Kayit Ol");
        menuItems.put(2,"Giris Yap");
        int key = BAUtils.menu(menuItems);
        switch (key) {
            case 1 -> customerController.register();
            case 2 -> customerManagerMenu(customerController.login());
        }
    }
    private void customerManagerMenu(Customer customer) {
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Satin Al");
        menuItems.put(2,"Urune Yorum Yap ve Puan Ver");
        menuItems.put(3,"Stogu bitmek uzere olan urunleri listele");
        menuItems.put(4,"Urune gore Yorumlari goster");
        int key = BAUtils.menu(menuItems);
        switch (key) {
            case 1 -> productController.buyProduct(customer);
            case 2 -> productDetailController.commentAndRateProductById();
            case 3 -> productController.showLowStockProducts();
            case 4 -> productDetailController.showCommentsByProductId();
        }
    }

    private void adminMenu() {
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Product Ekle");
        menuItems.put(2,"Category Ekle");
        menuItems.put(3,"Tum Productlari Listele");
        int key = BAUtils.menu(menuItems);
        switch (key) {
            case 1 -> productController.save();
            case 2 -> categoryController.save();
            case 3 -> productController.listAll();
        }
    }
}
