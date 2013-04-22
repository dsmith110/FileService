/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileService;

/**
 *
 * @author dskrilla24
 */
public class Employee {
    private String fName;
    private String lName;
    private String state;

    public Employee(String fName, String lName, String state) {
        this.fName = fName;
        this.lName = lName;
        this.state = state;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
}
