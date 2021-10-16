import com.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Willam_xh
 * @create 2021-10-12 16:37
 */
public class MyTest05 {

    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        //从容器中获取对象

        Student student= (Student) ctx.getBean("myStudent");
        System.out.println(student);

    }
}
