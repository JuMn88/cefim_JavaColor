import julien.Color;
import org.junit.jupiter.api.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorTest {
    private Color color;
    private String toStringRegex = "\\[value=#[0-9A-F]{6},\\s*r=(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?),\\s*g=(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?),\\s*b=(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]";
    private Pattern pattern = Pattern.compile(toStringRegex);
    private Matcher matcher;

    @AfterEach
    public void tearDown() {
        color = null;
    }

    // Tester l'initialisation d'une couleur par RGB
    // Test 1 : Initialisation réussie
    @Test
    public void testInitializeColorWithRGB() {
        color = new Color(0, 0, 0);
        Assertions.assertNotNull(color);
        Assertions.assertInstanceOf(Color.class, color, "Mauvais type de classe");
        Assertions.assertEquals(0, color.getRed(), "Mauvaise valeur de rouge");
        Assertions.assertEquals(0, color.getGreen(), "Mauvaise valeur de vert");
        Assertions.assertEquals(0, color.getBlue(), "Mauvaise valeur de blue");
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#000000"), "Mauvaise valeur hexadécimale");
    }

    // Test 2 : Paramètre 1 incorrect (valeur trop faible)
    @Test
    public void testInitializeColorWithLowRed() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color = new Color(-10, 0, 0));
    }

    // Test 3 : Paramètre 1 incorrect (valeur trop élevée)
    @Test
    public void testInitializeColorWithHighRed() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color = new Color(300, 0, 0));
    }

    // Test 4 : Paramètre 2 incorrect (valeur trop faible)
    @Test
    public void testInitializeColorWithLowGreen() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color = new Color(0, -10, 0));
    }

    // Test 5 : Paramètre 2 incorrect (valeur trop élevée)
    @Test
    public void testInitializeColorWithHighGreen() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color = new Color(0, 300, 0));
    }

    // Test 6 : Paramètre 3 incorrect (valeur trop faible)
    @Test
    public void testInitializeColorWithLowBlue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color = new Color(0, 0, -10));
    }

    // Test 7 : Paramètre 3 incorrect (valeur trop élevée)
    @Test
    public void testInitializeColorWithHighBlue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color = new Color(0, 0, 300));
    }

    // Tester l'initialisation d'une couleur par Hexadécimale
    // Test 1 : Initialisation réussie
    @Test
    public void testInitializeColorWithHexValue() {
        color = new Color("#000000");
        Assertions.assertNotNull(color);
        Assertions.assertInstanceOf(Color.class, color, "Mauvais type de classe");
        Assertions.assertEquals(0, color.getRed(), "Mauvaise valeur de rouge");
        Assertions.assertEquals(0, color.getGreen(), "Mauvaise valeur de vert");
        Assertions.assertEquals(0, color.getBlue(), "Mauvaise valeur de blue");
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#000000"), "Mauvaise valeur hexadécimale");
    }

    // Test 2 : Paramètre incorrect (ne correspond pas au format d'une chaîne de caractères commençant par # suivi de 6 caractères compris entre 0 et F)
    @Test
    public void testInitializeColorWithWrongString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color = new Color("Clairement pas une valeur hexadécimale"));
    }

    // Tester les getters
    @Test
    public void testGetRed() {
        color = new Color(0, 0, 0);
        Assertions.assertEquals(0, color.getRed());
        Assertions.assertEquals(0, color.getGreen(), "Mauvaise valeur de vert");
        Assertions.assertEquals(0, color.getBlue(), "Mauvaise valeur de blue");
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#000000"), "Mauvaise valeur hexadécimale");
    }

    @Test
    public void testGetGreen() {
        color = new Color(0, 0, 0);
        Assertions.assertEquals(0, color.getRed());
        Assertions.assertEquals(0, color.getGreen(), "Mauvaise valeur de vert");
        Assertions.assertEquals(0, color.getBlue(), "Mauvaise valeur de blue");
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#000000"), "Mauvaise valeur hexadécimale");
    }

    @Test
    public void testGetBlue() {
        color = new Color(0, 0, 0);
        Assertions.assertEquals(0, color.getRed());
        Assertions.assertEquals(0, color.getGreen(), "Mauvaise valeur de vert");
        Assertions.assertEquals(0, color.getBlue(), "Mauvaise valeur de blue");
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#000000"), "Mauvaise valeur hexadécimale");
    }

    @Test
    public void testGetHexValue() {
        color = new Color(0, 0, 0);
        Assertions.assertEquals(0, color.getRed());
        Assertions.assertEquals(0, color.getGreen(), "Mauvaise valeur de vert");
        Assertions.assertEquals(0, color.getBlue(), "Mauvaise valeur de blue");
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#000000"), "Mauvaise valeur hexadécimale");
    }

    // Tester les setters
    @Test
    public void testSetRed() {
        color = new Color(0, 0, 0);
        color.setRed(13);
        Assertions.assertEquals(13, color.getRed());
        Assertions.assertEquals(0, color.getGreen());
        Assertions.assertEquals(0, color.getBlue());
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#0d0000"), "Mauvaise valeur hexadécimale");
    }

    @Test
    public void testSetRedWithLowValue() {
        color = new Color(0, 0, 0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setRed(-10));
    }

    @Test
    public void testSetRedWithHighValue() {
        color = new Color(0, 0, 0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setRed(300));
    }

    @Test
    public void testSetGreen() {
        color = new Color(0, 0, 0);
        color.setGreen(13);
        Assertions.assertEquals(0, color.getRed());
        Assertions.assertEquals(13, color.getGreen());
        Assertions.assertEquals(0, color.getBlue());
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#000d00"), "Mauvaise valeur hexadécimale");
    }

    @Test
    public void testSetGreenWithLowValue() {
        color = new Color(0, 0, 0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setGreen(-10));
    }

    @Test
    public void testSetGreenWithHighValue() {
        color = new Color(0, 0, 0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setGreen(300));
    }

    @Test
    public void testSetBlue() {
        color = new Color(0, 0, 0);
        color.setBlue(13);
        Assertions.assertEquals(0, color.getRed());
        Assertions.assertEquals(0, color.getGreen());
        Assertions.assertEquals(13, color.getBlue());
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#00000d"), "Mauvaise valeur hexadécimale");
    }

    @Test
    public void testSetBlueWithLowValue() {
        color = new Color(0, 0, 0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setBlue(-10));
    }

    @Test
    public void testSetBlueWithHighValue() {
        color = new Color(0, 0, 0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setBlue(300));
    }

    @Test
    public void testSetHexValue() {
        color = new Color(0, 0, 0);
        color.setHexValue("#0d0d0d");
        Assertions.assertEquals(13, color.getRed());
        Assertions.assertEquals(13, color.getGreen());
        Assertions.assertEquals(13, color.getBlue());
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#0d0d0d"), "Mauvaise valeur hexadécimale");
    }

    @Test
    public void testSetHexValueWithWrongString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setHexValue("Clairement pas une valeur hexadécimale"));
    }

    // Tester la méthode toString()
    @Test
    public void testToString() {
        color = new Color(0, 0, 0);
        matcher = pattern.matcher(color.toString());
        Assertions.assertTrue(matcher.matches());
        Assertions.assertEquals(0, color.getRed());
        Assertions.assertEquals(0, color.getGreen(), "Mauvaise valeur de vert");
        Assertions.assertEquals(0, color.getBlue(), "Mauvaise valeur de blue");
        Assertions.assertTrue(color.getHexValue().equalsIgnoreCase("#000000"), "Mauvaise valeur hexadécimale");
    }
}
