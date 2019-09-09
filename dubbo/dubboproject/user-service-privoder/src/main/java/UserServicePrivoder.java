/**
 * Created by xuebi on 2019/9/9.
 */

import com.sun.glass.ui.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.io.IOException;

/**
 * @ClassName UserServicePrivoder
 * @Description TODO
 * @Author xuebi
 * @Date 2019/9/9 11:15
 * @Version 1.0
 */
public class UserServicePrivoder {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("privoder.xml");
        context.start();
        System.out.println("客户端启动成功!");
        System.in.read();
    }
}
