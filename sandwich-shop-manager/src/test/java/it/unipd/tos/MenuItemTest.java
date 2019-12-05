////////////////////////////////////////////////////////////////////
// [NICOLETTA] [FABRO] [1143541]
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import it.unipd.tos.model.MenuItem;

import static org.junit.Assert.assertEquals;


public class MenuItemTest{

    @org.junit.Test
    public void testGetType(){
        MenuItem item = new MenuItem(MenuItem.itemType.PANINI, "Primavera", 7.50);
        assertEquals(item.getType(), MenuItem.itemType.PANINI);
    }

    @org.junit.Test
    public void testGetName(){
        MenuItem item = new MenuItem(MenuItem.itemType.BEVANDE, "Coca-Cola", 1.50);
        assertEquals(item.getName(),  "Coca-Cola");
    }

    @org.junit.Test
    public void testGetPrice(){
        MenuItem item = new MenuItem(MenuItem.itemType.FRITTI, "Olive Ascolane", 4.50);
        assertEquals(item.getPrice(), 4.50, 1E-10);
    }
}