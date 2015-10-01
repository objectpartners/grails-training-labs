/* Create a groovy trait Aging.
*   An Aging trait will have methods to determine if the object is old enough
*   to drive, vote, and drink.
*
*   The trait should have:
*     * Integer property 'age'
*     * canDrive() method which returns a Boolean (returns true if age >= 16)
*     * canVote() method which returns a Boolean (returns true if age >= 18)
*     * canDrink() method which returns a Boolean (returns true if age >= 21)
*/

trait Aging {
  Integer age

  Boolean canDrive() {
    age >= 16
  }

  Boolean canVote() {
    age >= 18
  }

  Boolean canDrink() {
    age >= 21
  }
}
