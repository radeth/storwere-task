package com.company;

import com.company.model.CommandModel;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileLoader reader = new FileLoader();
        List<CommandModel> commandModelList = FileLoader.getCommandModelList();
    }
}