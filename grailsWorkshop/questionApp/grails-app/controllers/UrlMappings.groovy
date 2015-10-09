class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: 'question', action: 'index')
        "500"(view:'/error')
        "404"(view:'/notFound')

        // api endpoints
        "/api/users" (resources:"user")
        "/api/questions" (resources:"question")
    }
}
