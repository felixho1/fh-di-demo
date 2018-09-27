package ho.felix.didemo.config;

import ho.felix.didemo.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Configuration
public class GreetingServiceConfig {
    private GreetingRepository greetingRepository;

    public GreetingServiceConfig(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Bean
    @Profile("de")
    @Primary
    public GreetingService getGermanGreetingService() {
        return new PrimaryGermanGreetingService(this.greetingRepository);
    }

    @Bean
    @Profile({"en", "default"})
    @Primary
    public GreetingService getPrimaryGreetingService() {
        return new PrimaryGreetingService(this.greetingRepository);
    }

    @Bean
    @Profile("es")
    @Primary
    public GreetingService getSpanishGreetingService() {
        return new PrimarySpanishGreetingService(this.greetingRepository);
    }

}
