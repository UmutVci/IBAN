import com.umutavci.FalscheIBANException;
import com.umutavci.Main;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class IbanCheckerTest {

    @Test
    public void testValidIban(){
        String validIban = "DE2130120400000BY15228";
        assertDoesNotThrow(() -> Main.checkIban(validIban));
    }

    @Test
    public void testInvalidIban(){
        String iban = "TR2130120400000BY15228";
        assertThrows(FalscheIBANException.class, () -> Main.checkIban(iban));
    }

    @Test
    public void testInvalidIbanLength(){
        String iban = "DE2130120400000BY152";
        assertThrows(FalscheIBANException.class, () -> Main.checkIban(iban));

    }
}

