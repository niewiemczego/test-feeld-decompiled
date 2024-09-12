package org.apache.commons.codec.language.bm;

import com.oblador.keychain.KeychainModule;

public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES(KeychainModule.Maps.RULES);
    
    private final String name;

    private RuleType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
