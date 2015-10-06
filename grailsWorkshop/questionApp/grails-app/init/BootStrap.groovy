import com.opi.Question
import com.opi.User
import com.opi.Answer

class BootStrap {

    def init = { servletContext ->
      User bob = new User(firstName: "Bob", lastName: "Marley", username: "bobmarley", email: "bob@objectpartners.com").save(failOnError: true)
      User peter = new User(firstName: "Peter", lastName: "Tosh", username: "petertosh", email: "peter@objectpartners.com").save(failOnError: true)

      // Questions created by Bob
      500.times {
        def newQuestion = new Question(title: "Title for Question $it",
          text: " Text for $it Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus, lacus nec porta sollicitudin, erat ipsum vehicula enim, sit amet convallis enim augue sit amet massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In magna enim, dictum ac facilisis ac, feugiat eget lectus. Nunc auctor hendrerit accumsan. Duis a massa quis metus porta mollis. Fusce id purus ut turpis aliquet ullamcorper. Ut eget ipsum orci, et varius ligula. Fusce sed mauris non nunc sagittis bibendum. Quisque ut mauris dolor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus et nulla in purus lacinia consequat. Cras ante tellus, placerat ac tincidunt consectetur, hendrerit ut metus. Nullam tincidunt tempor justo, at rhoncus libero vehicula sit amet. Donec sit amet condimentum erat. Phasellus cursus urna at justo convallis consectetur. Sed pulvinar, libero id consequat volutpat, felis lacus accumsan nibh, eget mollis sem justo eget metus. Cras varius urna a ante ornare tincidunt.",
          user: bob)
        newQuestion.save(failOnError: true)
        // new Answer(text: "The answer is always 42", user: peter, question: newQuestion).save(failOnError: true)
        newQuestion.addToAnswers(text: "The answer is always 42", user: peter)
        newQuestion.save(failOnError: true)
      }


      // Questions created by Peter
      20.times {
        def newQuestion = new Question(title: "Title for Question $it",
          text: " Text for $it Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus, lacus nec porta sollicitudin, erat ipsum vehicula enim, sit amet convallis enim augue sit amet massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In magna enim, dictum ac facilisis ac, feugiat eget lectus. Nunc auctor hendrerit accumsan. Duis a massa quis metus porta mollis. Fusce id purus ut turpis aliquet ullamcorper. Ut eget ipsum orci, et varius ligula. Fusce sed mauris non nunc sagittis bibendum. Quisque ut mauris dolor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus et nulla in purus lacinia consequat. Cras ante tellus, placerat ac tincidunt consectetur, hendrerit ut metus. Nullam tincidunt tempor justo, at rhoncus libero vehicula sit amet. Donec sit amet condimentum erat. Phasellus cursus urna at justo convallis consectetur. Sed pulvinar, libero id consequat volutpat, felis lacus accumsan nibh, eget mollis sem justo eget metus. Cras varius urna a ante ornare tincidunt.",
          user: peter)
        newQuestion.save(failOnError: true)
        newQuestion.addToAnswers(text: "The answer is always 42", user: bob)
        newQuestion.save(failOnError: true)
      }
    }
    def destroy = {
    }
}
