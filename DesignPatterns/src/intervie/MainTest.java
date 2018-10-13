package intervie;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class MainTest {

    public static void main(String args[]) {
        LanguageTranslator lang = new AlienLanguageTranslator();
        String str = lang.fromDefaultLanguage("Java");
        String Str2 = lang.toDefaultLanguage(str);

        System.out.println(str);
        System.out.println(Str2);
    }

}
