////////////////////////////////////////////////////////////////////
// [NICOLETTA] [FABRO] [1143541]
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import it.unipd.tos.business.BillCalculator;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;



public class BillCalculatorTest {

    @org.junit.Test(expected = TakeAwayBillException.class)
    public void testPriceException() throws TakeAwayBillException {
        List<MenuItem> item = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            item.add(new MenuItem(MenuItem.itemType.PANINI, "Montanaro", 7));
        }
        BillCalculator maker = new BillCalculator();
        maker.getOrderPrice(item);
    }

    @org.junit.Test
    public void testCinquePanini() {
        List<MenuItem> item = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            item.add(new MenuItem(MenuItem.itemType.PANINI, "Primavera", 5));
        }
        item.add(new MenuItem(MenuItem.itemType.PANINI, "Vegetariano", 4));
        BillCalculator maker = new BillCalculator();
        double totalPrice = 0;
        try {
            totalPrice = maker.getOrderPrice(item);
        } catch (TakeAwayBillException e) {
            System.out.println("Errore");
        }
        assertEquals(totalPrice, 27, 1E-100);
    }

    @org.junit.Test
    public void testSconto() {
        List<MenuItem> item = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            item.add(new MenuItem(MenuItem.itemType.FRITTI, "Arancini", 10));
        }
        BillCalculator maker = new BillCalculator();
        double totalPrice = 0;
        try {
            totalPrice = maker.getOrderPrice(item);
        } catch (TakeAwayBillException e) {
            System.out.println("Errore");
        }
        assertEquals(totalPrice, 72, 1E-100);
    }

    @org.junit.Test
    public void testCommissione(){
        List<MenuItem> item = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            item.add(new MenuItem(MenuItem.itemType.BEVANDE, "Acqua", 1));
        }
        BillCalculator maker = new BillCalculator();
        double totalPrice = 0;
        try {
            totalPrice = maker.getOrderPrice(item);
        } catch (TakeAwayBillException e) {
            System.out.println("Errore");
        }
        assertEquals(totalPrice, 5.5, 1E-100);
    }

}
