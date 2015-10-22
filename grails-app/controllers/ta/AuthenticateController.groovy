package ta

import org.apache.http.auth.AuthenticationException
import org.codehaus.groovy.grails.web.util.WebUtils

import java.security.SecureRandom


import java.security.SecureRandom

class AuthenticateController {

        def shiroSecurityManager

        def index = {
            if(SecurityUtils.subject?.principal != null)
                render(view:  "/initial")
            else
                redirect(action: "login", params: params)
        }

        def login = {
            return [ username: params.login, rememberMe: (params.rememberMe != null), targetUri: params.targetUri ]
        }

        def signIn = {

//            Student member = Student.findByLogin(params.username)
//            if(member == null) {
//                flash.message = message(code: "login.failed")
//                redirect(uri: "/auth/login")
//                return
//            }
//
//            def authToken = new UsernamePasswordToken(params.username, params.password as String)
//
//            // Support for "remember me"
//            if (params.rememberMe) {
//                authToken.rememberMe = true
//            }
//
//            // If a controller redirected to this page, redirect back
//            // to it. Otherwise redirect to the root URI.
//            def targetUri = params.targetUri ?: "/"
//
//            // Handle requests saved by Shiro filters.
//            def savedRequest = WebUtils.getSavedRequest(request)
//            if (savedRequest) {    // print("deu saved request: " + savedRequest.toString())
//                targetUri = savedRequest.requestURI - request.contextPath
//                if (savedRequest.queryString) targetUri = targetUri + '?' + savedRequest.queryString
//            }

            try{
                // Perform the actual login. An AuthenticationException
                // will be thrown if the username is unrecognised or the
                // password is incorrect.
                SecurityUtils.subject.login(authToken)
                if(!member.enabled){
                    render "Please wait the administrator to unlock your access to system.\n\nThanks."
                    return
                }

                if (member.passwordChangeRequiredOnNextLogon) {
                    log.info "Redirecting to '${targetUri}'."
                    redirect(action: newPassword)
                } else {
                    log.info "Redirecting to '${targetUri}'."
                    render(view: "/initial")
                }
            }
            catch (AuthenticationException ex){
                authErrorHandling(ex)
            }
        }

        private authErrorHandling(AuthenticationException ex) {
            // Authentication failed, so display the appropriate message
            // on the login page.
            log.info "Authentication failure for user '${params.username}'." + " Error:" + ex.toString()
            flash.message = message(code: "login.failed")

            // Keep the username and "remember me" setting so that the
            // user doesn't have to enter them again.
            def m = [username: params.username]
            if (params.rememberMe) {
                m["rememberMe"] = true
            }

            // Remember the target URI too.
            if (params.targetUri) {
                m["targetUri"] = params.targetUri
            }

            log.info "Authentication failure for user '${params.username}'." + " Error:" + ex.toString()
            flash.message = message(code: "login.failed")
            // Now redirect back to the login page.
            redirect(uri: "/auth/login")
        }

        def signOut = {
            // Log the user out of the application.
            SecurityUtils.subject?.logout()

            // For now, redirect back to the home page.
            redirect(uri: "/")
        }

