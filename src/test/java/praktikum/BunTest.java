package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;
    private final String NAME = "black bun";
    private final float PRICE = 100;

    @Before
    public void setUp() {
        bun = new Bun(NAME, PRICE);
    }

    @Test
    public void getNameTest() {
        assertEquals(NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(PRICE, bun.getPrice(), 0.0f);
    }

}
