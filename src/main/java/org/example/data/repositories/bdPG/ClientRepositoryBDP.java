package org.example.data.repositories.bdPG;

import org.example.data.repositories.ClientRepository;
import org.example.data.entities.Client;
import org.example.core.repository.impl.RepositoryBDImp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryBDP extends RepositoryBDImp<Client> implements ClientRepository {
    private List<Client> list = new ArrayList<>();

    @Override
    public Client selectByTelephone(String telephone) {
        Connection conn = null;
        Client client = null;
        try {
//            String req = String.format("SELECT * FROM `client` WHERE `telephone` LIKE %s", telephone);
            String req = "SELECT * FROM client WHERE telephone LIKE ?";

            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ges_dette","postgres","yaya");
            PreparedStatement stmt = conn.prepareStatement(req);
            stmt.setString(1, telephone);
            ResultSet rs = stmt.executeQuery();
//            System.out.println(rs);
            while (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setSurname(rs.getString("surname"));
                client.setTelephone(rs.getString("telephone"));
                client.setAddress(rs.getString("address"));
            }
        }catch (ClassNotFoundException e){
            System.out.println("Erreur de chargement du driver Postgresql");
        }catch (SQLException e){
            System.out.println("Erreur de connexion avec la base de donnee postgresql");
        } finally {
            try {
                conn.close();
            }catch (SQLException e){
                System.out.println("Erreur de fermeture de la BD postgresql");
            }
        }
        return client;
    }

    @Override
    public void insert(Client data) {
        Connection conn = null;
        try {
        Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ges_dette","postgres","yaya");
            String req = "INSERT INTO client (surname, telephone, address) VALUES (?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(req);
            stmt.setString(1, data.getSurname());
            stmt.setString(2, data.getTelephone());
            stmt.setString(3, data.getAddress());
            int nbr = stmt.executeUpdate();
            System.out.println(nbr);
        }catch (ClassNotFoundException e){
            System.out.println("erreur de chargement du driver Postegre");
        }catch (SQLException e){
            System.out.println("erreur de connexion a la BD Postegre");
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Client> selectAll() {
        Connection conn = null;
        list.clear();
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ges_dette","postgres","yaya");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM client");
            while (res.next()) {
                Client client = new Client();
                client.setId(res.getInt("id"));
                client.setSurname(res.getString("surname"));
                client.setTelephone(res.getString("telephone"));
                client.setAddress(res.getString("address"));
                list.add(client);
            }
        }catch (ClassNotFoundException e){
            System.out.println("erreur de chargement du driver Postegre");
        }catch (SQLException e){
            System.out.println("erreur de connexion a la BD Postegre");
        }finally {
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Client convertToObject(ResultSet rs) throws SQLException {
        return null;
    }
}