        def unauthorized = {
            render "You do not have permission to access this page."
        }
        def lostPassword = {
        }
        def updatePassword = {
        }
        def newPassword = {
            render(view:'resetPassword')
        }
        def doResetPassword = {
//            if (params.password1!=params.password2) {
//                flash.message = "Please enter same passwords."
//                flash.status = "error"
//                redirect(action:'resetPassword',id:params.token)
//            } else {
//                def resetRequest = (params.token ? PasswordResetRequest.findByToken(params.token) : null)
//                def connectedUser = SecurityUtils.subject?.principal
//                def user = resetRequest?.student ?: (connectedUser ? Student.findByLogin(connectedUser) : null)
//                if (user) {
//                    user.passwordHash = new Sha256Hash(params.password1).toHex()
//                    user.passwordChangeRequiredOnNextLogon = false
//                    if (user.save()){
//                        resetRequest?.delete()
//                        flash.message = "Password successfully updated"
//                        redirect(uri:'/')
//                    }
//                } else {
//                    flash.status = "error"
//                    flash.message = "Unknown user"
//                    redirect(action:'resetPassword',id:params.token)
//                }
//            }
        }
        def putErrorAndRedirect(message,status,action) {
            flash.message = message
            flash.status = status
            redirect(action: action)
        }
        def doUpdatePassword = {
//            if (params.password1!=params.password2) {
//                putErrorAndRedirect("Please enter same passwords.","error",'updatePassword')
//            } else {
//                def user = Student.findByLogin(SecurityUtils.subject?.principal)
//                if (user) {
//                    if (user.passwordHash == new Sha256Hash(params.oldpassword).toHex()){
//                        user.passwordHash = new Sha256Hash(params.password1).toHex()
//                        if (user.save()){
//                            flash.message = "Password successfully updated"
//                            redirect(uri:'/')
//                        } else {
//                            putErrorAndRedirect("Password update failed.","error",'updatePassword')
//                        }
//                    } else {
//                        putErrorAndRedirect("Incorrect old password .","error",'updatePassword')
//                    }
//                } else {
//                    putErrorAndRedirect("Unknown user.","error",'updatePassword')
//                }
//            }
        }
        def resetPassword = {
            if (params.id){
                def resetRequest = PasswordResetRequest.findByToken(params.id)
                if (resetRequest) {
                    [resetRequest:resetRequest]
                } else {
                    flash.message = "Not a valid request."
                    redirect(uri:'/')
                }
            }
        }
//        def sendPasswordResetRequest = {
//            def memberInstance = (params.email ? Student.findByEmail(params.email) : (params.username ? Student.findByUsername(params.username) : null))
//            if (memberInstance) {
//                flash.message = "An email is being sent to you with instructions on how to reset your password."
//                def resetRequest = new PasswordResetRequest(user:memberInstance,requestDate : new Date(),token:new BigInteger(130, new SecureRandom()).toString(32)).save(failOnError:true)
//                def mailSender = grailsApplication.config.grails.mail.username
//                sendMail {
//                    to memberInstance.email
//                    from mailSender
//                    subject "[GRMS] Reset your password"
//                    body "Hello ${memberInstance.name},\n\nYou have requested resetting your password. Please ignore this message if it's not you who have made the request.\n\nIn order to reset your password, please follow this link :\n\n ${createLink(absolute:true,controller:'auth',action:'resetPassword',id:resetRequest.token)}\n\nBest Regards".toString()
//                }
//            } else {
//                flash.message = "No such user, please try again."
//            }
//            redirect(uri:'/')
//        }



        def register = {
//            //("ENTROU no register")
//
//            if (params.password1 != params.password2) {
//                flash.message = "Please enter same passwords."
//                flash.status = "error"
//                params.password1 = ""
//                params.password2 = ""
//                return [studentInstance: new Student(params)]
//            }
//
//            def memberInstance = new Student(params)
//
//            if (!grailsApplication.config.grails.mail.login) {
//                throw new RuntimeException(message(code: 'mail.plugin.not.configured', 'default' : 'Mail plugin not configured'))
//            }
//
//            if(params.login == null){
//               return [studentInstance: studentInstance]
//            }
//
//            def enabled = false
//
//            def pwdHash = new Sha256Hash(params.password1).toHex()
//
//            studentInstance = new Student(username:params.login,name:params.name, status:params.status, passwordHash: pwdHash, email:params.email, passwordChangeRequiredOnNextLogon:false, enabled:enabled, university:params.university)
//            def name = studentInstance?.name
//            def emailAddress = studentInstance?.email
//
//            if (!studentIstance.save(flush: true)) {
//                //flash.message = "Error creating user"
//                render(view: "register", model: [memberInstance: studentInstance])
//                studentInstance.errors.each{
//
//                }
//                return
//            }
//
//
//            flash.message = "User successfully created";
//            render(view: "register")

        }

        private sendRegistrationMailToAdmin(name) {
            def Admin = Student.findAllByName("Administrator")
            def emailAdmin = Admin?.email
            if (emailAdmin != null && !emailAdmin.empty) {
                // print("Email Admin : " + emailAdmin)

                sendMail {
                    to emailAdmin
                    from grailsApplication.config.grails.mail.username
                    subject "[TA] You received a request to authenticate an account."
                    body "Hello Administrator,\n\nYou received a request to authenticate an account.\n\nWho requested was ${name}. His/Her email address is ${emailAddress}\n\n${createLink(absolute: true, uri: '/student/list')}\n\nBest Regards,\n".toString()
                }
            }
        }

}
