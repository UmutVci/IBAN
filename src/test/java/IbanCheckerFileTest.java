import com.umutavci.FalscheIBANException;
import com.umutavci.Main;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class IbanCheckerFileTest {

    @Test
    public void testLiesIbanAusDateiAllValid(){
        File file = new File("validIbans.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("validIbans.txt"))){
            bw.write("DE2130120400000BY15228\n");
            bw.write("DE89370400440532013000\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        List<String> invalidList = Main.liesIbanAusDatei("validIbans.txt");
        assertTrue(invalidList.isEmpty());
        file.delete();
    }

    @Test
    public void TestLiesIbanAusDateiWithInvalidIbans(){
        File file = new File("mixedIbans.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("mixedIbans.txt")))
        {
            bw.write("DE2130120400000BY15228\n");
            bw.write("FR12345678901234567890\n");
            bw.write("DE123");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        List<String> invalidIbans = Main.liesIbanAusDatei("mixedIbans.txt");
        assertEquals(2, invalidIbans.size());
        assertTrue(invalidIbans.contains("FR12345678901234567890"));
        assertTrue(invalidIbans.contains("DE123"));
        file.delete();
    }
}
