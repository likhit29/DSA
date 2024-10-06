public class convert_letter_to_uppercase {

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append(str.charAt(i));
                if (i < str.length() - 1) {
                    sb.append(Character.toUpperCase(str.charAt(i + 1)));
                    i++;
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "hi, i am likhit";
        System.out.println(toUpperCase(str));
    }
}