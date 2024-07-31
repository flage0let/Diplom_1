package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientAndIngredientTypeTest {

    private Ingredient ingredient;

    @Parameter
    public IngredientType type;

    @Parameter(1)
    public String name;

    @Parameter(2)
    public float price;

    @Parameters
    public static Object[][] data() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100f},
                {FILLING, "cutlet", 200f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(type, ingredient.getType());
    }

}
