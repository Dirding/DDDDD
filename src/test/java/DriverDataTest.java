import com.transport.trunsport_company.DriverData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DriverDataTest {

    @Test
    public void testDriverDataCreation() {
        DriverData driver = new DriverData("Иван", "Иванов", "Иванович", "123456");

        assertEquals("Иван", driver.getFirstName());
        assertEquals("Иванов", driver.getLastName());
        assertEquals("Иванович", driver.getMiddleName());
        assertEquals("123456", driver.getLicenseNumber());
        assertTrue(driver.getId() > 0);
    }

    @Test
    public void testUniqueIdIncrement() {
        DriverData d1 = new DriverData("A", "B", "C", "1");
        DriverData d2 = new DriverData("X", "Y", "Z", "2");

        assertNotEquals(d1.getId(), d2.getId());
    }
}