import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankDriver {
    Bank b = new Bank();
    driver d;

    class driver{
        public boolean format(Bank b){
            b.addClient("c","#","1",25,"c1","pass1");
            b.addCompany("test comp",2000);
            b.findClnt("c1").addAcc(1,2000,"test type");
            if (b.findAcc(1).getBalance()!=2000)
                return false;
            System.out.println("test1 succeded");
            b.findCompany("test comp").addBill(b.findClnt("c1"),"test",500);
            if (b.findClnt("c1").bills.get(0).getSrc().equals("test comp")!=true)
                return false;
            System.out.println("test2 succeded");
            b.findClnt("c1").payBill(1,b.findClnt("c1").bills.get(0));
            if (b.findClnt("c1").accounts.get(0).getBalance()!=1500)
                return false;
            System.out.println("test3 succeded");
            b.findClnt("c1").buy(1,"store","product",500);
            if (b.findClnt("c1").notifications.get(1).getSrc().equals("store")!= true)
                return false;
            System.out.println("test4 succeded");
            return true;
        }
    }

    @Test
    @DisplayName("Bank driver test1")
    public void test1(){
        d = new driver();
        assertTrue(d.format(b));
    }
}