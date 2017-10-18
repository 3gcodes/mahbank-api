package com.gdb.mahbank

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AccountController {

    AccountService accountService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond accountService.list(params), model:[accountCount: accountService.count()]
    }

    def show(Long id) {
        respond accountService.get(id)
    }

    def save(Account account) {
        if (account == null) {
            render status: NOT_FOUND
            return
        }

        try {
            accountService.save(account)
        } catch (ValidationException e) {
            respond account.errors, view:'create'
            return
        }

        respond account, [status: CREATED, view:"show"]
    }

    def update(Account account) {
        if (account == null) {
            render status: NOT_FOUND
            return
        }

        try {
            accountService.save(account)
        } catch (ValidationException e) {
            respond account.errors, view:'edit'
            return
        }

        respond account, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        accountService.delete(id)

        render status: NO_CONTENT
    }
}
