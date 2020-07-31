import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDataTest {

    @Test
    public void LocalDataTest1() {
        // 7/8 凌晨1点
        long one = 1594141200000l;
        System.out.println("one : " + one);
        LocalDateTime lt = Instant.ofEpochMilli(one).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        LocalDate localDate = Instant.ofEpochMilli(one).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        System.out.println("正确的 : " + lt);
        System.out.println("正确的 : " + localDate);
        System.out.println("正确的 : " + lt.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        System.out.println("正确的 : " + localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());

        System.out.println("==========");
        one = (one / (1000 * 60 * 60 * 24) + 1) * (1000 * 60 * 60 * 24);
        System.out.println("one : " + one);
        LocalDateTime time = Instant.ofEpochMilli(one).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        LocalDate localDate2 = Instant.ofEpochMilli(one).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        System.out.println("当前的lt ： " + time);
        System.out.println("当前的ld ： " + localDate2);
        System.out.println("当前的lt ms ： " + time.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        System.out.println("当前的ld ms ： " + localDate2.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
    }
}
