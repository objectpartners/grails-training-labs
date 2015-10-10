package com.opi

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.validation.Validateable
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_USER'])
class AnswerController {

  def answer(AnswerCommand cmd) {
     if (cmd.validate()) {
       def question = cmd.id
       User user = User.findByUsername(getPrincipal().username)

       def answer = new Answer(text: params.answer, author: user)
       question.addToAnswers(answer)
       try {
         answer.save(failOnError: true)
         question.save(failOnError: true)
       } catch (ValidationException ex) {
         flash.message = "There was an issue adding your answer. Please try again"
       }
       redirect controller: "question", action: "show", id: question.id
     } else {
       if (params.id) {
         redirect(controller: 'question', action: 'show', id: params.id)
       } else {
         redirect(controller: 'question', action: 'list')
       }
     }
   }
}

class AnswerCommand implements Validateable{
  Question id
  String answer

  static constraints = {
    id nullable: false, blank: false
    answer nullable: false, blank: false
  }
}
