package lowleveldesign.singleton;

public class ShiftCharacter {
    public static void main(String[] args) {
        String input = "B";
        int k = 2;

        char result = shiftCharacter(input.charAt(0), k);
        System.out.println("Result: " + result);
    }

    public static char shiftCharacter(char c, int k) {
        // Convert character to uppercase and get its ASCII value
        int asciiValue = (int) Character.toUpperCase(c);

        // Subtract the ASCII value of 'A', add k, and take modulo 26
        int shiftedValue = (asciiValue - (int) 'A' - k) % 26;

        // Handle negative values (wraparound to the end of the alphabet)
        if (shiftedValue < 0) {
            shiftedValue += 26;
        }

        // Add the ASCII value of 'A' to get the final ASCII value
        int finalAsciiValue = shiftedValue + (int) 'A';

        // Convert the final ASCII value back to a character
        return (char) finalAsciiValue;
    }
}

