package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.iid.InstanceID;
import com.google.firebase.FirebaseError;
import java.util.Arrays;
import java.util.List;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharUtils;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzao {
    private static Status zza(String str, String str2) {
        int i;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2130504259:
                if (str.equals("USER_CANCELLED")) {
                    c = 0;
                    break;
                }
                break;
            case -2065866930:
                if (str.equals("INVALID_RECIPIENT_EMAIL")) {
                    c = 1;
                    break;
                }
                break;
            case -2014808264:
                if (str.equals("WEB_CONTEXT_ALREADY_PRESENTED")) {
                    c = 2;
                    break;
                }
                break;
            case -2005236790:
                if (str.equals("INTERNAL_SUCCESS_SIGN_OUT")) {
                    c = 3;
                    break;
                }
                break;
            case -2001169389:
                if (str.equals("INVALID_IDP_RESPONSE")) {
                    c = 4;
                    break;
                }
                break;
            case -1944433728:
                if (str.equals("DYNAMIC_LINK_NOT_ACTIVATED")) {
                    c = 5;
                    break;
                }
                break;
            case -1800638118:
                if (str.equals("QUOTA_EXCEEDED")) {
                    c = 6;
                    break;
                }
                break;
            case -1774756919:
                if (str.equals("WEB_NETWORK_REQUEST_FAILED")) {
                    c = 7;
                    break;
                }
                break;
            case -1699246888:
                if (str.equals("INVALID_RECAPTCHA_VERSION")) {
                    c = 8;
                    break;
                }
                break;
            case -1603818979:
                if (str.equals("RECAPTCHA_NOT_ENABLED")) {
                    c = 9;
                    break;
                }
                break;
            case -1587614300:
                if (str.equals("EXPIRED_OOB_CODE")) {
                    c = 10;
                    break;
                }
                break;
            case -1584641425:
                if (str.equals("UNAUTHORIZED_DOMAIN")) {
                    c = 11;
                    break;
                }
                break;
            case -1583894766:
                if (str.equals("INVALID_OOB_CODE")) {
                    c = 12;
                    break;
                }
                break;
            case -1458751677:
                if (str.equals("MISSING_EMAIL")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case -1421414571:
                if (str.equals("INVALID_CODE")) {
                    c = 14;
                    break;
                }
                break;
            case -1345867105:
                if (str.equals("TOKEN_EXPIRED")) {
                    c = 15;
                    break;
                }
                break;
            case -1340100504:
                if (str.equals("INVALID_TENANT_ID")) {
                    c = 16;
                    break;
                }
                break;
            case -1242922234:
                if (str.equals("ALTERNATE_CLIENT_IDENTIFIER_REQUIRED")) {
                    c = 17;
                    break;
                }
                break;
            case -1232010689:
                if (str.equals("INVALID_SESSION_INFO")) {
                    c = 18;
                    break;
                }
                break;
            case -1202691903:
                if (str.equals("SECOND_FACTOR_EXISTS")) {
                    c = 19;
                    break;
                }
                break;
            case -1112393964:
                if (str.equals("INVALID_EMAIL")) {
                    c = 20;
                    break;
                }
                break;
            case -1063710844:
                if (str.equals("ADMIN_ONLY_OPERATION")) {
                    c = 21;
                    break;
                }
                break;
            case -974503964:
                if (str.equals("MISSING_OR_INVALID_NONCE")) {
                    c = 22;
                    break;
                }
                break;
            case -863830559:
                if (str.equals("INVALID_CERT_HASH")) {
                    c = 23;
                    break;
                }
                break;
            case -828507413:
                if (str.equals("NO_SUCH_PROVIDER")) {
                    c = 24;
                    break;
                }
                break;
            case -749743758:
                if (str.equals("MFA_ENROLLMENT_NOT_FOUND")) {
                    c = 25;
                    break;
                }
                break;
            case -736207500:
                if (str.equals("MISSING_PASSWORD")) {
                    c = 26;
                    break;
                }
                break;
            case -646022241:
                if (str.equals("CREDENTIAL_TOO_OLD_LOGIN_AGAIN")) {
                    c = 27;
                    break;
                }
                break;
            case -595928767:
                if (str.equals(InstanceID.ERROR_TIMEOUT)) {
                    c = 28;
                    break;
                }
                break;
            case -505579581:
                if (str.equals("INVALID_REQ_TYPE")) {
                    c = 29;
                    break;
                }
                break;
            case -406804866:
                if (str.equals("INVALID_LOGIN_CREDENTIALS")) {
                    c = 30;
                    break;
                }
                break;
            case -380728810:
                if (str.equals("INVALID_RECAPTCHA_ACTION")) {
                    c = 31;
                    break;
                }
                break;
            case -333672188:
                if (str.equals("OPERATION_NOT_ALLOWED")) {
                    c = ' ';
                    break;
                }
                break;
            case -294485423:
                if (str.equals("WEB_INTERNAL_ERROR")) {
                    c = '!';
                    break;
                }
                break;
            case -217128228:
                if (str.equals("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                    c = Typography.quote;
                    break;
                }
                break;
            case -122667194:
                if (str.equals("MISSING_MFA_ENROLLMENT_ID")) {
                    c = '#';
                    break;
                }
                break;
            case -75433118:
                if (str.equals("USER_NOT_FOUND")) {
                    c = '$';
                    break;
                }
                break;
            case -52772551:
                if (str.equals("CAPTCHA_CHECK_FAILED")) {
                    c = '%';
                    break;
                }
                break;
            case -40686718:
                if (str.equals("WEAK_PASSWORD")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case 15352275:
                if (str.equals("EMAIL_NOT_FOUND")) {
                    c = '\'';
                    break;
                }
                break;
            case 210308040:
                if (str.equals("UNSUPPORTED_FIRST_FACTOR")) {
                    c = '(';
                    break;
                }
                break;
            case 269327773:
                if (str.equals("INVALID_SENDER")) {
                    c = ')';
                    break;
                }
                break;
            case 278802867:
                if (str.equals("MISSING_PHONE_NUMBER")) {
                    c = '*';
                    break;
                }
                break;
            case 408411681:
                if (str.equals("INVALID_DYNAMIC_LINK_DOMAIN")) {
                    c = '+';
                    break;
                }
                break;
            case 423563023:
                if (str.equals("MISSING_MFA_PENDING_CREDENTIAL")) {
                    c = ',';
                    break;
                }
                break;
            case 429251986:
                if (str.equals("UNSUPPORTED_PASSTHROUGH_OPERATION")) {
                    c = '-';
                    break;
                }
                break;
            case 483847807:
                if (str.equals("EMAIL_EXISTS")) {
                    c = '.';
                    break;
                }
                break;
            case 491979549:
                if (str.equals("INVALID_ID_TOKEN")) {
                    c = IOUtils.DIR_SEPARATOR_UNIX;
                    break;
                }
                break;
            case 492072102:
                if (str.equals("WEB_STORAGE_UNSUPPORTED")) {
                    c = '0';
                    break;
                }
                break;
            case 492515765:
                if (str.equals("MISSING_CLIENT_TYPE")) {
                    c = '1';
                    break;
                }
                break;
            case 530628231:
                if (str.equals("MISSING_RECAPTCHA_VERSION")) {
                    c = '2';
                    break;
                }
                break;
            case 542728406:
                if (str.equals("PASSWORD_LOGIN_DISABLED")) {
                    c = '3';
                    break;
                }
                break;
            case 582457886:
                if (str.equals("UNVERIFIED_EMAIL")) {
                    c = '4';
                    break;
                }
                break;
            case 605031096:
                if (str.equals("REJECTED_CREDENTIAL")) {
                    c = '5';
                    break;
                }
                break;
            case 745638750:
                if (str.equals("INVALID_MFA_PENDING_CREDENTIAL")) {
                    c = '6';
                    break;
                }
                break;
            case 786916712:
                if (str.equals("INVALID_VERIFICATION_PROOF")) {
                    c = '7';
                    break;
                }
                break;
            case 799258561:
                if (str.equals("INVALID_PROVIDER_ID")) {
                    c = '8';
                    break;
                }
                break;
            case 819646646:
                if (str.equals("CREDENTIAL_MISMATCH")) {
                    c = '9';
                    break;
                }
                break;
            case 844240628:
                if (str.equals("WEB_CONTEXT_CANCELED")) {
                    c = ':';
                    break;
                }
                break;
            case 886186878:
                if (str.equals("REQUIRES_SECOND_FACTOR_AUTH")) {
                    c = ';';
                    break;
                }
                break;
            case 895302372:
                if (str.equals("MISSING_CLIENT_IDENTIFIER")) {
                    c = Typography.less;
                    break;
                }
                break;
            case 922685102:
                if (str.equals("INVALID_MESSAGE_PAYLOAD")) {
                    c = '=';
                    break;
                }
                break;
            case 989000548:
                if (str.equals("RESET_PASSWORD_EXCEED_LIMIT")) {
                    c = Typography.greater;
                    break;
                }
                break;
            case 1034932393:
                if (str.equals("INVALID_PENDING_TOKEN")) {
                    c = '?';
                    break;
                }
                break;
            case 1072360691:
                if (str.equals("INVALID_CUSTOM_TOKEN")) {
                    c = '@';
                    break;
                }
                break;
            case 1094975491:
                if (str.equals("INVALID_PASSWORD")) {
                    c = 'A';
                    break;
                }
                break;
            case 1107081238:
                if (str.equals("<<Network Error>>")) {
                    c = 'B';
                    break;
                }
                break;
            case 1113992697:
                if (str.equals("INVALID_RECAPTCHA_TOKEN")) {
                    c = 'C';
                    break;
                }
                break;
            case 1141576252:
                if (str.equals("SESSION_EXPIRED")) {
                    c = 'D';
                    break;
                }
                break;
            case 1199811910:
                if (str.equals("MISSING_CODE")) {
                    c = 'E';
                    break;
                }
                break;
            case 1226505451:
                if (str.equals("FEDERATED_USER_ID_ALREADY_LINKED")) {
                    c = 'F';
                    break;
                }
                break;
            case 1308491624:
                if (str.equals("MISSING_RECAPTCHA_TOKEN")) {
                    c = 'G';
                    break;
                }
                break;
            case 1388786705:
                if (str.equals("INVALID_IDENTIFIER")) {
                    c = 'H';
                    break;
                }
                break;
            case 1433767024:
                if (str.equals("USER_DISABLED")) {
                    c = 'I';
                    break;
                }
                break;
            case 1442968770:
                if (str.equals("INVALID_PHONE_NUMBER")) {
                    c = 'J';
                    break;
                }
                break;
            case 1494923453:
                if (str.equals("INVALID_APP_CREDENTIAL")) {
                    c = 'K';
                    break;
                }
                break;
            case 1497901284:
                if (str.equals("TOO_MANY_ATTEMPTS_TRY_LATER")) {
                    c = 'L';
                    break;
                }
                break;
            case 1803454477:
                if (str.equals("MISSING_CONTINUE_URI")) {
                    c = 'M';
                    break;
                }
                break;
            case 1898790704:
                if (str.equals("MISSING_SESSION_INFO")) {
                    c = 'N';
                    break;
                }
                break;
            case 2063209097:
                if (str.equals("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                    c = 'O';
                    break;
                }
                break;
            case 2082564316:
                if (str.equals("UNSUPPORTED_TENANT_OPERATION")) {
                    c = 'P';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                i = 18001;
                break;
            case 1:
                i = 17033;
                break;
            case 2:
                i = 17057;
                break;
            case 3:
                i = 17091;
                break;
            case 4:
            case 30:
            case '?':
                i = FirebaseError.ERROR_INVALID_CREDENTIAL;
                break;
            case 5:
                i = 17068;
                break;
            case 6:
                i = 17052;
                break;
            case 7:
                i = 17061;
                break;
            case 8:
                i = 17206;
                break;
            case 9:
                i = 17200;
                break;
            case 10:
                i = 17029;
                break;
            case 11:
                i = 17038;
                break;
            case 12:
                i = 17030;
                break;
            case 13:
                i = 17034;
                break;
            case 14:
                i = 17044;
                break;
            case 15:
                i = FirebaseError.ERROR_USER_TOKEN_EXPIRED;
                break;
            case 16:
                i = 17079;
                break;
            case 17:
                i = 18002;
                break;
            case 18:
                i = 17046;
                break;
            case 19:
                i = 17087;
                break;
            case 20:
            case 'H':
                i = FirebaseError.ERROR_INVALID_EMAIL;
                break;
            case 21:
                i = 17085;
                break;
            case 22:
                i = 17094;
                break;
            case 23:
                i = 17064;
                break;
            case 24:
                i = FirebaseError.ERROR_NO_SUCH_PROVIDER;
                break;
            case 25:
                i = 17084;
                break;
            case 26:
                i = 17035;
                break;
            case 27:
                i = FirebaseError.ERROR_REQUIRES_RECENT_LOGIN;
                break;
            case 28:
            case 'B':
                i = FirebaseError.ERROR_NETWORK_REQUEST_FAILED;
                break;
            case 29:
                i = 17207;
                break;
            case 31:
                i = 17203;
                break;
            case ' ':
            case '3':
                i = FirebaseError.ERROR_OPERATION_NOT_ALLOWED;
                break;
            case '!':
                i = 17062;
                break;
            case '\"':
                i = 17088;
                break;
            case '#':
                i = 17082;
                break;
            case '$':
            case '\'':
                i = FirebaseError.ERROR_USER_NOT_FOUND;
                break;
            case '%':
                i = 17056;
                break;
            case '&':
                i = FirebaseError.ERROR_WEAK_PASSWORD;
                break;
            case '(':
                i = 17089;
                break;
            case ')':
                i = 17032;
                break;
            case '*':
                i = 17041;
                break;
            case '+':
                i = 17074;
                break;
            case ',':
                i = 17081;
                break;
            case '-':
                i = 17095;
                break;
            case '.':
                i = FirebaseError.ERROR_EMAIL_ALREADY_IN_USE;
                break;
            case '/':
                i = FirebaseError.ERROR_INVALID_USER_TOKEN;
                break;
            case '0':
                i = 17065;
                break;
            case '1':
                i = 17204;
                break;
            case '2':
                i = 17205;
                break;
            case '4':
                i = 17086;
                break;
            case '5':
                i = 17075;
                break;
            case '6':
                i = 17083;
                break;
            case '7':
                i = 17049;
                break;
            case '8':
                i = 17071;
                break;
            case '9':
                i = FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH;
                break;
            case ':':
                i = 17058;
                break;
            case ';':
                i = 17078;
                break;
            case '<':
                i = 17093;
                break;
            case '=':
                i = 17031;
                break;
            case '>':
            case 'L':
                i = FirebaseError.ERROR_TOO_MANY_REQUESTS;
                break;
            case '@':
                i = FirebaseError.ERROR_INVALID_CUSTOM_TOKEN;
                break;
            case 'A':
                i = FirebaseError.ERROR_WRONG_PASSWORD;
                break;
            case 'C':
                i = 17202;
                break;
            case 'D':
                i = 17051;
                break;
            case 'E':
                i = 17043;
                break;
            case 'F':
                i = FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE;
                break;
            case 'G':
                i = 17201;
                break;
            case 'I':
                i = FirebaseError.ERROR_USER_DISABLED;
                break;
            case 'J':
                i = 17042;
                break;
            case 'K':
                i = FirebaseError.ERROR_APP_NOT_AUTHORIZED;
                break;
            case 'M':
                i = 17040;
                break;
            case 'N':
                i = 17045;
                break;
            case 'O':
                i = 17090;
                break;
            case 'P':
                i = 17073;
                break;
            default:
                i = 17499;
                break;
        }
        if (i != 17499) {
            return new Status(i, str2);
        }
        if (str2 != null) {
            return new Status(i, str + CertificateUtil.DELIMITER + str2);
        }
        return new Status(i, str);
    }

    public static Status zza(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new Status(FirebaseError.ERROR_INTERNAL_ERROR);
        }
        String[] split = str.split(CertificateUtil.DELIMITER, 2);
        split[0] = split[0].trim();
        if (split.length > 1 && (str2 = split[1]) != null) {
            split[1] = str2.trim();
        }
        List asList = Arrays.asList(split);
        if (asList.size() > 1) {
            return zza((String) asList.get(0), (String) asList.get(1));
        }
        return zza((String) asList.get(0), (String) null);
    }
}
