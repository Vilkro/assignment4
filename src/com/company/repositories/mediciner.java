package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Medicine;
import com.company.repositories.interfaces.medlist;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class mediciner implements medlist {
    private final IDB db;

    public mediciner(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createTable() {
        Connection con = null;
        try{
            con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS medicine(id serial PRIMARY KEY, name VARCHAR(256), price int, expiration_date date, manufacturer VARCHAR(256))");
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean addMedicine(Medicine company) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO medicine(name, price, expiration_date, manufacturer) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, company.getName());
            st.setDouble(2, company.getPrice());
            st.setDate(3, (Date) company.getDate());
            st.setString(4, company.getManufacturer());

            st.execute();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Medicine getMedicine(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,expiration_date,manufacturer FROM medicine WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicine user = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getDate("expiration_date"),
                        rs.getString("manufacturer"));

                return user;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Medicine> getAllMedicines() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,expiration_date,manufacturer FROM medicine";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Medicine> users = new LinkedList<>();
            while (rs.next()) {
                Medicine user = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getDate("expiration_date"),
                        rs.getString("manufacturer"));

                users.add(user);
            }

            return users;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Medicine getMedicineByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,expiration_date,manufacturer FROM medicine WHERE name = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicine company = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getDate("expiration_date"),
                        rs.getString("manufacturer"));

                return company;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean removeMedicineById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM medicine WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.execute();

            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }
}