package com.jcs.sbs.result;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResultCount {

    @Id
    private int totalResults;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
    

}
