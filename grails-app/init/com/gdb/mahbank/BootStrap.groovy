package com.gdb.mahbank

class BootStrap {

  def init = { servletContext ->
    new Account(name: "INTRUST Bank", accountNumber: "123456789").save()
    new Account(name: "BOA Bank", accountNumber: "78978978979").save()
    new Account(name: "Legacy", accountNumber: "23423423324").save()
  }
  def destroy = {
  }
}
