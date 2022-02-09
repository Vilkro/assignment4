package com.company.repositories.interfaces;
import com.company.entities.Medicine;
import java.util.List;

public interface medlist {
    boolean createTable();

    boolean createMedicine(Medicine medicine);

    Medicine getMedicine(int id);

    List<Medicine> getAllMedicines();

    Medicine getMedicineByName(String name);

    boolean removeMedicineById(int id);
}