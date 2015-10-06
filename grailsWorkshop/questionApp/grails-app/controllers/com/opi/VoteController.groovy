package com.opi

class VoteController {

    def voteUpQuestion(Long id){
      redirect controller: 'question', action: 'show', id: id
    }

    def voteDownQuestion(Long id){
      redirect controller: 'question', action: 'show', id: id
    }
}
