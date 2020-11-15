package com.company;

import com.company.model.CommandModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileLoader {

    public static List<CommandModel> getCommandModelList() {

        InputStream in = FileLoader.class.getResourceAsStream("resources/data");
        List<CommandModel> commandModelList = new ArrayList<CommandModel>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                CommandModel commandModel = new CommandModel();
                commandModel.setCommand((line.split(" ")[0]));
                commandModel.setValue(java.lang.Long.parseLong(line.split(" ")[1]));
                commandModelList.add(commandModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commandModelList;
    }
}
