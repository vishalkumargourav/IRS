/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.domain;

public class PollResult {

    private Integer pollResultId;
    private Integer pollId;
    private Integer studentId;
    private Integer option;

    public PollResult() {
    }

    public Integer getPollResultId() {
        return pollResultId;
    }

    public void setPollResultId(Integer pollResultId) {
        this.pollResultId = pollResultId;
    }

    public Integer getPollId() {
        return pollId;
    }

    public void setPollId(Integer pollId) {
        this.pollId = pollId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }
    
}
