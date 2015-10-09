import grails.rest.render.json.*
import com.opi.Question
import com.opi.Answer

beans = {
    questionRenderer(JsonRenderer, Question) {
        excludes = ['version','lastUpdated','deleted']
    }
    answerRenderer(JsonRenderer, Answer) {
        includes = ['author','text','dateCreated']
    }
}
