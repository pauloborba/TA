package pages

import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.i18n.LocaleContextHolder as LCH
import org.springframework.context.support.ResourceBundleMessageSource

class GetPageTitle {

    String msg(String msgKey, args = null, locale = LocaleContextHolder.getLocale()) {
        println LocaleContextHolder.getLocale()
        if (args != null) {
            args = args as Object[]
        }

        println "args: " + args
        println Locale.getDefault()

        String baseDir = "grails-app/i18n/messages"
        def messageSource = new ResourceBundleMessageSource()
        messageSource.basename = baseDir

        return messageSource.getMessage(msgKey, args, locale)
    }

}