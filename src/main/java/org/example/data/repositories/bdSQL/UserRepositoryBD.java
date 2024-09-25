package org.example.data.repositories.bdSQL;

import org.example.data.enums.RoleEnum;
import org.example.data.repositories.UserRepository;
import org.example.core.repository.impl.RepositoryBDImp;
import org.example.data.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryBD extends RepositoryBDImp<User> implements UserRepository {
    List<User> users = new ArrayList<>();
    public UserRepositoryBD(){
        this.tableName = "user";
    }
    @Override
    public User selectById(int id) {
        User result = null;
        try {
            String sql = "select * from user where id= ?";
            this.getConnection();
            this.initPreparedStatement(sql);
            this.ps.setInt(1, id);
            ResultSet rs = this.executeQuery();
            if (rs.next()) {
                result = this.convertToObject(rs);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
//            try {
//                this.closeConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
        return result;
    }

    @Override
    public User selectByLogin(String login) {
        User result = null;
        try {
            String sql = String.format("select * from %s where login like ?",this.tableName);
            this.getConnection();
            this.initPreparedStatement(sql);

            this.ps.setString(1, login);
            ResultSet rs = this.executeQuery();
            if (rs.next()) {
                result = this.convertToObject(rs);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
//            try {
//                this.closeConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
        return result;
    }

    @Override
    public void insert(User data) {
        try {
            String sql = "INSERT INTO `user` (`nom`, `prenom`, `login`, `password`, `role`, `etat`) VALUES (?,?,?,?,?, '1');";
            this.getConnection();
            this.initPreparedStatement(sql);
            this.ps.setString(1, data.getNom());
            this.ps.setString(2, data.getPrenom());
            this.ps.setString(3, data.getLogin());
            this.ps.setString(4, data.getPassword());
            this.ps.setString(5, data.getRole().name());
            this.executeUpdate();
            ResultSet rs = this.ps.getGeneratedKeys();
            if (rs.next()) {
                data.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            try {
//                this.closeConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public List<User> selectAll() {
        try {

            String sql = "select * from user";
            this.getConnection();
            this.initPreparedStatement(sql);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                users.add(this.convertToObject(rs));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
//            try {
//                this.closeConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
        return users;
    } @Override
    public User convertToObject(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setNom(rs.getString("nom"));
        user.setPrenom(rs.getString("prenom"));
        user.setLogin(rs.getString("login"));
        user.setRole(RoleEnum.getValue(rs.getString("role")));
        user.setEtat(rs.getBoolean("etat"));
        return user;

    }


}
