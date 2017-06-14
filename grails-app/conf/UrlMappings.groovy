class UrlMappings {

    static mappings = {
        "/autoaval/$turma/$login?" (controller: "AutoAvaliacao", action: "form")
        "/$controller/$action?/$id?/$extra?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
