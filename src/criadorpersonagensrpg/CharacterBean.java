/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package criadorpersonagensrpg;

/**
 *
 * @author bruni
 */
public class CharacterBean {
    private int money;
    private int xp;
    private int idade;
    private String nome;
    private String alinhamento;
    private int codc;
    private String nickname;
    private PlayerBean player;

    
    public CharacterBean(String nome, String alinhamento, int idade, int xp, int money, int codc, String nickname){
        this.alinhamento = alinhamento;
        this.money = money;
        this.nome = nome;
        this.idade = idade;
        this.xp = xp;
        this.codc = codc;
        this.nickname = nickname;
    }

    /**
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * @return the xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * @param xp the xp to set
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the alinhamento
     */
    public String getAlinhamento() {
        return alinhamento;
    }

    /**
     * @param alinhamento the alinhamento to set
     */
    public void setAlinhamento(String alinhamento) {
        this.alinhamento = alinhamento;
    }
    
       /**
     * @return the codc
     */
    public int getCodc() {
        return codc;
    }

    /**
     * @param codc the codc to set
     */
    public void setCodc(int codc) {
        this.codc = codc;
    }
        /**
     * @return the player
     */
    public PlayerBean getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(PlayerBean player) {
        this.player = player;
    }

    
    public String toString(){
       StringBuffer sb = new StringBuffer();
       sb.append("Nome: "+getNome()+", Alinhamento: "+getAlinhamento()+", "
               + "Idade: "+getIdade()+", Dinheiro: "+getMoney()+", XP: "+getXp()+", Codigo: "+getCodc());
       if(getPlayer() != null){
            sb.append(", Nickname: "+getPlayer().getNickname()+", Password:"+getPlayer().getPassword());
       }
       return sb.toString();
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
}
