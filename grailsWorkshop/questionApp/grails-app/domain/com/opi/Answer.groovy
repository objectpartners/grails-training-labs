package com.opi

class Answer {

    String text
    User author
    boolean accepted = false
    Date dateCreated
    Date lastUpdated

    static hasMany = [votes: Vote]
    static belongsTo = [question:Question]

    static constraints = {
      text nullable: false, blank: false, maxSize: 10000
    }

    Integer getVoteCount() {
      votes*.vote.sum()?:0
    }
}
