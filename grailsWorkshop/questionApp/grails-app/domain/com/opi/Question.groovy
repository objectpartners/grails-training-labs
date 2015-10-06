package com.opi

class Question {

    User user
    String text
    String title
    boolean deleted = false
    Date dateCreated
    Date lastUpdated

    static hasMany = [answers: Answer]

    static constraints = {
      title blank: false, maxSize: 200,
        validator: { val, obj ->
          if (val.contains('JVM')) {
            return "jvm.questions.not.allowed"
          }
        }
      text nullable: false, blank: false, maxSize: 10000
    }

    static namedQueries = {
      querySinceLastLogin { lastLogin ->
        fetchMode "answers",
          FetchMode.SELECT
        eq("deleted", false)
        gt("lastUpdated", lastLogin)
      }
    }


    static mapping = {
      table 'topics'

      answers joinTable: [name  : 'topic_responses',
                key   : 'question_id',
                column: 'answer_id'
      ]
    }
}
