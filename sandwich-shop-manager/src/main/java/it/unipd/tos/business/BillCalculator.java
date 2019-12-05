////////////////////////////////////////////////////////////////////
// [NICOLETTA] [FABRO] [1143541]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;


import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;

public class BillCalculator implements TakeAwayBill {


    public double getOrderPrice(List<MenuItem> itemsOrdered)
            throws TakeAwayBillException {
        double totalPrice = 0;
        totalPrice = itemsOrdered.stream().mapToDouble(x -> x.getPrice()).sum();    //calcolo il prezzo totale
        if(itemsOrdered
                .stream()
                .filter(x -> x.getType() == MenuItem.itemType.PANINI)
                .count() > 5 ) {       //se ordino più di 5 panini il meno caro lo pago la metà
            totalPrice -= (itemsOrdered
                    .stream()
                    .filter(x -> x.getType() == MenuItem.itemType.PANINI)
                    .mapToDouble(x -> x.getPrice()).min().getAsDouble())*0.5;
        }
        if(totalPrice > 50) {      //se l'importo totale super i 50 euro viene fatto uno sconto del 10%
            totalPrice -= totalPrice*0.1;
        }
        if(itemsOrdered.size() > 30) {      //non posso avere più di 30 elementi in un'ordinazione 
            throw new TakeAwayBillException("Errore: Numero di ordinazioni maggiori di 30");
        }
        if(totalPrice < 10){       //se l'importo < 10 aggiungo 0,50 di commissione
            totalPrice += 0.5;
        }
        return totalPrice;
    }
}