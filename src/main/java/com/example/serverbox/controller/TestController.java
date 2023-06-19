package com.example.serverbox.controller;

import com.example.serverbox.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/rest-template")
public class TestController {

    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = "/test-server")
    public String getTest1() {
        LOGGER.info("getTest1호출");
        return "Hello Test Server";
    }

    @GetMapping(value = "/name")
    public String getTest2(@RequestParam String name) {
        LOGGER.info("getTest2호출");
        return "Hello " + name + "!";
    }

    @GetMapping(value = "/path-variable/{name}")
    public String getTest4(@PathVariable String name) {
        LOGGER.info("getTest3호출");
        return "Hello "+name+"!";
    }

    @PostMapping(value = "/member")
    public ResponseEntity<MemberDTO> getMember(
            @RequestBody MemberDTO memberDTO,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
         LOGGER.info("getMember 호출");

//         MemberDTO memberDTO1 = new MemberDTO();
         return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }

    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDTO> addHeader(@RequestHeader("test-header") String header, @RequestBody MemberDTO memberDTO) {
        LOGGER.info("add-header 호출!");
        LOGGER.info("header 값 : {}", header);

        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }


}
