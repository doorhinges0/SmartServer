package com.fuck.mobile.base.utils;

public class Base64 {

    static class FormatException extends RuntimeException {
        public FormatException() {
            super();
        }

        public FormatException(String str) {
            super(str);
        }

        private static final long serialVersionUID = -3245515740473669168L;

    }

    static class ArgumentNullException extends RuntimeException {
        private static final long serialVersionUID = 8701361475619644362L;

        public ArgumentNullException() {
            super();
        }

        public ArgumentNullException(String str) {
            super(str);
        }
    }

    static class ArgumentOutOfRangeException extends RuntimeException {
        private static final long serialVersionUID = -5338535910938649126L;

        public ArgumentOutOfRangeException() {
            super();
        }

        public ArgumentOutOfRangeException(String str) {
            super(str);
        }
    }

    static final char[] K_base64 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', '+', '/', '=' };

    public static int ToBase64CharArray(byte[] inArray, int offsetIn, int length, char[] outArray, int offsetOut) {
        int num4;
        if (inArray == null) {
            throw new ArgumentNullException();
        }
        if (outArray == null) {
            throw new ArgumentNullException();
        }
        if (((length < 0) || (offsetIn < 0)) || (offsetOut < 0)) {
            throw new ArgumentOutOfRangeException();
        }
        if (offsetIn > (inArray.length - length)) {
            throw new ArgumentOutOfRangeException();
        }
        int num = ((length / 3) * 4) + ((((length % 3) != 0) ? 1 : 0) * 4);
        if (offsetOut > (outArray.length - num)) {
            throw new ArgumentOutOfRangeException();
        }
        int num2 = offsetIn + (length - (length % 3));
        int index = offsetOut;
        for (num4 = offsetIn; num4 < num2; num4 += 3) {
            outArray[index] = K_base64[(inArray[num4] & 0xfc) >> 2];
            outArray[index + 1] = K_base64[((inArray[num4] & 3) << 4) | ((inArray[num4 + 1] & 240) >> 4)];
            outArray[index + 2] = K_base64[((inArray[num4 + 1] & 15) << 2) | ((inArray[num4 + 2] & 0xc0) >> 6)];
            outArray[index + 3] = K_base64[inArray[num4 + 2] & 0x3f];
            index += 4;
        }
        num4 = num2;
        switch ((length % 3)) {
        case 1:
            outArray[index] = K_base64[(inArray[num4] & 0xfc) >> 2];
            outArray[index + 1] = K_base64[(inArray[num4] & 3) << 4];
            outArray[index + 2] = K_base64[0x40];
            outArray[index + 3] = K_base64[0x40];
            index += 4;
            break;

        case 2:
            outArray[index] = K_base64[(inArray[num4] & 0xfc) >> 2];
            outArray[index + 1] = K_base64[((inArray[num4] & 3) << 4) | ((inArray[num4 + 1] & 240) >> 4)];
            outArray[index + 2] = K_base64[(inArray[num4 + 1] & 15) << 2];
            outArray[index + 3] = K_base64[0x40];
            index += 4;
            break;
        }
        return (index - offsetOut);
    }

    public static String ToBase64String(byte[] inArray, int offset, int length) {
        if (inArray == null) {
            throw new ArgumentNullException();
        }
        if (((length < 0) || (offset < 0)) || (offset > (inArray.length - length))) {
            throw new ArgumentOutOfRangeException();
        }
        int num = ((length / 3) * 4) + ((((length % 3) != 0) ? 1 : 0) * 4);
        char[] chArray = new char[num];
        return new String(chArray, 0, ToBase64CharArray(inArray, offset, length, chArray, 0));
    }

    public static String ToBase64String(byte[] inArray) {
        if (inArray == null) {
            throw new ArgumentNullException();
        }
        return ToBase64String(inArray, 0, inArray.length);
    }

    private static boolean IsLatin1(char ch) {
        char ex = 0x00ff;
        return (ch <= ex);
    }

