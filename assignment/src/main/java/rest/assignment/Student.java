package rest.assignment;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {

    @Id
    private String id;
    private String name;
    private String dob;
    private String branch;
    private float gpa;
    
    public Student(String id,String name,String dob,String branch,float gpa) {
        this.id=id;
        this.name = name;
        this.dob=dob;
        this.branch=branch;
        this.gpa=gpa;
        
    }

    public Student() {
    }
    public String getid() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdob() {
        return dob;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }
    public String getbranch()
    {
        return branch;
    }
    public void setbranch(String branch)
    {
        this.branch = branch;
    }
    public float getgpa()
    {
        return gpa;
    }
    public void setgpa(float gpa)
    {

        this.gpa=gpa;
    }

    

}
