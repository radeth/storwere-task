package com.company;

import com.company.model.CommandModel;
import com.company.model.CommandType;
import com.company.model.InstructionModel;

import java.util.List;

public class InstructionService {

    public static Long getResult(List<InstructionModel> instructionModelList) throws Exception {
        Long output = null;
        if (checkCommandType(instructionModelList.get(instructionModelList.size() - 1).getCommand()) == CommandType.APPLY) {
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
                        if(instructionModel.getValue().equals(0L)){
                            throw new Exception("Divide by 0 is not allowed");
                        }else{
                            commandModel.divide(instructionModel.getValue());
                        }
                        break;
                    case SUBTRACT:
                        commandModel.subtract(instructionModel.getValue());
                        break;
                    case APPLY:
                        throw new Exception("Command apply is allowed only as last command");
                    default:

                }
            }
            output = commandModel.getOutput();
        } else {
            throw new Exception("Command apply is required last");
        }
        return output;
    }

    public static CommandType checkCommandType(String command) throws Exception {
        if (command.equals("add")) {
            return CommandType.ADD;
        } else if (command.equals("multiply")) {
            return CommandType.MULTIPLE;
        } else if (command.equals("subtract")) {
            return CommandType.SUBTRACT;
        } else if (command.equals("divide")) {
            return CommandType.DIVIDE;
        } else if (command.equals("apply")) {
            return CommandType.APPLY;
        } else {
            throw new Exception("Wrong command " + command);
        }
    }
}
