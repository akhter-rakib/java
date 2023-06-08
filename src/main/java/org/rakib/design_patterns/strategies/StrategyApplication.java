package org.rakib.design_patterns.strategies;

public class StrategyApplication {
    public static void main(String[] args) {
        Translation googleTranslatorService = new GoogleTranslatorService();
        Translation deeplTranslationService = new DeeplTranslationService();


        System.out.println(googleTranslatorService.translate("My text"));
        System.out.println(deeplTranslationService.translate("My Text"));
    }
}
