////////////////////////////////////////////////////////////////////
// [NICOLETTA] [FABRO] [1143541]
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import it.unipd.tos.business.exception.TakeAwayBillException;
import static org.junit.Assert.assertEquals;
public class TakeAwayBillExceptionTest{

    @org.junit.Test
    public void testGetMessage(){
        TakeAwayBillException exception = new TakeAwayBillException("Test");
        assertEquals(exception.getMessage(), "Test");
    }
}