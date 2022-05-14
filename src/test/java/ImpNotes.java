import java.util.Locale;

public class ImpNotes {
    public static void main(String[] args) {
        String str="HELLO WORLD";
        System.out.println(str.toLowerCase());//hello world
        System.out.println(str.isEmpty());// false
        System.out.println(str.concat(" no way"));// HELLO WORLD no way
        System.out.println(str.subSequence(0,5));// HELLO
        System.out.println(str.split(" ",1));// [Ljava.lang.String;@1221655
        System.out.println(str.charAt(8));// R
        System.out.println(str.substring(0,5));// HELLO
        System.out.println(str.contains("L"));// true
        System.out.println(str.hashCode());// 568232580
    }
}
