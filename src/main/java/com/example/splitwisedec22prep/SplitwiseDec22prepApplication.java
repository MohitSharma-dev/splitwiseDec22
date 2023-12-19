package com.example.splitwisedec22prep;

import com.example.splitwisedec22prep.commands.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@EnableJpaAuditing
@SpringBootApplication
public class SplitwiseDec22prepApplication implements CommandLineRunner {
    private CommandExecutor commandExecutor;
    private Scanner sc = new Scanner(System.in);

    @Autowired
    SplitwiseDec22prepApplication(CommandExecutor commandExecutor){
        this.commandExecutor = commandExecutor;
    }
    @Override
    public void run(String... args) throws Exception {
        while(true){
            String input = sc.next();
            commandExecutor.execute(input);
        }
    }

    public static void main(String[] args) {

        SpringApplication.run(SplitwiseDec22prepApplication.class, args);
    }

}


// /settleUp : Associated to User
// /settleUpGroup: associated to Group