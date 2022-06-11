import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDriver {
    Company c = new Company("test comp",2000,null);
    Client a = new Client("c","#","1",25,false,"c1","pass1",null);
    driver d;

    class driver{
        public boolean format(Company c,Client a){
            c.addBill(a,"test",200);
            if (a.bills.get(0).getSrc().equals("test comp")!=true || a.bills.get(0).getContent().equals("test")!=true)
                return false;
            a.payBill(1,a.bills.get(0));
            if (a.findAcc(1).getBalance()!=800)
                return false;
            return true;
        }
    }


    @Test
    @DisplayName("Company driver test1")
    public void test1(){
        d = new driver();
        a.addAcc(1,1000,"tst type");
        assertTrue(d.format(c,a));
    }
}