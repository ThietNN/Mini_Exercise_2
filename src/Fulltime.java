public class Fulltime extends Employee  {
    private int bonus;
    private int penalty;
    private int fixedWage;

    public Fulltime() {
    }

    public Fulltime(String id, String name, String mail, int age, String phoneNumber, int bonus, int penalty, int fixedWage) {
        super(id, name, mail, age, phoneNumber);
        this.bonus = bonus;
        this.penalty = penalty;
        this.fixedWage = fixedWage;
    }

    public int getBonus() {
        return bonus;
    }

    public int getPenalty() {
        return penalty;
    }

    public int getFixedWage() {
        return fixedWage;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public void setFixedWage(int fixedWage) {
        this.fixedWage = fixedWage;
    }

    @Override
    public int getSalary(){
        return getFixedWage() + getBonus() - getPenalty();
    }

    @Override
    public String toString() {
        return "Fulltime, id = " + super.getId() +
                ", name  " + super.getName() +
                ", mail = " + super.getMail() +
                ", age = " + super.getAge() +
                ", phoneNumber = " + super.getPhoneNumber();
    }
}
