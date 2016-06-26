/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.domain;

/**
 *
 * @author VarunAg
 */
public class AdminLogin {
    private String userName;
    private String password;
    private Integer adminId;
    private String firstName;
    private String lastName;

    public AdminLogin() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
