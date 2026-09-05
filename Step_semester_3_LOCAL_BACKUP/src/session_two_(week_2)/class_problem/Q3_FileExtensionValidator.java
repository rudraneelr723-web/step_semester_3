public class Q3_FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');

        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDot + 1);

        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}
