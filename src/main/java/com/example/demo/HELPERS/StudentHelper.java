package com.example.demo.HELPERS;


import com.example.demo.ResponseClass.CommonResponse;
import com.example.demo.dataAccess.studentDataAccess;
import com.example.demo.secureLogins.commonUser;
import com.example.demo.users.StudentCreateRequest;
import com.example.demo.users.StudentSearchRequest;
import com.example.demo.users.StudentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
;
@Service
public class StudentHelper {
    @Autowired
    private studentDataAccess studentDataAccess;
    public CommonResponse<StudentUser> createStudent(StudentCreateRequest studentCreate) throws Exception {
        CommonResponse<StudentUser> response = new CommonResponse<>();
        List<String> validatingField = new ArrayList<>();
        fieldValidateCreate(validatingField, studentCreate);
        if (!validatingField.isEmpty()) {
            response.setErrors(validatingField);
            response.setResponseCode(401);
            response.setIsValidationSuccess(false);
            return response;
        }
        StudentUser studentUser = new StudentUser();
        commonUser cUser = new commonUser();
        cUser.setId();
        studentUser.setId(cUser.getId());
        studentUser.setAddress(studentCreate.getAddress());
        studentUser.setFatherName(studentCreate.getFatherName());
        studentUser.setFirstName(studentCreate.getFirstName());
        studentUser.setLastName(studentCreate.getLastName());
        studentUser.setMotherName(studentCreate.getMotherName());
        studentUser.setMobileNumber(studentCreate.getMobileNumber());
        studentUser.setMobileNumber2(studentCreate.getMobileNumber2());
        studentUser.setSection(studentCreate.getSection());
        studentUser.setStandard(studentCreate.getStandard());
        studentUser.setRollNumber(studentCreate.getRollNumber());
        cUser.setName(studentCreate.getFirstName()+ " "+ studentCreate.getLastName());
        cUser.setMobileNumber(studentCreate.getMobileNumber());
        response.setResponseObject(studentUser);
        studentDataAccess.create(studentUser, cUser);
        return response;
        
       
        
    }


    public static void fieldValidateCreate(List<String> valid, StudentCreateRequest studentUser) {

        if (ObjectUtils.isEmpty(studentUser.getFirstName())) {
            valid.add("first name can't be empty");
        }
        if (ObjectUtils.isEmpty(studentUser.getMobileNumber())) {
            valid.add("Mobile Number can't be empty");
        }
        if(ObjectUtils.isEmpty(studentUser.getFatherName()) && ObjectUtils.isEmpty(studentUser.getMotherName())){
            valid.add("Either father's name or mother's name is mandatory");
        }
        if(ObjectUtils.isEmpty(studentUser.getAddress())){
            valid.add("Address is mandatory");
        }
        if(ObjectUtils.isEmpty(studentUser.getStandard())){
            valid.add("Standard is mandatory");
        }
        if(ObjectUtils.isEmpty(studentUser.getRollNumber())){
            valid.add("Standard is mandatory");
        }
    }

    public CommonResponse<List<StudentUser>> searchStudent(StudentSearchRequest searchRequest) throws Exception{
        List<StudentUser> listSearch=  new studentDataAccess().searchResult(searchRequest);
        CommonResponse<List<StudentUser>> cUser = new CommonResponse<>();
        cUser.setResponseObject(listSearch);
        return  cUser;



    }
}
