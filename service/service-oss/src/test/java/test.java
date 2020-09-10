import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author ZZD
 * @Date 2020/9/10 20:04
 * @Email 1396896729@qq.com
 * @description
 */
public class test {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        /*int i = calendar.get(Calendar.DATE);*/
        int i = calendar.get(Calendar.YEAR);
        System.out.println(i);


    }
}
