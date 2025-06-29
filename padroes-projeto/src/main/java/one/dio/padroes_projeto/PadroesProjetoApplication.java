package one.dio.padroes_projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class PadroesProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoApplication.class, args);
	}

}
