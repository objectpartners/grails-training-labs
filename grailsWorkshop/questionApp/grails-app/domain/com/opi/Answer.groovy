package com.opi

class Answer {

    String text
    User author
    boolean accepted = false
    Date dateCreated
    Date lastUpdated

    static belongsTo = [question:Question]

    static constraints = {
      text nullable: false, blank: false, maxSize: 10000
    }
}
