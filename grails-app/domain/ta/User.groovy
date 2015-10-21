package ta

class User {
    String name
    String username
    String passwordHash
    String email
    Boolean active
    Boolean enabled


    static constraints = {
        name(nullable: false, blank: false)
        username(unique:true,nullable: false, blank: false,size: 5..20)
        email(unique:true,email: true, nullable: false)
        active(nullable: true)
        enabled(blank: false)
    }



    String toString(){return this.name}
}
