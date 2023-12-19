package com.example.splitwisedec22prep.commands;

import com.example.splitwisedec22prep.controllers.SettleUpController;
import com.example.splitwisedec22prep.dto.SettleUpUserRequestDTO;
import com.example.splitwisedec22prep.dto.SettleUpUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class SettleUpUserCommand implements Command{
    private SettleUpController settleUpController;
    @Autowired
    SettleUpUserCommand(SettleUpController settleUpController){
        this.settleUpController = settleUpController;
    }
    @Override
    public boolean matches(String input) {
        // userID SettleUp
        List<String> words = List.of(input.split(" "));
        if(words.size() == 2 && words.get(1).equals("SettleUp")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(0));

        SettleUpUserRequestDTO request = new SettleUpUserRequestDTO();
        request.setUserId(userId);

        SettleUpUserResponseDTO responseDTO = settleUpController.settleUpUser(request);
    }
}

// user1 amt AddExpense