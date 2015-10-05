package com.opi

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

  	def "test User validation"() {
      when:
    		User u = new User(username: 'bobmarley',
          firstName: 'Bob',
    			lastName: 'Marley',
          email: 'bob@example.com')

  		then:
        u.validate()
  	}

    // Tests the custom validator.
    def "test custom validator for no users with the name Justin Bieber"() {
      when:
        User u = new User(username:'justin', firstName: 'Justin',
            lastName: 'Bieber', email:'justin@example.com')

      then:
        !u.validate()

      when: "first name for Justin is case insensitive"
        u.firstName = 'jUsTiN'

      then:
        !u.validate()

      when: "set to valid last name to break up first / last combo"
        u.lastName = 'TV'

      then:
        u.validate()
    }
}