    private static boolean IsWhiteSpaceLatin1(char c) {
        if (((c != ' ') && ((c < '\t') || (c > '\r'))) && ((c != (char) 0x00a0) && (c != (char) 0x0085))) {
            return false;
        }
        return true;
    }

    public static boolean IsWhiteSpace(char c) {
        if (IsLatin1(c)) {
            return IsWhiteSpaceLatin1(c);
        }
        return IsWhiteSpaceLatin1(c);
    }

    public static byte[] FromBase64String(String s) {
        if (s == null) {
            throw new ArgumentNullException();
        }

        char[] cc = s.toCharArray();
        return FromBase64CharArray(cc, 0, cc.length);

    }

    public static byte[] FromBase64CharArray(char[] pCharArray, int offset, int length) {
        if (pCharArray == null) {
            throw new ArgumentNullException();
        }
        if (offset > (pCharArray.length - length)) {
            throw new ArgumentOutOfRangeException();
        }
        if (pCharArray.length == 0) {
            throw new FormatException();
        }

        int num4;
        if (length < 0) {
            throw new ArgumentOutOfRangeException();
        }
        if (offset < 0) {
            throw new ArgumentOutOfRangeException();
        }
        if (length < 4) {
            throw new FormatException();
        }
        int num2 = 0;
        int num3 = 0;
        byte[] buffer = new byte[length];
        for (int i = offset; i < (length + offset); i++) {
            char c = pCharArray[i];
            if ((c >= 'A') && (c <= 'Z')) {
                buffer[num3++] = (byte) (c - 'A');
            }
            else if ((c >= 'a') && (c <= 'z')) {
                buffer[num3++] = (byte) ((c - 'a') + 0x1a);
            }
            else if ((c >= '0') && (c <= '9')) {
                buffer[num3++] = (byte) ((c - '0') + 0x34);
            }
            else if (c == '+') {
                buffer[num3++] = 0x3e;
            }
            else if (c == '/') {
                buffer[num3++] = 0x3f;
            }
            else if (!IsWhiteSpace(c)) {
                if (c != '=') {
                    throw new FormatException();
                }
                int num6 = (num3 - offset) % 4;
                if ((num6 == 3) || ((num6 == 2) && (pCharArray[i + 1] == '='))) {
                    buffer[num3++] = 0;
                    num2++;
                }
                else {
                    boolean flag = false;
                    num4 = i + 1;
                    while (num4 < (length + offset)) {
                        if (!IsWhiteSpace(pCharArray[num4])) {
                            if (pCharArray[num4] != '=') {
                                throw new FormatException();
                            }
                            if (flag) {
                                throw new FormatException();
                            }
                            flag = true;
                        }
                        num4++;
                    }
                    buffer[num3++] = 0;
                    num2++;
                }
                if ((num3 % 4) == 0) {
                    for (num4 = i + 1; num4 < (length + offset); num4++) {
                        if (!IsWhiteSpace(pCharArray[num4])) {
                            throw new FormatException();
                        }
                    }
                }
            }
        }
        int num = num3;
        if ((num % 4) > 0) {
            throw new FormatException();
        }
        int num7 = (num > 0) ? ((((num / 4) - 1) * 3) + (3 - num2)) : 0;
        num4 = 0;
        byte[] buffer2 = new byte[num7];
        for (int j = 0; j < num7; j += 3) {
            int num8 = (byte) ((buffer[num4] << 2) & 0xfc);
            num8 = (byte) (num8 | ((buffer[num4 + 1] >> 4) & 3));
            int num9 = (byte) ((buffer[num4 + 1] << 4) & 240);
            num9 = (byte) (num9 | ((buffer[num4 + 2] >> 2) & 15));
            int num10 = (byte) ((buffer[num4 + 2] << 6) & 0xc0);
            num10 = (byte) (num10 | buffer[num4 + 3]);
            num4 += 4;
            buffer2[j] = (byte) num8;
            if ((j + 1) < num7) {
                buffer2[j + 1] = (byte) num9;
            }
            if ((j + 2) < num7) {
                buffer2[j + 2] = (byte) num10;
            }
        }
        return buffer2;

    }
}
