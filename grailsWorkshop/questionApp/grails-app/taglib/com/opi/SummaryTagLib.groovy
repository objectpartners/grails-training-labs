package com.opi

class SummaryTagLib {
    static defaultEncodeAs = [taglib:'html']
    static namespace = 'txt'

    def summary = { attrs ->
      Question question = attrs.question
      String title = question.title
      int summaryLength = Math.min(question.text?.length(), 15)
      String summary = question.text?.substring(0, summaryLength - 1) ?: ''

      out << "${title}: ${summary}..."
    }
}
