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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruni
 */
public class PlayerModel {
    
    static void create(PlayerBean pb, Connection con) throws SQLException{
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO player (nickname, password) VALUES (?, ?)");
            st.setString(1, pb.getNickname());
            st.setString(2, pb.getPassword());
            st.execute();
            st.close();
    }
    
    static HashSet listAll(Connection con) throws SQLException{
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT nickname, password FROM player";
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
                list.add(new PlayerBean(result.getString(1), result.getString(2)));   
            }
            return list;
    }
    
}
