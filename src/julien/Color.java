package julien;

import java.util.regex.Pattern;

public class Color {

    private int red;
    private int green;
    private int blue;
    private String hexValue;
    private String hexRegex = "#[0-9A-F]{6}";

    public Color(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) throw new IllegalArgumentException();
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.hexValue = "#" + rgbIntToHexString(red) + rgbIntToHexString(green) + rgbIntToHexString(blue);
    }

    public Color(String hexValue) {
        setHexValue(hexValue);
    }

    @Override
    public String toString() {
        return "[value=" + this.getHexValue() + ", r=" + this.getRed() + ", g=" + this.getGreen() + ", b=" + this.getBlue() + "]";
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        if (hexValue == null || !Pattern.matches(hexRegex, hexValue)) throw new IllegalArgumentException();
        this.hexValue = hexValue.toUpperCase();
        this.red = Integer.parseUnsignedInt(hexValue.substring(1, 3), 16);
        this.green = Integer.parseUnsignedInt(hexValue.substring(3, 5), 16);
        this.blue =Integer.parseUnsignedInt(hexValue.substring(5, 7), 16);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        checkRGB(red);
        this.red = red;
        this.hexValue = "#" + rgbIntToHexString(red) + rgbIntToHexString(this.getGreen()) + rgbIntToHexString(this.getBlue());
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        checkRGB(green);
        this.green = green;
        this.hexValue = "#" + rgbIntToHexString(this.getRed()) + rgbIntToHexString(green) + rgbIntToHexString(this.getBlue());
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        checkRGB(blue);
        this.blue = blue;
        this.hexValue = "#" + rgbIntToHexString(this.getRed()) + rgbIntToHexString(this.getGreen()) + rgbIntToHexString(blue);
    }

    private String rgbIntToHexString(int value) {
        return ((Integer.toHexString(value).length() == 1) ? "0" + Integer.toHexString(value) : Integer.toHexString(value)).toUpperCase();
    }

    private void checkRGB(int value) {
        if (value < 0 || value > 255) throw new IllegalArgumentException();
    }
}
