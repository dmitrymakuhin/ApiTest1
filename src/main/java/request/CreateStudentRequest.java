package request;

public class CreateStudentRequest {
    public String name = "name" + System.currentTimeMillis();
    public String email = String.format("dmk.makuhin%s@gmail.com", System.currentTimeMillis());
    public String office = "kalinovka";
    public String mentor = "andrii";
    public String signed_up = "2023-10-25T09:23:55.229Z";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getSigned_up() {
        return signed_up;
    }

    public void setSigned_up(String signed_up) {
        this.signed_up = signed_up;
    }
}
