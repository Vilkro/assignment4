package com.company.repositories.interfaces;
import com.company.entities.Medicine;
import java.util.List;

public interface medlist {
    boolean createTable();

    boolean addMedicine(Medicine medicine);

    Medicine getMedicine(int id);

    Medicine getMedicineByName(String name);

    boolean removeMedicineById(int id);

    List<Medicine> getAllMedicines();
}