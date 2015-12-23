package pages

import org.springframework.context.MessageSource
import org.springframework.context.support.ReloadableResourceBundleMessageSource

class GetPageTitle {

    final static MessageSource msgSource = new ReloadableResourceBundleMessageSource()
    final static String DIR = "grails-app/i18n/messages"

    static String getMessage(String code, Object[] args = null, Locale locale = Locale.getDefault()){
        if (args != null) {
            args = args as Object[]
        }

        msgSource.basename = DIR;
        return msgSource.getMessage(code, args, locale)
    }

}
