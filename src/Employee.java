public abstract class Employee {
    private String id, name, mail, phoneNumber;
    private int age;

    public Employee() {
    }

    public Employee(String id, String name, String mail, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public abstract int getSalary();
    @Override
    public String toString() {
        return "id = " + id +
                ", name  " + name +
                ", mail = " + mail +
                ", age = " + age +
                ", phoneNumber = " + phoneNumber;
    }
}
