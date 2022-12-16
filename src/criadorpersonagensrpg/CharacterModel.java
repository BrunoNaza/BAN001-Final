/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package criadorpersonagensrpg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bruni
 */
public class CharacterModel {
    
    public static void create(CharacterBean cb, Connection con) throws SQLException{
        PreparedStatement st;
            
        st = con.prepareStatement ("INSERT INTO characters (nome, alinhamento, idade, xp, money, codc, nickname) VALUES (?, ?, ?, ?, ?, ?, ?)");
        st.setString(1, cb.getNome());
        st.setString(2, cb.getAlinhamento());
        st.setInt(3, cb.getIdade());
        st.setInt(4, cb.getXp());
        st.setInt(5, cb.getMoney());
        st.setInt(6, cb.getCodc());
        st.setString(7, cb.getNickname());
        st.execute();
        st.close();
    }
    
    static HashSet listAll (Connection con ) throws SQLException{
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT nome, alinhamento, idade, xp, money, codc, nickname FROM characters";
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
                list.add(new CharacterBean(result.getString(1), result.getString(2), result.getInt(3), result.getInt(4), result.getInt(5), result.getInt(6), result.getString(7)));   
            }
            return list;
    }
    
    static HashSet listAllWithPlayer(Connection con) throws SQLException{
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT nome, alinhamento, idade, xp, money, codc, nickname, password FROM player NATURAL JOIN characters";
        ResultSet result = st.executeQuery(sql);
        while(result.next()){
            CharacterBean cb = new CharacterBean(result.getString(1), result.getString(2), result.getInt(3), result.getInt(4), result.getInt(5), result.getInt(6), result.getString(7));
            PlayerBean pb = new PlayerBean(result.getString(7),result.getString(8));            
            cb.setPlayer(pb);
            list.add(cb);
        }
        return list;    
    }
    
    static String listMaisXp(Connection con) throws SQLException{
        Statement st;
        st = con.createStatement();
        String sql = "select nome from characters where xp = (select max(xp) from characters)";
        ResultSet result = st.executeQuery(sql);
        result.next();
        String nome = result.getString("nome");
        result.close();
        return nome;
    }
    
}