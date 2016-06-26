package in.ezeon.irsapp;

import java.io.Serializable;

public class Student implements Serializable{
private Integer studentId;
private String scholarNumber;
private String firstName;
private String lastName;
private String gender;
private String email;
private String phone;
private String alternatePhone;
private Integer semester;
private String loginName;
private String password;
private Integer lStatus;
private Integer vStatus;
public Student()
{
    
}

    /**
     * @return the studentId
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the scholarNumber
     */
    public String getScholarNumber() {
        return scholarNumber;
    }

    /**
     * @param scholarNumber the scholarNumber to set
     */
    public void setScholarNumber(String scholarNumber) {
        this.scholarNumber = scholarNumber;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the alternatePhone
     */
    public String getAlternatePhone() {
        return alternatePhone;
    }

    /**
     * @param alternatePhone the alternatePhone to set
     */
    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    /**
     * @return the semester
     */
    public Integer getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
     * @return the lStatus
     */
    public Integer getlStatus() {
        return lStatus;
    }

    /**
     * @param lStatus the lStatus to set
     */
    public void setlStatus(Integer lStatus) {
        this.lStatus = lStatus;
    }

    /**
     * @return the vStatus
     */
    public Integer getvStatus() {
        return vStatus;
    }

    /**
     * @param vStatus the vStatus to set
     */
    public void setvStatus(Integer vStatus) {
        this.vStatus = vStatus;
    }
}
