import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ChangeStudentPojo;
import pojo.CreateStudentPojo;
import pojo.DeleteStudentPojo;
import request.ChangeStudentRequest;
import request.CreateStudentRequest;
import request.DeleteStudentRequest;
import service.StudentService;

public class StudentTests extends BaseTest {


    @Test
    public void createStudent() {
        CreateStudentRequest request = new CreateStudentRequest();

        CreateStudentPojo response = StudentService.createStudent(request);

        Assert.assertEquals(request.getEmail(), response.email);
        Assert.assertEquals(request.getOffice(), response.office);
        Assert.assertEquals(request.getSigned_up(), String.valueOf(response.signed_up));
        Assert.assertEquals(request.getMentor(), response.mentor);
    }

    @Test
    public void changeStudent() {
        CreateStudentRequest request = new CreateStudentRequest();
        ChangeStudentRequest changeStudentRequest = new ChangeStudentRequest();

        int id = StudentService.createStudent(request).id;
        ChangeStudentPojo changeStudentPojo = StudentService.replaceStudent(changeStudentRequest, id);

        Assert.assertEquals(changeStudentRequest.name, changeStudentPojo.name);
        Assert.assertEquals(changeStudentRequest.office, changeStudentPojo.office);
        Assert.assertEquals(changeStudentRequest.mentor, changeStudentPojo.mentor);
    }

    @Test
    public void deleteStudent() {
        CreateStudentRequest request = new CreateStudentRequest();
        DeleteStudentRequest deleteStudentRequest = new DeleteStudentRequest();
        deleteStudentRequest.setEmail(request.getEmail());

        DeleteStudentPojo deleteStudentPojo = StudentService.killStudent(deleteStudentRequest);
    }
}
