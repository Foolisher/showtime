package google;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.junit.Test;

/**
 * Created by fuxiao(付笑) on 2018/6/26.
 */
public class DateTimeTest {

    public static void main(String[] args) {

        DateTime dateTime = DateTime.now().plusHours(4);
        DateTime now      = DateTime.now();

        Hours hours = Hours.hoursBetween(now, dateTime);

        System.out.println(hours.getHours());

    }

}
