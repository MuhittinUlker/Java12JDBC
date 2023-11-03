package com.muhittinu.app;

import com.muhittinu.controller.CategoryController;
import com.muhittinu.controller.CustomerController;
import com.muhittinu.controller.ProductController;
import com.muhittinu.entitiy.Customer;
import com.muhittinu.util.BAUtils;

import java.util.HashMap;

public class Menu {

    private final CustomerController customerController;
    private final CategoryController categoryController;
    private final ProductController productController;
    public Menu(){
        this.customerController=new CustomerController();
        this.categoryController=new CategoryController();
        this.productController=new ProductController();
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
        int key = BAUtils.menu(menuItems);
        switch (key) {
            case 1 -> productController.buyProduct(customer);
        }
    }

    private void adminMenu() {
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Product Ekle");
        menuItems.put(2,"Category Ekle");
        int key = BAUtils.menu(menuItems);
        switch (key) {
            case 1 -> productController.save();
            case 2 -> categoryController.save();
        }
    }
}
