package com.company;

import com.company.model.CommandModel;
import com.company.model.CommandType;
import com.company.model.InstructionModel;

import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        if(args.length == 1){
            List<InstructionModel> instructionModelList = FileLoader.getCommandModelList(args[0]);
            System.out.println(InstructionService.getResult(instructionModelList));
        }else{
            throw new Exception("You have to pass the argument");
        }

    }



}