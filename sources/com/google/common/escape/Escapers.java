package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@ElementTypesAreNonnullByDefault
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new CharEscaper() {
        /* access modifiers changed from: protected */
        @CheckForNull
        public char[] escape(char c) {
            return null;
        }

        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }
    };

    private Escapers() {
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        /* access modifiers changed from: private */
        @CheckForNull
        public String unsafeReplacement;

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = 0;
            this.safeMax = CharCompanionObject.MAX_VALUE;
            this.unsafeReplacement = null;
        }

        public Builder setSafeRange(char c, char c2) {
            this.safeMin = c;
            this.safeMax = c2;
            return this;
        }

        public Builder setUnsafeReplacement(String str) {
            this.unsafeReplacement = str;
            return this;
        }

        public Builder addEscape(char c, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c), str);
            return this;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) {
                @CheckForNull
                private final char[] replacementChars;

                {
                    this.replacementChars = Builder.this.unsafeReplacement != null ? Builder.this.unsafeReplacement.toCharArray() : null;
                }

                /* access modifiers changed from: protected */
                @CheckForNull
                public char[] escapeUnsafe(char c) {
                    return this.replacementChars;
                }
            };
        }
    }

    static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        String valueOf = String.valueOf(escaper.getClass().getName());
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Cannot create a UnicodeEscaper from: ".concat(valueOf) : new String("Cannot create a UnicodeEscaper from: "));
    }

    @CheckForNull
    public static String computeReplacement(CharEscaper charEscaper, char c) {
        return stringOrNull(charEscaper.escape(c));
    }

    @CheckForNull
    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i) {
        return stringOrNull(unicodeEscaper.escape(i));
    }

    @CheckForNull
    private static String stringOrNull(@CheckForNull char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() {
            /* access modifiers changed from: protected */
            @CheckForNull
            public char[] escape(int i) {
                if (i < 65536) {
                    return CharEscaper.this.escape((char) i);
                }
                char[] cArr = new char[2];
                Character.toChars(i, cArr, 0);
                char[] escape = CharEscaper.this.escape(cArr[0]);
                char[] escape2 = CharEscaper.this.escape(cArr[1]);
                if (escape == null && escape2 == null) {
                    return null;
                }
                int length = escape != null ? escape.length : 1;
                char[] cArr2 = new char[((escape2 != null ? escape2.length : 1) + length)];
                if (escape != null) {
                    for (int i2 = 0; i2 < escape.length; i2++) {
                        cArr2[i2] = escape[i2];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (escape2 != null) {
                    for (int i3 = 0; i3 < escape2.length; i3++) {
                        cArr2[length + i3] = escape2[i3];
                    }
                } else {
                    cArr2[length] = cArr[1];
                }
                return cArr2;
            }
        };
    }
}
