// Groovy Workshop #2 - Traits

import spock.lang.*

class Workshop4Spec extends Specification {

  /*
  *   In src/main/groovy/Aging.groovy create a Aging trait.  The specifics of
  *   the trait are detailed in the comments of that file.
  *
  *   Apply that trait to the Person class.
  */
  def "4.1 - Traits"() {
    given:
      def sterling = new Person(firstName: 'Sterling', middleName: 'Malory', lastName: 'Archer', age: 36)
      def abbijean = new Person(firstName: 'Abbijean', middleName: 'Malory', lastName: 'Kane-Archer', age: 1)

    expect:
      sterling.canDrive()
      sterling.canVote()
      sterling.canDrink()
      !abbijean.canDrive()
      !abbijean.canVote()
      !abbijean.canDrink()
  }



}
