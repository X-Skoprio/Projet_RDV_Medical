package model;

public class Login {

    private String email;
    private String mdp;



    //getters
    public String getEmail() {
        return email;
    }
    public String getMdp() {
        return mdp;
    }



    //setters
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
