package com.example.demo.dataAccess;

import com.example.demo.Repositories.CommonUserRepo;
import com.example.demo.Repositories.studentUserRepo;
import com.example.demo.secureLogins.commonUser;
import com.example.demo.users.StudentSearchRequest;
import com.example.demo.users.StudentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Component  
@Service

public class studentDataAccess {

    @Autowired
    private studentUserRepo strepo;
    @Autowired
    private CommonUserRepo cRepo;


    public void create(StudentUser studentUser,commonUser cUser) throws Exception{
        strepo.save(studentUser);
        cRepo.save(cUser);
    }

    public List<StudentUser> searchResult(StudentSearchRequest searchRequest) throws Exception{

        List<StudentUser> luser = new ArrayList<>();
        Connection con = DriverManager.getConnection("jdbc:mysql://34.100.230.252:3306/eLearn","root","root");
        Statement st = con.createStatement();
        String query = "select * from studentuser where 1=1 ";
        if(!ObjectUtils.isEmpty(searchRequest.getFname())) {
            query = query + "and firstname like '%" + searchRequest.getFname() + "%' ";
        } if(!ObjectUtils.isEmpty(searchRequest.getLname())) {
            query = query + "and lastname like '%" + searchRequest.getLname() + "%' ";
        } if(!ObjectUtils.isEmpty(searchRequest.getFatherName())) {
            query = query + "and fathername like '%" + searchRequest.getFatherName() + "%' ";
        } if(!ObjectUtils.isEmpty(searchRequest.getMotherName())) {
            query = query + "and mothername like '%" + searchRequest.getMotherName() + "%' ";
        } if(!ObjectUtils.isEmpty(searchRequest.getStandard())) {
            query = query + "and standard = '" + searchRequest.getStandard() + "' ";
        } if(!ObjectUtils.isEmpty(searchRequest.getSection())) {
            query = query + "and name section ='" + searchRequest.getSection() + "' ";
        } if(!ObjectUtils.isEmpty(searchRequest.getRollnumber()) && searchRequest.getRollnumber() != 0) {
            query = query + "and roll_number  = " + searchRequest.getRollnumber() +  " ";
        }

        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            StudentUser sUser = new StudentUser();
            sUser.setId(rs.getString(1));
            sUser.setAddress(rs.getString(2));
            sUser.setFatherName(rs.getString(3));
            sUser.setFirstName(rs.getString(4));
            sUser.setLastName(rs.getString(5));
            sUser.setMobileNumber(rs.getString(6));
            sUser.setMobileNumber2(rs.getString(7));
            sUser.setMotherName(rs.getString(8));
            sUser.setRollNumber(rs.getInt(9));
            String temp = rs.getString(10);
            char val = temp.charAt(0);
            sUser.setSection(val);
            sUser.setStandard(rs.getInt(11));
            luser.add(sUser);

        }
        return luser;

    }
}
