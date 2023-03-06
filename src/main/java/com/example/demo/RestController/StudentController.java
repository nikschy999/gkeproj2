package com.example.demo.RestController;


import com.example.demo.HELPERS.StudentHelper;
import com.example.demo.ResponseClass.CommonResponse;

import com.example.demo.users.StudentCreateRequest;
import com.example.demo.users.StudentSearchRequest;
import com.example.demo.users.StudentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController()
public class StudentController {
        @Autowired
        StudentHelper studentHelper;
    @PostMapping("create/student")
    public CommonResponse<StudentUser> createStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
        try {
            
            return studentHelper.createStudent(studentCreateRequest);

        } catch (Throwable t) {
            System.out.println(t);
            return null;
        }


    }

    @PostMapping("search/student")
    public CommonResponse<List<StudentUser>> searchStudent(@RequestBody StudentSearchRequest searchRequest){
        try{
            return studentHelper.searchStudent(searchRequest);
        }catch (Throwable t){
            System.out.println(t);
            CommonResponse<List<StudentUser>> cUser = new CommonResponse<>();
            cUser.setIsProcessingSuccess(false);
            cUser.setResponseCode(404);
            return cUser;

        }
    }
}

