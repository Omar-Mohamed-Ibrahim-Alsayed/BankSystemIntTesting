import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountDriver {
    class driver{
        public boolean format(Account acc){
            acc.withdraw(200);
            acc.deposit(300);
            if (acc.getBalance()==1100){
                return true;
            }
            return false;
        }
    }

    Account a1;
    driver d1;

    @Test
    @DisplayName("Account driver test1")
    public void test1(){
        a1 =new Account(1,1000,"savings");
        d1=new driver();
        assertTrue(d1.format(a1));
    }

    @Test
    @DisplayName("Account driver test2")
    public void test2(){
        a1 =new Account(1,2000,"savings");
        d1=new driver();
        assertFalse(d1.format(a1));
    }



}