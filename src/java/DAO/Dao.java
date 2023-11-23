/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import Model.Category;
import Model.Product;
import Utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quang
 */
public class Dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String querry = "select *from product";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String querry = "select *from Category";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLast() {
        String querry = "select top 1 *from product order by id desc";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> getAllProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String querry = "select *from product where cateID = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByID(String id) {
        String querry = "select *from product where id = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> getAllProductByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String querry = "select *from product where [name] like ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Account login(String user, String pass) {
        String querry = "select *from Account where [user] = ? and pass = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account CheckAccountExist(String user) {
        String querry = "select *from Account where [user] = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void signup(String user, String pass) {
        String querry = "insert into Account \n"
                + "values (?,?,0,0)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate(); //khong tra ve bang result nen phai dung excute update
        } catch (Exception e) {
        }
    }

    public List<Product> getAllProductBySellID(int id) {
        List<Product> list = new ArrayList<>();
        String querry = "select *from product where sell_ID = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void delete(String id) {
        String querry = "delete from product where id = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, id);
            ps.executeUpdate(); //khong tra ve bang result nen phai dung excute update
        } catch (Exception e) {
        }
    }

    public void insert(String name, String image,
            String price, String title, String description,
            String category, int sid) {
        String querry = "insert into product\n"
                + "([name],[image],[price],[title],[description],[cateID],[sell_ID])\n"
                + "values (?,?,?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeUpdate(); //khong tra ve bang result nen phai dung excute update
        } catch (Exception e) {
        }
    }

    public void edit(String name, String image,
            String price, String title, String description,
            String category, String pid) {
        String querry = "update product\n"
                + "set [name] = ?,\n"
                + "[image] = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "[description] = ?,\n"
                + "cateID = ?\n"
                + "where id = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(querry);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate(); //khong tra ve bang result nen phai dung excute update
        } catch (Exception e) {  }
    }
      

//    public static void main(String[] args) {
//        Dao dao = new Dao();
//        List<Category> list = dao.getAllCategory();
//        for (Category o : list) {
//            System.out.println(o);
//        }
//    }
}
