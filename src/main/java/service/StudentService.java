package service;

import pojo.ChangeStudentPojo;
import pojo.CreateStudentPojo;
import pojo.DeleteStudentPojo;
import request.ChangeStudentRequest;
import request.CreateStudentRequest;
import request.DeleteStudentRequest;

public class StudentService {

    private static final String END_POINT_STUDENT = "/student";

    public static CreateStudentPojo createStudent(CreateStudentRequest requestBody) {
        return new BaseService()
                .auth()
                .setEndPoint(END_POINT_STUDENT)
                .postRequest(requestBody)
                .as(CreateStudentPojo.class);
    }

    public static ChangeStudentPojo replaceStudent(ChangeStudentRequest requestBody, int studentId) {
        return new BaseService()
                .auth()
                .setEndPoint(END_POINT_STUDENT + "/" + studentId)
                .putRequest(requestBody)
                .as(ChangeStudentPojo.class);
    }

    public static DeleteStudentPojo killStudent(DeleteStudentRequest requestBody) {
        return new BaseService()
                .auth()
                .setEndPoint(END_POINT_STUDENT)
                .postRequest(requestBody)
                .as(DeleteStudentPojo.class);
    }
}
