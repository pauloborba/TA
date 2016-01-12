package ta

class Sheet {
    String filename;

    static constraints = {
        filename nullable: false, minSize: 1
    }
}
