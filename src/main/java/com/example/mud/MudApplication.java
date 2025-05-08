package com.example.mud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MudApplication.class, args);
    }

    @Bean
    public CommandLineRunner runGame() {
        return args -> {
            GameContext context = GameInitializer.init();
            GameEngine engine = new GameEngine(context);
            engine.start(); // 這行會觸發 Scanner 等命令列互動
        };
    }
}
