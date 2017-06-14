package ta

class AutoAvaliacaoController {

    def emailService
    def autoavaliacao = null

    def index() {
        redirect controller: "estudante", action: "index"
    }
    def form(){

        def data = getEstudanteDataFromParams(params)
        data['notas'] = Nota.valores

        render (view: "/autoAvaliacao/form.gsp", model: data)
    }
    def submit(){
        def data = getEstudanteEClassificacoesDataFromParams(params)

        render(view: "/autoAvaliacao/submit.gsp", model: data)
    }
    /**
     * Confirma auto avaliação enviando resultado ao email oficial da turma e opcionalmente ao aluno
     *
     * (params), onde
     * String params.turma, codigo da turma
     * String params.login, login do aluno
     * String params.nomeCompleto, nome completo do aluno
     * boolean mailme, determina se email deve ser enviado ao aluno
     *
     * @return void
     */
    def confirm(){

        concluir(params)

        redirect action: "done"
    }
    def done(){
        [smtp: emailService.SMTP]
    }
    /**
     * Conclui auto avaliação enviando email ao email oficial da disciplina e opcionalmente ao aluno
     *
     */
    void concluir(_params){

        emailAutoAvaliacao_professor(_params)

        if(_params.copia)
            emailAutoAvaliacao_aluno(_params)
    }

    void emailAutoAvaliacao_professor(data){
        /**
         * Qualquer implementação de email
         * Nada está sendo feito aqui, apenas adicionando um Email vazio à uma lista SMTP ficticia
         */

        String addr = Turma.findByCod(data.turma).getEmailAddress()
        emailService.sendEmail(
            new Email(
                recipient: "Professor, " + addr,
                subject: "Auto Avaliação - " + data.login,
                body: EmailFormatter.formatListOfAutoProfObj(autoavaliacao)
            )
        )
    }
    void emailAutoAvaliacao_aluno(data){
        /**
         * Qualquer implementação de email
         * Nada está sendo feito aqui, apenas adicionando um Email vazio à uma lista SMTP ficticia
         */

        String addr = Estudante.findByLogin(data.login).getEmailAddress()

        emailService.sendEmail(
            new Email(
                recipient: data.nomeCompleto + ", " + addr,
                subject: "Auto Avaliação - " + data.login,
                body: EmailFormatter.formatListOfAutoProfObj(autoavaliacao)
            )
        )
    }
    def getEstudanteEClassificacoesDataFromParams(params){
        def sub = params.findAll{key, value -> key.isNumber() && value in ["MA", "MPA", "MANA"]}
        def classif = []
        def data = getEstudanteDataFromParams(params)

        Classificacao prof, auto
        sub.each{key, value ->
            Nota nova = new Nota(valor: value)
            prof = data.classificacoes.find{it.id == key.toInteger()}
            auto = new Classificacao([
                meta: prof.meta,
                nota: nova
            ])
            auto.save(flush:true)
            classif.add([
                    auto: auto,
                    prof: prof
            ])
        }
        if(autoavaliacao == null)
            autoavaliacao = classif

        return [alteracoes: classif] + data
    }
    def getEstudanteDataFromParams(params){
        String login = params.login
        String turmaCod = params.turma

        Estudante estModel = Estudante.findByLoginAndTurma(
                login,
                Turma.findByCod(turmaCod)
        )


        return [
                estudante: estModel,
                login: login,
                turma: turmaCod,
                classificacoes: estModel.classificacoes
        ]
    }
}
