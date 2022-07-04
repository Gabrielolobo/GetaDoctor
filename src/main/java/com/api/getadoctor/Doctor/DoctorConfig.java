package com.api.getadoctor.Doctor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DoctorConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            DoctorRepository repository ) {
        return args -> {
            Doctor magnolia = new Doctor(
                "magnolia.silva@gmail.com",
                "shameonyou",
				"Magnolia",
				"Silva", 
				"(71)98990-7634"
			);
            Doctor kenobi = new Doctor(
                "general.kenobi@gmail.com",
                "hellothere",
                "Kenobi",
                "General",
                "(00)95678-8709"
            );
            Doctor gabriel = new Doctor(
                "usuario.teste-1@email.com",
                "letmein",
                "Gabriel",
                "Lobo",
                "(70)97070-7070"
            );
            Doctor luke = new Doctor(
                "usuario.teste-2@email.com",
                "imyourfather",
                "Luke",
                "Skywalker",
                "(11)23581-3213"
            );
            Doctor han = new Doctor(
                "usuario.teste-3@email.com",
                "iknow",
                "Han",
                "Solo",
                "(99)90808-0808"
            );
            repository.saveAll(
                List.of(magnolia, kenobi, gabriel, luke, han)
            
            );

        };
    }
}
