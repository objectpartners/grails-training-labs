package com.opi

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(VoteController)
class VoteControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "voteUpQuestion is redirected to Question.show"() {
      given:
        controller.params.id = '42'

      when:
        controller.voteUpQuestion()

      then:
        response.redirectedUrl == '/question/show/42'
    }

    void "voteDownQuestion is redirected to Question.show"() {
      given:
        controller.params.id = '42'

      when:
        controller.voteDownQuestion()

      then:
        response.redirectedUrl == '/question/show/42'
    }

}
