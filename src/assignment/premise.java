/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author HP
 */
public class premise {
    private String premise_code;
    private String premise;
    private String premise_Address;

    public premise(String premise_code, String premise, String premise_Address) {
        this.premise_code = premise_code;
        this.premise = premise;
        this.premise_Address = premise_Address;
    }

    public String getPremise_code() {
        return premise_code;
    }

    public void setPremise_code(String premise_code) {
        this.premise_code = premise_code;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public String getPremise_Address() {
        return premise_Address;
    }

    public void setPremise_Address(String premise_Address) {
        this.premise_Address = premise_Address;
    }

    
    
    
    
}
