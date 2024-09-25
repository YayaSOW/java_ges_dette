package org.example.data.repositories.bdSQL;

import org.example.data.entities.User;
import org.example.data.repositories.ClientRepository;
import org.example.core.repository.impl.RepositoryBDImp;
import org.example.data.entities.Client;
import org.example.data.repositories.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryBD extends RepositoryBDImp<Client> implements ClientRepository {
    UserRepository userRepository = new UserRepositoryBD();

    public ClientRepositoryBD() {
        this.tableName = "client";
    }

    @Override
    public void insert(Client data) {
        int nbr = 0;
        User user = data.getUser();
        try {
            if (user != null) {
                userRepository.insert(user);
            }
            String req = String.format("INSERT INTO %s (`surname`, `telephone`, `address`, userId) VALUES (?, ?, ?,?);",this.tableName);
            this.getConnection();
            this.initPreparedStatement(req);
            this.ps.setString(1, data.getSurname());
            this.ps.setString(2, data.getTelephone());
            this.ps.setString(3, data.getAddress());
            if (user != null) {
                this.ps.setInt(4, user.getId());
            } else {
                this.ps.setNull(4, Types.INTEGER);
            }
            this.executeUpdate();
            ResultSet rs = this.ps.getGeneratedKeys();
            if (rs.next()) {
                data.setId(rs.getInt(1));
            }
//            System.out.println(nbr);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion avec la base de donnee");
        } finally {
//            try {
//                this.closeConnection();
//            }catch (SQLException e){
//                System.out.println("Erreur de fermeture de la BD");
//            }
        }
    }

    @Override
    public List<Client> selectAll() {
        List<Client> list = new ArrayList<>();
        try {
            String req ="SELECT * FROM `client`";
            this.getConnection();
            this.initPreparedStatement(req);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                list.add(this.convertToObject(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de connexion avec la base de donnee");
        } finally {
//            try {
//                this.closeConnection();
//            }catch (SQLException e){
//                System.out.println("Erreur de fermeture de la BD");
//            }
        }
        return list;
    }

    @Override
    public Client selectByTelephone(String telephone) {
        Client client = null;
        try {
//            String req = String.format("SELECT * FROM `client` WHERE `telephone` LIKE %s", telephone);
            String req = String.format("SELECT * FROM %s WHERE `telephone` LIKE ?", this.tableName);
            this.getConnection();
            this.initPreparedStatement(req);
            this.ps.setString(1, telephone);
            ResultSet rs = this.executeQuery();
            if (rs.next()) {
                client = this.convertToObject(rs);
            }
            rs.close();
        } catch (SQLException e){
            System.out.println("Erreur de connexion avec la base de donnee");
            e.printStackTrace();
        } finally {
//            try {
//                this.closeConnection();
//            }catch (SQLException e){
//                System.out.println("Erreur de fermeture de la BD");
//            }
        }
        return client;
    }

    @Override
    public Client convertToObject(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setId(rs.getInt("id"));
        client.setSurname(rs.getString("surname"));
        client.setTelephone(rs.getString("telephone"));
        client.setAddress(rs.getString("address"));
        int userId = rs.getInt("userId");
        User user = this.userRepository.selectById(userId);
        client.setUser(user);
        return client;

    }
}
