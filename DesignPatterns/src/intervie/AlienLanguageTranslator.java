package intervie;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class AlienLanguageTranslator implements LanguageTranslator {

    /*
     * (non-Javadoc)
     * 
     * @see intervie.LanguageTranslator#fromDefaultLanguage(java.lang.String)
     */
    @Override
    public String fromDefaultLanguage(String languageTokens) {
        char[] character = languageTokens.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < character.length; i++) {
            int ascii = (int) character[i];
            ascii += 3;
            if (ascii > 90 && !(ascii >= 97))
                ascii = 65 + ascii % 90;
            if (ascii > 122)
                ascii = 97 + ((ascii % 122) - 1);
            stringBuilder.append(Character.toString((char) ascii));

        }

        return stringBuilder.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see intervie.LanguageTranslator#toDefaultLanguage(java.lang.String)
     */
    @Override
    public String toDefaultLanguage(String languageTokens) {
        char[] character = languageTokens.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < character.length; i++) {
            int ascii = (int) character[i];
            ascii -= 3;

            if (ascii < 65)
                ascii += 90 - (65 - ascii % 65);

            if (ascii < 97 && !(ascii < 90))
                ascii = 122 - (97 - (ascii % 97 + 1));
            stringBuilder.append(Character.toString((char) ascii));

        }

        return stringBuilder.toString();
    }
}
