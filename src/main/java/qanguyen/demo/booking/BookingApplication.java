package qanguyen.demo.booking;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class BookingApplication {

    @Value("${spring.datasource.url}")
    private String url;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BookingApplication.class);
        printStartupInfo(application.run(args).getEnvironment());
    }

    static void printStartupInfo(Environment environment) {
        log.info("\n\n" + // NOPMD
                        "================================================================================================\n" +
                        "\n" +
                        "\tActive Profile(s): \t\t\t{}\n" +
                        "\tDB URL: \t\t\t{}\n" +
                        "\n" +
                        "================================================================================================\n",
                environment.getActiveProfiles(),
                environment.getProperty("spring.datasource.url")
        );
    }

}
