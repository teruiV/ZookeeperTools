package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jianwl on 2016/1/22.
 */
public class StringUtil {
    public static String DateFormat(Long dateTime){
        Date date = new Date(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static void main(String[] args) {
        String temp = DateFormat(System.currentTimeMillis());
        System.out.println("temp = " + temp);
    }
}
