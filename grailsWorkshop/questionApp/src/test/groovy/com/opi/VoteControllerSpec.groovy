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

    void "voteUpQuestion should redirect to /question/show"() {
        when:
          controller.voteUpQuestion(42)

        then:
            response.redirectedUrl == '/question/show/42'
    }

    void "voteDownQuestion should redirect to /question/show"() {
        when:
          controller.voteDownQuestion(42)

        then:
            response.redirectedUrl == '/question/show/42'
    }
}
