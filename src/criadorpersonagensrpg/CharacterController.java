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
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruni
 */
public class CharacterController {
   
    public void createCharacter(Connection con) throws SQLException {
       Scanner input = new Scanner(System.in);
       System.out.println("Insira os seguintes dados para a criar um novo Personagem: ");
       System.out.print("Nome: ");
       String nome = input.next(); 
       System.out.print("Alinhamento: ");
       String alinhamento = input.next(); 
       System.out.print("XP: ");
       int xp = input.nextInt(); 
       System.out.print("Idade: ");
       int idade = input.nextInt(); 
       System.out.print("Dinheiro: ");
       int money = input.nextInt(); 
       System.out.print("Codigo: ");
       int codc = input.nextInt(); 
       System.out.print("Jogador: ");
       String nickname = input.next(); 
       CharacterBean cb = new CharacterBean(nome, alinhamento, idade, xp, money, codc, nickname);
       CharacterModel.create(cb, con);
       System.out.println("Personagem criado com sucesso!!");
    }
            
    void listarCharacters(Connection con) throws SQLException{
        HashSet all = CharacterModel.listAll(con);
        Iterator<CharacterBean> it = all.iterator();
        while(it.hasNext()){
           System.out.println(it.next().toString());
        }
    }
    
    void listarCharactersPlayers(Connection con) throws SQLException{
        HashSet all = CharacterModel.listAllWithPlayer(con);
        Iterator<CharacterBean> it = all.iterator();
        while(it.hasNext()){
             System.out.println(it.next().toString());           
        }
    }
     void listaMaisExp(Connection con) throws SQLException{
       String nomeXp = CharacterModel.listMaisXp(con);
       System.out.println("Personagem com mais XP: "+nomeXp);
     }
    
    
    
    
    
    
}
