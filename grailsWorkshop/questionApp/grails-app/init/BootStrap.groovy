import com.opi.User
import com.opi.Role
import com.opi.UserRole
import com.opi.Question
import com.opi.Answer

import groovy.time.TimeDuration
import groovy.time.TimeCategory
import grails.converters.*

class BootStrap {

    def init = { servletContext ->
      JSON.registerObjectMarshaller(User) {
        def map= [:]
          map['username'] = it.username
          map['firstName'] = it.firstName
          map['lastName'] = it.lastName
          map['email'] = it.email
        return map
      }

      Role userRole = new Role('ROLE_USER').save(failOnError: true)

      User archer = new User(firstName: "Sterling", lastName: "Archer", username: "archer", email: "sterling.archer@objectpartners.com", password: 'password').save(failOnError: true)
  		User lana = new User(firstName: "Lana", lastName: "Kane", username: "lana", email: "lana.kane@objectpartners.com", password: 'password').save(failOnError: true)
      User krieger = new User(firstName: "Algernop", lastName: "Krieger", username: "krieger", email: "algernop.krieger@objectpartners.com", password: 'password').save(failOnError: true)
      User pam = new User(firstName: "Pam", lastName: "Poovey", username: "pam", email: "pam.poovey@objectpartners.com", password: 'password').save(failOnError: true)
      User cheryl = new User(firstName: "Cheryl", lastName: "Tunt", username: "cheryl", email: "cheryl.tunt@objectpartners.com", password: 'password').save(failOnError: true)

      UserRole.create(archer, userRole, true)
      UserRole.create(lana, userRole, true)
      UserRole.create(krieger, userRole, true)
      UserRole.create(pam, userRole, true)
      UserRole.create(cheryl, userRole, true)

  		log.debug("Done with users")

  		def timeStart = new Date()
  		TimeDuration duration
  		def timeStop

  		// Questions created by Bob
  		500.times {
  			def newQuestion = new Question(title: "Title for Question $it",
  				text: " Text for $it Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus, lacus nec porta sollicitudin, erat ipsum vehicula enim, sit amet convallis enim augue sit amet massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In magna enim, dictum ac facilisis ac, feugiat eget lectus. Nunc auctor hendrerit accumsan. Duis a massa quis metus porta mollis. Fusce id purus ut turpis aliquet ullamcorper. Ut eget ipsum orci, et varius ligula. Fusce sed mauris non nunc sagittis bibendum. Quisque ut mauris dolor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus et nulla in purus lacinia consequat. Cras ante tellus, placerat ac tincidunt consectetur, hendrerit ut metus. Nullam tincidunt tempor justo, at rhoncus libero vehicula sit amet. Donec sit amet condimentum erat. Phasellus cursus urna at justo convallis consectetur. Sed pulvinar, libero id consequat volutpat, felis lacus accumsan nibh, eget mollis sem justo eget metus. Cras varius urna a ante ornare tincidunt.",
  				user: pam)
        newQuestion.save(failOnError: true)
        newQuestion.addToAnswers(text: "The answer is always 42", author: archer)
        newQuestion.save(failOnError: true)
  		}


  		// Questions created by Peter
  		20.times {
  			def newQuestion = new Question(title: "Title for Question $it",
  				text: " Text for $it Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus, lacus nec porta sollicitudin, erat ipsum vehicula enim, sit amet convallis enim augue sit amet massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In magna enim, dictum ac facilisis ac, feugiat eget lectus. Nunc auctor hendrerit accumsan. Duis a massa quis metus porta mollis. Fusce id purus ut turpis aliquet ullamcorper. Ut eget ipsum orci, et varius ligula. Fusce sed mauris non nunc sagittis bibendum. Quisque ut mauris dolor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus et nulla in purus lacinia consequat. Cras ante tellus, placerat ac tincidunt consectetur, hendrerit ut metus. Nullam tincidunt tempor justo, at rhoncus libero vehicula sit amet. Donec sit amet condimentum erat. Phasellus cursus urna at justo convallis consectetur. Sed pulvinar, libero id consequat volutpat, felis lacus accumsan nibh, eget mollis sem justo eget metus. Cras varius urna a ante ornare tincidunt.",
  				user: cheryl)
  			newQuestion.save(failOnError: true)
  			newQuestion.addToAnswers(text: "The answer is always 42", author: krieger)
        newQuestion.save(failOnError: true)
  		}

  		timeStop = new Date()
  		duration = TimeCategory.minus(timeStop, timeStart)
  		log.debug("Boostrap took ${duration}")
    }
    def destroy = {
    }
}
