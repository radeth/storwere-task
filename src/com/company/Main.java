package com.company;

import com.company.model.CommandModel;
import com.company.model.CommandType;
import com.company.model.InstructionModel;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<InstructionModel> instructionModelList = FileLoader.getCommandModelList();
        CommandModel commandModel = new CommandModel(instructionModelList.get(instructionModelList.size() - 1).getValue());
        instructionModelList.remove(instructionModelList.size() - 1);

        for (InstructionModel instructionModel : instructionModelList) {
            switch (checkCommandType(instructionModel.getCommand())) {
                case ADD:
                    commandModel.add(instructionModel.getValue());
                    break;
                case MULTIPLE:
                    commandModel.multiple(instructionModel.getValue());
                    break;
                case DIVIDE:
                    commandModel.divide(instructionModel.getValue());
                    break;
                case SUBTRACT:
                    commandModel.subtract(instructionModel.getValue());
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
        System.out.println(commandModel.getOutput());
    }

    private static CommandType checkCommandType(String command) {
        if (command.equals("add")) {
            return CommandType.ADD;
        } else if (command.equals("multiply")) {
            return CommandType.MULTIPLE;
        } else if (command.equals("divide")) {
            return CommandType.DIVIDE;
        } else if (command.equals("subtract")) {
            return CommandType.SUBTRACT;
        } else if (command.equals("apply")) {
            return CommandType.APPLY;
        } else {
            return CommandType.INCORRECT;
        }
    }

}