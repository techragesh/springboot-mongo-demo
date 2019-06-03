package com.techragesh.sprinbootmongodemo;

import com.techragesh.sprinbootmongodemo.model.Role;
import com.techragesh.sprinbootmongodemo.repository.RoleDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SprinbootMongoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprinbootMongoDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(RoleDao roleDao) {

        return args -> {

            Role adminRole = roleDao.findByRole("ADMIN");
            if (adminRole == null) {
                Role newAdminRole = new Role();
                newAdminRole.setRole("ADMIN");
                roleDao.save(newAdminRole);
            }
        };

    }
}
