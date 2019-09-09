/**
 * Created by xuebi on 2019/9/9.
 */

import com.kong.bean.UserAddress;
import com.kong.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName UserServiceConsumer
 * @Description TODO
 * @Author xuebi
 * @Date 2019/9/9 11:36
 * @Version 1.0
 */
public class UserServiceConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("服务端启动成功!");
        UserService UserService = (UserService) context.getBean("userService"); // 获取远程服务代理
        List<UserAddress> userAddressList = UserService.getUserAddressList("1");// 执行远程方法
        System.out.println(userAddressList);
    }
}
