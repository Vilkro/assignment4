package com.company.controllers;

import com.company.entities.Medicine;
import com.company.repositories.interfaces.medlist;

import java.sql.Date;
import java.util.List;

public class control {
    private final medlist repo;

    public control(medlist repo) {
        this.repo = repo;
    }

    public String addMedicine(String name, double price, Date expDate, String manufacturer) {
        Medicine medicine = new Medicine(name, price, expDate, manufacturer);

        boolean created = repo.addMedicine(medicine);

        return (created ? "Medicine was created" : "Medicine creation was failed");
    }

    public String getMedicineById(int id) {
        Medicine medicine = repo.getMedicine(id);

        return (medicine == null ? "Medicine was not found" : medicine.toString());
    }

    public String getMedicineByName(String name){
        Medicine medicines = repo.getMedicineByName(name);

        return(medicines == null ? "Medicine was not found" : medicines.toString());
    }

    public String deleteMedicineById(int id){
        boolean deleted = repo.removeMedicineById(id);

        return deleted ? "Medicine deleted successfully" : "Medicine deletion was failed";
    }

    public void createTable(){
        boolean created = repo.createTable();
        System.out.println(created ? "Table medicine created successfully" : "Table creation error");
    }

    public String getAllMedicines() {
        List<Medicine> medicines = repo.getAllMedicines();
        if(medicines.size() == 0){
            return "Medicines were not found. Please add new medicine.";
        } else {
            return medicines.toString();
        }
    }
}
