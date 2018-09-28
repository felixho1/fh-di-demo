package ho.felix.didemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Value("${felix.jms.user}")
    String felixJmsUser;
    @Value("${felix.jms.password}")
    String felixJmsPassword;

    public String getFelixJmsUser() {
        return felixJmsUser;
    }

    public String getFelixJmsPassword() {
        return felixJmsPassword;
    }
}
