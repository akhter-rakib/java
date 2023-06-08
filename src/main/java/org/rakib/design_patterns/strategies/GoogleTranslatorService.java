package org.rakib.design_patterns.strategies;

public class GoogleTranslatorService implements Translation {
    @Override
    public String translate(String text) {
        return text + "Translated By Google!";
    }
}
