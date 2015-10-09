package com.opi

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(QuestionTagLib)
class QuestionTagLibSpec extends Specification {
    def tagLib

    def setup() {
      tagLib = new QuestionTagLib()
    }

    def cleanup() {
    }

    void "A short message should not be shortened."() {
      given:
        def user = Mock(User)

        def question = new Question(title: 'The Title',
            text:'This is NOT a long question, so it should NOT be shortened',
            user: user)

      when:
        def summary = tagLib.summary([question: question])

      then:
        summary == "The Title: This is NOT a long question, so it should NOT be shortened..."
    }

    void "A longer message should be cut off"() {
      given:
        def user = Mock(User)
        def question = new Question(title: 'Title', user: user,
          text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus, lacus nec porta sollicitudin, erat ipsum vehicula enim, sit amet convallis enim augue sit amet massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In magna enim, dictum ac facilisis ac, feugiat eget lectus. Nunc auctor hendrerit accumsan. Duis a massa quis metus porta mollis. Fusce id purus ut turpis aliquet ullamcorper. Ut eget ipsum orci, et varius ligula. Fusce sed mauris non nunc sagittis bibendum. Quisque ut mauris dolor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus et nulla in purus lacinia consequat. Cras ante tellus, placerat ac tincidunt consectetur, hendrerit ut metus. Nullam tincidunt tempor justo, at rhoncus libero vehicula sit amet. Donec sit amet condimentum erat. Phasellus cursus urna at justo convallis consectetur. Sed pulvinar, libero id consequat volutpat, felis lacus accumsan nibh, eget mollis sem justo eget metus. Cras varius urna a ante ornare tincidunt.')

      when:
        def summary = tagLib.summary([question: question])

      then:
        summary.size() == 260
        summary == "Title: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus, lacus nec porta sollicitudin, erat ipsum vehicula enim, sit amet convallis enim augue sit amet massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridicu..."
    }
}
