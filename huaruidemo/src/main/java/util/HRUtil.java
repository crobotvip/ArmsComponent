package util;

import android.text.TextUtils;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016/9/22.
 */
public class HRUtil {
    private static String SUCCESS_CODE = "000000";

    //判断输入的内容是否为空
    public static Boolean isNull(EditText et) {
        String str = et.getText().toString().trim();
        if (null == str || TextUtils.isEmpty(str) || "".equals(str)) {
            return true;
        }
        return false;
    }

    //判断获取到的returnCode是否为“000000”
    public static Boolean notNull(String code) {
        if (null != code && !TextUtils.isEmpty(code) && !"".equals(code)) {
            if (SUCCESS_CODE.equals(code)) {
                return true;
            }
            return false;
        }
        return false;
    }

    //将获取信息以逗号切割显示在输入框中
    public static void splitString(String str, EditText et) {
        String[] arr = str.split("\\,");
        String info = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                info = arr[0];
            } else {
                info += "," + "\n" + arr[i];
            }
        }
        et.setText(info);
    }

    public static String signOrderPay(String appID, String body, String mchID, String outTradeNo, String totalFee, String random, String secretKey) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("appID=" + appID + "&");
        buffer.append("body=" + body + "&");
        buffer.append("mchID=" + mchID + "&");
        buffer.append("outTradeNo=" + outTradeNo + "&");
        buffer.append("totalFee=" + totalFee + "&");
        buffer.append("random=" + random + "&");
        buffer.append("key=" + secretKey);
        return getMD5(buffer.toString()).toUpperCase();
    }

    public static String signLogin(String appID, String random, String secretKey) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("appID=" + appID + "&");
        buffer.append("random=" + random + "&");
        buffer.append("key=" + secretKey);
        return getMD5(buffer.toString()).toUpperCase();
    }

    public static String getMD5(String val) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(val.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

}
