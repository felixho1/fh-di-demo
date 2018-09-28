package ho.felix.didemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource("classpath:datasource.properties")
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:data2.properties")
})
public class DataSourceConfig {
    private Environment env;

    @Value("${felix.username}")
    private String username;
    @Value("${felix.password}")
    private String password;
    @Value("${felix.url}")
    private String url;
    @Value("${felix.driver}")
    private String driver;

    public DataSourceConfig(Environment env) {
        this.env = env;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getRsPassword() {
        return env.getProperty("RS_PASSWORD");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
