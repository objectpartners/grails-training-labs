package com.opi
import grails.transaction.Transactional

@Transactional
class VoteService {

  Vote addVoteToQuestion(Question question, User votingUser, Integer vote) {
    def userVote = question.votes.find{it.user == votingUser} ?: new Vote(user:votingUser)
    userVote.vote = vote
    question.addToVotes(userVote)
    question.save()

    return userVote
  }

  Vote addVoteToAnswer(Answer answer, User votingUser, Integer vote) {
    def userVote = answer.votes.find{it.user == votingUser} ?: new Vote(user:votingUser)
    userVote.vote = vote
    answer.addToVotes(userVote)
    answer.save()

    return userVote
  }

}
