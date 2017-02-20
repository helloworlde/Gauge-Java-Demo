package model;

public class UserModel {
    private int id;
    private String username;
    private String sex;
    private int age;
    private String school;
    private String major;
    private String address;

    public UserModel() {
        super();
    }

    public UserModel(int id, String username, String sex, int age, String school, String major, String address) {
        super();
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.age = age;
        this.school = school;
        this.major = major;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "db.UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
