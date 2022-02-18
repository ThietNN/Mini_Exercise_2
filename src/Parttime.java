public class Parttime extends Employee {
    private int time;

    public Parttime() {
    }

    public Parttime(String id, String name, String mail, int age, String phoneNumber, int time) {
        super(id, name, mail, age, phoneNumber);
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int getSalary(){
        return getTime() * 100000;
    }

    @Override
    public String toString() {
        return "Parttime, id = " + super.getId() +
                ", name  " + super.getName() +
                ", mail = " + super.getMail() +
                ", age = " + super.getAge() +
                ", phoneNumber = " + super.getPhoneNumber();
    }

}
