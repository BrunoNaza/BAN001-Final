/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package criadorpersonagensrpg;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author bruni
 */
public class PlayerController {
    
    public void createPlayer(Connection con) throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a criar um novojogador: ");
        System.out.print("Nickname: ");
        String nickname = input.next();
        System.out.print("Senha: ");
        String password = input.next();
        
        PlayerBean pb = new PlayerBean(nickname, password);
        PlayerModel.create(pb, con);
        System.out.println("Jogador criado com sucesso");
    }
    
    void listarPlayer(Connection con) throws SQLException{
        HashSet all = PlayerModel.listAll(con);
        Iterator<PlayerBean> it = all.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());            
        }
    }
    
    
}
