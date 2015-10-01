// Groovy Workshop #2 - Collections - Maps

import spock.lang.*

class Workshop3Spec extends Specification {

  /*
  *   Access map values in multiple ways.
  */
  def "3.1 - map accessors"() {
    given:
      def roleMap = [
        'Sterling' : 'Field Agent',
        'Malory': 'Director',
        'Lana' : 'Field Agent',
        'Cyril' : 'Head of Accounting',
        'Cheryl' : 'Assistant to Malory Archer',
        'Pam' : 'Head of Human Resources',
        'Algernop' : 'Head of Applied Research',
        'Ray' : 'Field Agent'
      ]

    when:
      // TODO: use .get() to find Sterling's role.
      def sterlingRole

      // TODO: use .property notaion to get Algernop's role.
      def algernopRole

      // TODO: use index accessors to find Cheryl and Pam's roles
      def cherylRole
      def pamRole

    then:
      sterlingRole == 'Field Agent'
      algernopRole == 'Head of Applied Research'
      cherylRole == 'Assistant to Malory Archer'
      pamRole == 'Head of Human Resources'
  }

  /*
  *   Build a map that is associates a Role to Person(s). This map will
  *   be keyed by the Role name, and the value will be a list of Person
  *   objects
  */
  def "3.2 - advanced map construction"() {
    given:
      def roleMap = [
        'Sterling' : 'Field Agent',
        'Malory': 'Director',
        'Lana' : 'Field Agent',
        'Cyril' : 'Head of Accounting',
        'Cheryl' : 'Assistant to Malory Archer',
        'Pam' : 'Head of Human Resources',
        'Algernop' : 'Head of Applied Research',
        'Ray' : 'Field Agent'
      ]

      def peopleList = [
        new Person(firstName: 'Sterling', middleName: 'Malory', lastName: 'Archer'),
        new Person(firstName: 'Malory', middleName: 'Duchess', lastName: 'Archer'),
        new Person(firstName: 'Lana', middleName: 'Anthony', lastName: 'Kane'),
        new Person(firstName: 'Cyril', lastName: 'Figgis'),
        new Person(firstName: 'Cheryl', lastName: 'Tunt'),
        new Person(firstName: 'Pam', lastName: 'Poovey'),
        new Person(firstName: 'Algernop', lastName: 'Krieger'),
        new Person(firstName: 'Ray', lastName: 'Gillette')
      ]

    when:
      // TODO: build roleToPeople map
      def roleToPeople = [:]

    then:
      roleToPeople['Director'].size() == 1
      roleToPeople['Field Agent'].size() == 3
      roleToPeople['Assistant to Malory Archer'].size() == 1
      roleToPeople['Head of Accounting'].size() == 1
      roleToPeople['Head of Human Resources'].size() == 1
      roleToPeople['Head of Applied Research'].size() == 1
      roleToPeople['Director'][0].sayName() == 'Malory Duchess Archer'
      roleToPeople['Assistant to Malory Archer'][0].firstName == 'Cheryl'
  }
}
