package com.mycompany.premiertest.module1;
import org.apache.commons.lang3.StringUtils;
public class PremierTest {
    public static void main(String[] args) {
        String phraseUnPeuLongue = "ceci est une phrase super longue qui ne tiendra pas en largeur dans mon  ecran";
        System.out.println(phraseUnPeuLongue);
        String phraseRacourcie = StringUtils.abbreviate(phraseUnPeuLongue, 10);
        System.out.println(phraseRacourcie);
    }
}
