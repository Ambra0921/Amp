import com.czy.A;
import com.czy.TestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author caizy
 * @date 2020/8/6 15:08
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootDemoTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test(){
        A  a = applicationContext.getBean(A.class);
        System.out.println(a);
    }
}
