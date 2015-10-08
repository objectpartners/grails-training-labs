package com.opi


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class VoteServiceSpec extends Specification {
    def voteService

    def setup() {
    }

    def cleanup() {
    }

    void "can add an up or down vote to a question"() {
        given:
        def peter = new User(username: 'peterJones', firstName: 'peter', lastName: 'jones', email: 'peter@jones.com').save(failOnError: true)
        def bobby = new User(username: 'bobbySmith', firstName: 'bobby', lastName: 'smith', email: 'bobby@smith.com').save(failOnError: true)

        def question = new Question(title: 'What is def?', text: 'Please explain this thing called def.', user: peter).save(failOnError: true)

        when:
        voteService.addVoteToQuestion(question,peter,1)

        then:
        question.votes.size() == 1
        question.votes.first().user == peter
        question.votes.first().vote == 1

        when:
        voteService.addVoteToQuestion(question,bobby,-1)

        then:
        question.votes.size() == 2
        question.votes*.user.containsAll([peter,bobby])
        question.votes*.vote.containsAll([1,-1])
    }

    void "can add an up or down vote to an answer"() {
        given:
        def peter = new User(username: 'peterJones', firstName: 'peter', lastName: 'jones', email: 'peter@jones.com').save(failOnError: true)
        def bobby = new User(username: 'bobbySmith', firstName: 'bobby', lastName: 'smith', email: 'bobby@smith.com').save(failOnError: true)
        def alex = new User(username: 'alexTrebek', firstName: 'alex', lastName: 'trebek', email: 'alex@jeopardy.com').save(failOnError: true)

        def question = new Question(title: 'What is def?', text: 'Please explain this thing called def.', user: peter)
        def answer = new Answer(accepted: false, author: alex,text: "I don't really know, it just seems like I do.")
        question.addToAnswers(answer).save(failOnError: true)

        when:
        voteService.addVoteToAnswer(answer,peter,1)

        then:
        answer.votes.size() == 1
        answer.votes.first().user == peter
        answer.votes.first().vote == 1

        when:
        voteService.addVoteToAnswer(answer,bobby,-1)

        then:
        answer.votes.size() == 2
        answer.votes*.user.containsAll([peter,bobby])
        answer.votes*.vote.containsAll([1,-1])
    }
}
