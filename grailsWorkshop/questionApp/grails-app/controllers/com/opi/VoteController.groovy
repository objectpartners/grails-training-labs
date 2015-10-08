package com.opi

class VoteController {
    def voteService

    def voteUpQuestion(Long id){
      def question = Question.get(id)
      if (question) {
        saveQuestionVote(question, Vote.VOTE_UP)
      } else {
        redirect controller: 'question', action: 'index'
      }
    }

    def voteDownQuestion(Long id){
      def question = Question.get(id)
      if (question) {
        saveQuestionVote(question, Vote.VOTE_DOWN)
      } else {
        redirect controller: 'question', action: 'index'
      }
    }

    def voteUpAnswer(Long id){
      def answer = Answer.get(id)
      if (answer) {
        saveAnswerVote(question, Vote.VOTE_DOWN)
      } else {
        redirect controller: 'question', action: 'index'
      }
    }

    def voteDownAnswer(Long id){
      def answer = Answer.get(id)
      if (answer) {
        saveAnswerVote(question, Vote.VOTE_DOWN)
      } else {
        redirect controller: 'question', action: 'index'
      }
    }

    private saveQuestionVote(question, voteType) {
      def user = User.get(1)
      voteService.addVoteToQuestion(question, user, voteType)
      redirect controller: 'question', action: 'show', id: question.id
    }

    private saveAnswerVote(answer, voteType) {
      def user = User.get(1)
      voteService.addVoteToAnswer(answer, user, voteType)
      redirect controller: 'question', action: 'show', id: answer.question.id
    }
}
