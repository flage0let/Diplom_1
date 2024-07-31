package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private float expectedPrice;
    private String expectedReceipt;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(50f);

        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient1.getPrice()).thenReturn(100f);

        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("cutlet");
        Mockito.when(ingredient2.getPrice()).thenReturn(100f);

        expectedPrice = 300f;
        expectedReceipt = String.format("%s%n%s%n%s%n%s%n%n%s%n",
                "(==== black bun ====)",
                "= sauce hot sauce =",
                "= filling cutlet =",
                "(==== black bun ====)",
                "Price: 300,000000");
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);

        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(expectedPrice, burger.getPrice(), 0.0f);

        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient1, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient2, Mockito.times(1)).getPrice();
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals(expectedReceipt, burger.getReceipt());

        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(ingredient1, Mockito.times(1)).getName();
        Mockito.verify(ingredient1, Mockito.times(1)).getType();
        Mockito.verify(ingredient2, Mockito.times(1)).getName();
        Mockito.verify(ingredient2, Mockito.times(1)).getType();
    }

}
