package com.company;

import com.company.model.InstructionModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileLoader {

    public static List<InstructionModel> getCommandModelList(String arg) {
        List<InstructionModel> instructionModelList = new ArrayList<InstructionModel>();
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(arg));
            String line = null;
            while ((line = reader.readLine()) != null) {
                InstructionModel instructionModel = new InstructionModel();
                instructionModel.setCommand((line.split(" ")[0]));
                instructionModel.setValue(java.lang.Long.parseLong(line.split(" ")[1]));
                instructionModelList.add(instructionModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  instructionModelList;
    }
}
