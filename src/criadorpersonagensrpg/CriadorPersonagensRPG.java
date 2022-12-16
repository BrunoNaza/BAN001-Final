
package criadorpersonagensrpg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author bruni
 */
public class CriadorPersonagensRPG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       int op = 0;
       do{
           op = menu();
           try {
               switch(op){
                   case 1: new PlayerController().createPlayer(con);
                           break;       
                   case 2: new CharacterController().createCharacter(con);
                           break;                       
                   case 3: new PlayerController().listarPlayer(con);
                           break;                       
                   case 4: new CharacterController().listarCharacters(con);
                           break;
                   case 5: new CharacterController().listarCharactersPlayers(con);
                           break;
                   case 6: new CharacterController().listaMaisExp(con);
                           break;
               }
           }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
       } while(op > 0 && op < 7);
       con.close();
    }
    
    //Fazer função (de agregação) que retorna o personagem com mais dinheiro (MAX)
    //Fazer função de subconsulta
    
    
    private static int menu() {
        System.out.println("");
        System.out.println("Informe a opcao que deseja executar: ");
        System.out.println("1 - Inserir um novo jogador");
        System.out.println("2 - Inserir um novo personagem");
        System.out.println("3 - Exibir todos os jogadores");
        System.out.println("4 - Exibir todos os personagens");
        System.out.println("5 - Exibir todos os jogadores e seus respectivos personagens");
        System.out.println("6 - Exibir o personagem com mais XP");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    } 
  
}


