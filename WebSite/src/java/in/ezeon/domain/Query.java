/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.domain;

/**
 *
 * @author personal
 */
public class Query {
    private Integer queryId;
    private Integer submitedBy;
    private Integer answeredBy;
    private String query;
    private String answer;

    public Query() {
    }

    public Integer getQueryId() {
        return queryId;
    }

    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

    public Integer getSubmitedBy() {
        return submitedBy;
    }

    public void setSubmitedBy(Integer submitedBy) {
        this.submitedBy = submitedBy;
    }

    public Integer getAnsweredBy() {
        return answeredBy;
    }

    public void setAnsweredBy(Integer answeredBy) {
        this.answeredBy = answeredBy;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
}
