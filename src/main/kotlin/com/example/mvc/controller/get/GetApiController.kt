package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.apache.catalina.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/hello")
    fun hello(): String{
        return "hello kotlin"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("이름: ${name}, 나이: ${age}")
        return name+" "+age
    }

    // pathvariable 속성 키값과 변수명 맞출 필요가 있을 때
    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable age: Int): String {
        val name = "kotlin"

        println("이름: ${_name}, 나이: ${age}")
        return name+" "+age
    }

    // query param
    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam name: String
        ,@RequestParam age: Int
    ): String{
        println("이름: ${name}, 나이: ${age}")
        return name+" "+age
    }

    // query param object(json)
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

}