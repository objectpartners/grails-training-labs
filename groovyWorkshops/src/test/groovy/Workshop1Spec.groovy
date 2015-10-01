// Groovy Workshop #1

import spock.lang.*

class Workshop1Spec extends Specification {

  /*
  *   Using String concatenation, assign the concatString variable
  *   to 'Hello Sterling Archer!'
  */
  def "1.1 - string concatenation"() {
    given:
      def firstName = 'Sterling'
      def lastName = 'Archer'

    when:
      def concatString = 'Hello ' + firstName  + ' ' + lastName + '!'

    then:
      concatString == 'Hello Sterling Archer!'
  }

  /*
  *   Using GString concatenation, assign the gString variable
  *   to 'Hello Sterling Archer!'
  */
  def "1.2 - gString concatenation"() {
    given:
      def firstName = 'Sterling'
      def lastName = 'Archer'

    when:
      def gString = "Hello $firstName $lastName!"

    then:
      gString == 'Hello Sterling Archer!'
  }

  /*
  *   In src/main/groovy/Person.groovy create a Person class.  The specifics of
  *   the class are detailed in the comments of that file.
  */
  def "1.3 - create person class"() {
    when:
      def person = new Person()

    then:
      person.hasProperty('firstName')
      person.hasProperty('lastName')
      person.hasProperty('middleName')
      person.hasProperty('age')
  }

  /*
  *   Add a method to the Person class called 'sayName'
  *   This method will take no parameters and will return a String.
  *   The returned String should have the user's firstName middleName (if present) and lastName.
  */
  @Unroll
  def "1.4 - person sayName() - #result"() {
    given:
      def person = new Person(firstName: firstName, lastName: lastName, middleName: middleName)

    expect:
      person.sayName() == result

    where:
      firstName   | lastName  | middleName  | result
      'Sterling'  | 'Archer'  | 'Malory'    | 'Sterling Malory Archer'
      'Lana'      | 'Kane'    | 'Anthony'   | 'Lana Anthony Kane'
      'Malory'    | 'Archer'  | 'Duchess'   | 'Malory Duchess Archer'
      'Cyril'     | 'Figgis'  | null        | 'Cyril Figgis'
      'Pam'       | 'Poovey'  | null        | 'Pam Poovey'
  }
}
