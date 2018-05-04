package utils.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *
 *
 * convert 10:00:28 AM to time
 * Created by yanya04 on 4/16/2018.
 */
public class TestTimeConversion
{
    public static void main(String[] args) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        Date date1 = sdf.parse("10:00:28 AM");
        Date date2 = sdf.parse("10:00:29 AM");

        System.out.println(date1.getTime());
        System.out.println(date2.getTime());
    }

}
