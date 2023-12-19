package com.example.splitwisedec22prep.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    List<Command> commands;

    @Autowired
    CommandExecutor(SettleUpUserCommand settleUpUserCommand) {
        commands.add(settleUpUserCommand);
    }
    public void addCommand(){
    }

    public void removeCommand(){
    }

    public void execute(String input){
        for(Command command : commands){
            if(command.matches(input)){
                command.execute(input);
                break;
            }
        }
        throw new RuntimeException("Command not found");
    }

}
