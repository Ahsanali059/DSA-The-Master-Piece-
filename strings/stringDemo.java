package strings;

import java.util.Arrays;

public class stringDemo
{
    public static void main(String[] args) {
        String s = "Ahsan";
        String s2 = "Ali";

        System.out.print(s.isBlank());
        System.out.println(" Chracter at string Index 1"+s.charAt(1)); // char at return corrent character index
        System.out.println(s.compareTo(s2)); // compareTo() left se right characters compare karta hai, aur tumhare case mai 'A' vs 'A' equal hai, phir 'h' (Unicode 104) minus 'l' (Unicode 108) = -4.

        System.out.println(s.compareToIgnoreCase(s)); // compareToIgnoreCase() → case ko ignore karta hai, yani 'A' aur 'a' ko same treat karega.

        System.out.println(s.concat(s2)); // output AhsanAli
        System.out.println(s.contains("a")); // it return boolean value

		/*
		 *-> equals() → sirf String ke saath compare karta hai.

          -> contentEquals() → String ke alawa CharSequence aur StringBuffer ke saath bhi compare kar sakta hai.

		 */
        System.out.println(s.contentEquals(s2)); // it compare both string character and return true or false

        System.out.println(s.endsWith("aan")); // is string ends with this word it return boolean value

        System.out.println(s.equals(s2)); // return false compare content

        System.out.println(s.hashCode()); // return hascode value where string is stored

        System.out.println(s.substring(2)); // ya string mai sa ek sub string bana deta ha

        System.out.println(Arrays.toString(s.split("a"))); // string ko har a wali jagha sa toor do


    }
}
