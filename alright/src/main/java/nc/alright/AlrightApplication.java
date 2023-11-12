package nc.alright;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
public class AlrightApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlrightApplication.class, args);
	}

}
