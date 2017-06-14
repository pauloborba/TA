package ta

class Turma {

    String cod
    List metas
    static constraints = {
        cod unique : true, blank: false
    }
    static hasMany = [metas:Meta]

    Turma(String cod){
        this.cod = cod
    }
    String toString(){
        return cod
    }
    List getMetas(){
        return metas
    }
    String getEmailAddress(){
        return cod + "@domain.com"
    }
    void addMeta(Meta meta){
        addToMetas(meta)
    }
    boolean equals(Object other){
        return (other instanceof Turma) && ((Turma) other).cod == cod
    }
}
