public class Q10_ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();
        char[] reversed = new char[characters.length];

        for (int i = 0; i < characters.length; i++) {
            reversed[i] = characters[characters.length - 1 - i];
        }

        return new String(reversed);
    }

    public static void main(String[] args) {
        String customerName = "Sunil";

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}
