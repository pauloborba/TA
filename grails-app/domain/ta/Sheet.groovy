package ta

class Sheet {

    String filename

    static constraints = {
    }

    def validFileFormat(){
        String fileformat = filename.substring(filename.lastIndexOf('.')+1);

        boolean ok = true;
        ok = fileformat in ["csv","xlsx"];

        return ok;
    }
}
