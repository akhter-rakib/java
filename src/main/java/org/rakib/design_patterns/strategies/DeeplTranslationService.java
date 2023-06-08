package org.rakib.design_patterns.strategies;

public class DeeplTranslationService implements Translation {
    @Override
    public String translate(String text) {
        return text + " Translated By Deepl";
    }
}
