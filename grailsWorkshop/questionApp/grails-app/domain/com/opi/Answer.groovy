package com.opi

class Answer {

    static belongsTo = [question:Question]
    String text
    User user

    Date dateCreated
    Date lastUpdated

    static constraints = {
      text nullable: false, blank: false, maxSize: 10000
    }
}
