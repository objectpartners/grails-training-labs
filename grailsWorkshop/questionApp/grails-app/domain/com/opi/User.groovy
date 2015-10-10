package com.opi
import grails.rest.Resource

@Resource(readOnly = true)
class User {

  private static final long serialVersionUID = 1
  transient springSecurityService
  static transients = ['springSecurityService']

  String username
  String firstName
  String lastName
  String email

  Date dateCreated
	Date lastUpdated

	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	User(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	@Override
	int hashCode() {
		username?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof User && other.username == username)
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

  String getFullName() {
    toString()
  }

  String toString() {
    "$firstName $lastName"
  }

	static mapping = {
		password column: '`password`'
    username index: 'username_idx'
	}


  static constraints = {
    username nullable: false, blank: false, maxSize: 30, unique: true
    firstName nullable: false, blank: false, maxSize: 30,
      validator: { val, obj ->
        if ((val?.toLowerCase() == 'justin')
          && (obj.lastName?.toLowerCase() == 'bieber')) {
          return 'no.biebers.allowed'
        }
      }
    lastName nullable: false, blank:false, maxSize: 30
    email nullable: false, blank: false, email: true
		password blank: false
  }

}
