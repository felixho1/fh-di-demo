package ho.felix.didemo;

import ho.felix.didemo.config.DataSourceConfig;
import ho.felix.didemo.controllers.ConstructorInjectedController;
import ho.felix.didemo.controllers.GetterInjectedController;
import ho.felix.didemo.controllers.MyController;
import ho.felix.didemo.controllers.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        System.out.println(controller.hello());
        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());

        System.out.println(ctx.getBean(DataSourceConfig.class).getPassword());
        System.out.println(ctx.getBean(DataSourceConfig.class).getRsPassword());
    }
}
