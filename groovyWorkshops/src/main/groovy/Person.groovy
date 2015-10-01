/* Create a groovy class Person.
*   A Person will have:
*      First Name (String)
*      Last Name (String)
*      Middle Name (String)
*/

class Person {
  String firstName
  String lastName
  String middleName

  String sayName() {
    if (middleName) {
      return "$firstName $middleName $lastName"
    } else {
      return "$firstName $lastName"
    }
  }
}
