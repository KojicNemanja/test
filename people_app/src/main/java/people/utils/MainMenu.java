package people.utils;

import java.util.ArrayList;

public class MainMenu {

    public static ArrayList<MenuItem> get(){
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Home", "/"));
        menuItems.add(new MenuItem("Add", "/add"));
        return menuItems;
    }
}
