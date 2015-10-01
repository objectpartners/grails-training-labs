// Groovy Workshop #1

// class Foo {
//   String name
//   boolean isBar
// }
//
// def myFoo = new Foo(name: 'test', isBar: false);
// assert myFoo.isBar
import spock.lang.*

class Workshop1Spec extends Specification {

  /*
  *   Complete the sayHi closure to say 'Hello' to the name being passed in.
  *
  *   For Example:
  *   sayHi('Nick') would return 'Hello Nick!'
  */
  def "1.1 - string concatenation"() {
      given:
        def sayHi = {name ->
          // TODO: Say Hello!
        }
      expect:
        result == sayHi(name)

      where:
          result | name
          'Hello Class!' | 'Class'
          'Hello Students!' | 'Students'
  }

  /*
  *   In src/main/groovy/Person.groovy create a Person class.  The specifics of
  *   the class are detailed in the comments of that file.
  */
  def "1.2 - create person class"() {
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
  def "1.3 - person sayName() - #result"() {
      given:
          def person = new Person(firstName: firstName, lastName: lastName, middleName: middleName)

      expect:
          person.sayName() == result

      where:
          firstName | lastName | middleName | result
          'Sterling' | 'Archer' | 'Malory' | 'Sterling Malory Archer'
          'Lana' | 'Kane' | 'Anthony' | 'Lana Anthony Kane'
          'Malory' | 'Archer' | 'Duchess' | 'Malory Duchess Archer'
          'Cyril' | 'Figgis' | null | 'Cyril Figgis'
          'Pam' | 'Poovey' | null | 'Pam Poovey'
  }
}
