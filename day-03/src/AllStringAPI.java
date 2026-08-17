public class AllStringAPI {

    public static void main(String[] args) {

        String text = "  Hello Java World  ";
        String name = "Vamsi Krishna";

        System.out.println("1. length(): " + text.length());

        System.out.println("2. charAt(): " + text.charAt(2));

        System.out.println("3. toUpperCase(): " + text.toUpperCase());

        System.out.println("4. toLowerCase(): " + text.toLowerCase());

        System.out.println("5. trim(): " + text.trim());

        String a = "Java";
        String b = "Java";

        System.out.println("6. equals(): " + a.equals(b));

        String c = "JAVA";

        System.out.println("7. equalsIgnoreCase(): " + a.equalsIgnoreCase(c));

        System.out.println("8. contains(): " + text.contains("Java"));

        System.out.println("9. startsWith(): " + text.trim().startsWith("Hello"));

        System.out.println("10. endsWith(): " + text.trim().endsWith("World"));

        System.out.println("11. indexOf(): " + text.indexOf("Java"));

        System.out.println("12. lastIndexOf(): " + text.lastIndexOf("o"));

        System.out.println("13. substring(start): " + name.substring(6));

        System.out.println("14. substring(start,end): " + name.substring(0, 5));

        String message = "I like Java";

        System.out.println("15. replace(): " + message.replace("Java", "React"));

        String numbers = "Java Java Java";

        System.out.println("16. replaceFirst(): "
                + numbers.replaceFirst("Java", "Python"));

        String digits = "Java123Programming456";

        System.out.println("17. replaceAll(): "
                + digits.replaceAll("[0-9]", ""));

        String empty = "";

        System.out.println("18. isEmpty(): " + empty.isEmpty());

        String blank = "   ";

        System.out.println("19. isBlank(): " + blank.isBlank());

        String firstName = "Vamsi";
        String lastName = "Krishna";

        System.out.println("20. concat(): "
                + firstName.concat(" ").concat(lastName));

        String languages = "Java,Python,JavaScript";

        String[] result = languages.split(",");

        System.out.println("21. split():");

        for (String language : result) {
            System.out.println(language);
        }

        String word = "Java";

        char[] characters = word.toCharArray();

        System.out.println("22. toCharArray():");

        for (char ch : characters) {
            System.out.println(ch);
        }

        int number = 100;

        String converted = String.valueOf(number);

        System.out.println("23. valueOf(): " + converted);

        String x = "Apple";
        String y = "Banana";

        System.out.println("24. compareTo(): " + x.compareTo(y));

        String p = "java";
        String q = "JAVA";

        System.out.println("25. compareToIgnoreCase(): "
                + p.compareToIgnoreCase(q));
    }
}