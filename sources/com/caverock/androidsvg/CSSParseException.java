package com.caverock.androidsvg;

class CSSParseException extends Exception {
    CSSParseException(String str) {
        super(str);
    }

    CSSParseException(String str, Exception exc) {
        super(str, exc);
    }
}
