package com.opi

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Answer)
class AnswerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "Answer should validate"() {
      when:
        def user = Mock(User)
        def question = Mock(Question)

        def a = new Answer(
            question: question,
            text:'Answer',
            author: user)

      then:
        a.validate()
    }
}
