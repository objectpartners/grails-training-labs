package com.opi

class Question {

    static hasMany = [answers: Answer]
    String text
    String title
    User user

    Date dateCreated
    Date lastUpdated

    static constraints = {
      title blank: false, maxSize: 200,
        validator: { val, obj ->
          if (val.contains('JVM')) {
            return "jvm.questions.not.allowed"
          }
        }
      text nullable: false, blank: false, maxSize: 10000
    }
}
