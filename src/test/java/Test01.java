import com.user.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zzq
 */
public class Test01 {

    AccountService accountService = null;

    @Before
    public void init(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        accountService = (AccountService) applicationContext.getBean("accountService");

    }

    @Test
    public void testTransfer(){
        accountService.transfer("张三", "李四", 100.f);
    }
}
