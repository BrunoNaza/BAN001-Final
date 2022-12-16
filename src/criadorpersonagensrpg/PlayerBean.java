/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package criadorpersonagensrpg;

/**
 *
 * @author bruni
 */
public class PlayerBean {
    private String nickname;
    private String password;
    
    public PlayerBean( String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the character
     */

    public String toString(){
       return "Nickname: "+nickname+" Password: "+password;
    }
}
