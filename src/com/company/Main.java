package com.company;

import com.company.controllers.control;
import com.company.data.interfaces.IDB;
import com.company.data.postgresql;
import com.company.repositories.mediciner;
import com.company.repositories.interfaces.medlist;

public class Main {

    public static void main(String[] args) {
        IDB db = new postgresql();
        medlist repo = new mediciner(db);
        control controller = new control(repo);
        Layer app = new Layer(controller);
        app.launch();
    }
}