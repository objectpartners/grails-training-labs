package com.opi

class QuestionTagLib {
    static defaultEncodeAs = [taglib:'html']
    static namespace = 'question'

    def summary = { attrs ->
      Question question = attrs.question
      String title = question.title
      int summaryLength = Math.min(question.text?.size(), 250)
      String summary = question.text?.substring(0, summaryLength ) ?: ''

      out << "${title}: ${summary}..."
    }
}
