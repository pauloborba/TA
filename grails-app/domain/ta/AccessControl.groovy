package ta

class AccessControl {
        String name
        String description
        Date dateCreated
        Date lastUpdated
        def beforeInsert = {
            dateCreated = new Date()
        }
        def beforeUpdate = {
            lastUpdated = new Date()
        }

        static hasMany = [ users: Student, permissions: String ]
        static belongsTo = Student

        static constraints = {
            name(nullable: false, blank: false, unique: true)
            description(nullable: true)
        }

        static mapping = {
            cache true
        }

        String toString(){name}
}

