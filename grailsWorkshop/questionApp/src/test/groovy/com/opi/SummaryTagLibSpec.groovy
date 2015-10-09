package com.opi

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(SummaryTagLib)
class SummaryTagLibSpec extends Specification {
    def tagLib

    def setup() {
      tagLib = new SummaryTagLib()
    }

    def cleanup() {
    }

    void "Test summary taglib"() {
      given:
        def user = Mock(User)

        def question = new Question(title: 'The Title',
            text:'This is a long question, so it should be shortened.',
            user: user)

      when:
        def summary = tagLib.summary([question: question])

      then:
        summary == "The Title: This is a long..."

    }
}
