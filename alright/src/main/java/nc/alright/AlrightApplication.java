package nc.alright;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
//@EnableTransactionManagement
public class AlrightApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlrightApplication.class, args);
	}

}
