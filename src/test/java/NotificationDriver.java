import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationDriver {

        class driver{
            public boolean format(Notification n){
                String billSrc= n.getContent();
                if (billSrc.equals("this content is right")){
                    return true;
                }
                return false;
            }
        }

        Notification n1;
        driver d1;

        @Test
        @DisplayName("Bill driver test1")
        public void test1(){
            n1 =new Notification("tmp src","this content is right");
            d1=new driver();
            assertTrue(d1.format(n1));
        }

        @Test
        @DisplayName("Bill driver test2")
        public void test2(){
            n1 =new Notification("tmp src","this content is wrong");
            d1=new driver();
            assertFalse(d1.format(n1));
        }

    }
