package com.gdb.mahbank

class Account {

  String name
  String accountNumber

  static constraints = {
    name nullable: false, blank: false, minSize: 5, maxSize: 25
    accountNumber nullable: false, blank: false, minSize: 3, maxSize: 50
  }
}
