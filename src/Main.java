import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee[] baseEmployee = new Employee[4];
        baseEmployee[0] = new Fulltime("12","NNT","nnt@gmail.com",24,"123456789",250000,120000,15000000);
        baseEmployee[1] = new Fulltime("25","TNN","tnn@gmail.com",24,"987654321",120000,250000,30000000);
        baseEmployee[2] = new Parttime("16","Thiet","thiet@gmail.com",16,"25121998",125);
        baseEmployee[3] = new Parttime("7","Nguyen","nguyen@gmail.com",7,"19981225",167);

        Employee[] employee = baseEmployee;

        Scanner sc = new Scanner(System.in);
        System.out.println("Menu: ");
        System.out.println("1. Hiển thị thông tin của toàn bộ nhân viên");
        System.out.println("2. Thêm nhân viên");
        System.out.println("3. Hiển thị những nhân viên Fulltime có mức lương dưới trung bình");
        System.out.println("4. Hiển thị số lương phải trả cho toàn bộ nhân viên mỗi tháng");
        System.out.println("5. Sắp xếp nhân viên Fulltime theo thứ tự lương tăng dần");
        System.out.println("6. Thoát chương trình");
        int choice;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> getInfo(employee);
                case 2 -> {
                    employee = increaseSize(employee, 1);
                    addEmployee(employee, createEmployee());
                }
                case 3 -> {
                    int average = getAverage(employee);
                    getBelow(employee,average,"Fulltime");
                }
                case 4 -> getSumSalary(employee);
                case 5 -> {
                    System.out.println("Thứ tự nhân viên trước khi sắp xếp: ");
                    Employee[] fulltimeEmployee = create1TypeArray(employee,"Fulltime");
                    getInfo(fulltimeEmployee);
                    System.out.println("Thứ tự nhân viên sau khi sắp xếp: ");
                    sort(fulltimeEmployee);
                    getInfo(fulltimeEmployee);
                }
            }
        }while (choice != 6);
    }
    // Phương thức copy array cũ, tăng kích thước array
    public static Employee[] increaseSize(Employee[] employee, int increase){
        int position = 0;
        int newlength = employee.length + increase;
        Employee[] newEmployee = new Employee[newlength];
        for (Employee staff : employee) {
            newEmployee[position] = staff;
            position++;
        }
        return newEmployee;
    }

    // Phương thức thêm nhân viên mới
    public static void addEmployee(Employee[] employee, Employee newEmployee){
        employee[employee.length - 1] = newEmployee;
    }

    public static void setFulltimeInfo(Fulltime employee){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập lương cứng của nhân viên: ");
        employee.setFixedWage(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập tiền thưởng của nhân viên: ");
        employee.setBonus(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập tiền phạt của nhân viên: ");
        employee.setPenalty(Integer.parseInt(sc.nextLine()));
    }

    public static void setParttimeInfo(Parttime employee){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số giờ làm việc của nhân viên: ");
        employee.setTime(Integer.parseInt(sc.nextLine()));
    }

    // Thông tin cơ bản của nhân viên
    public static void setBasicInfo(Employee employee){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID của nhân viên: ");
        employee.setId(sc.nextLine());
        System.out.println("Nhập tên của nhân viên: ");
        employee.setName(sc.nextLine());
        System.out.println("Nhập tuổi của nhân viên: ");
        employee.setAge(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhập địa chỉ thư điện tử của nhân viên: ");
        employee.setMail(sc.nextLine());
        System.out.println("Nhập số điện thoại của nhân viên: ");
        employee.setPhoneNumber(sc.nextLine());
    }

    // Phương thức tạo nhân viên mới
    public static Employee createEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Fulltime / Parttime?");
        System.out.println("Nhập F để thêm mới nhân viên Fulltime, hoặc nhập kí tự bất kì để thêm mới nhân viên Parttime");
        String type = sc.nextLine();

        if (type.equals("F")) {
            Fulltime employee = new Fulltime();
            setFulltimeInfo(employee);
            setBasicInfo(employee);
            System.out.println("Đã tạo nhân viên Fulltime mới");
            return employee;
        }
        else {
            Parttime employee = new Parttime();
            setParttimeInfo(employee);
            setBasicInfo(employee);
            System.out.println("Đã tạo nhân viên Parttime mới");
            return employee;
        }
    }



    // Hiện thị thông tin toàn bộ nhân viên
    public static void getInfo(Employee[] employee){
        for (Employee staff : employee) {
                System.out.println(staff);
        }
    }

    // Tính trung bình cộng lương của toàn bộ nhân viên
    public static int getAverage(Employee[] employee){
        int sum = 0;
        int average;
        for (Employee staff : employee){
                sum += staff.getSalary();
        }
        average = sum / employee.length;
        return average;
    }

    // Kiểm tra lương dưới trung bình của từng nhân viên thuộc chung 1 lớp
    public static void getBelow(Employee[] employee,  int value, String type){
        if (type.equals("Fulltime")) {
            for (Employee staff : employee) {
                if (staff instanceof Fulltime) {
                    if (staff.getSalary() < value)
                        System.out.println("Nhân viên " + staff.getName() + ", ID: " + staff.getId() + " có mức lương dưới trung bình" + " (" + staff.getSalary() + ")");
                }
            }
        }
        else{
            for (Employee staff : employee) {
                if (staff instanceof Parttime) {
                    if (staff.getSalary() < value)
                        System.out.println("Nhân viên " + staff.getName() + ", ID: " + staff.getId() + " có mức lương dưới trung bình" + " (" + staff.getSalary() + ")");
                }
            }
        }
    }

    // Số lương phải trả cho toàn bộ nhân viên Parttime
    public static void getSumSalary(Employee[] employee){
        int sum = 0;
        for (Employee staff : employee){
            if (staff instanceof Parttime){
                sum += staff.getSalary();
            }
        }
        System.out.println("Tổng số lương phải trả cho toàn bộ nhân viên Parttime là: " + sum);
    }

    // Tạo mảng chỉ có 1 loại nhân viên
    public static Employee[] create1TypeArray(Employee[] employee , String type){
        int position = 0;
        int arrayLength = 0;
        if (type.equals("Fulltime")) {
            for (Employee staff : employee) {
                if (staff instanceof Fulltime)
                    arrayLength++;
            }
            Employee[] resultEmployee = new Employee[arrayLength];
            for (Employee staff : employee) {
                if (staff instanceof Fulltime) {
                    resultEmployee[position] = staff;
                    position++;
                }
            }
            return resultEmployee;
        }
        else {
            for (Employee staff : employee) {
                if (staff instanceof Parttime)
                    arrayLength++;
            }
            Employee[] resultEmployee = new Employee[arrayLength];
            for (Employee staff : employee) {
                if (staff instanceof Parttime) {
                    resultEmployee[position] = staff;
                    position++;
                }
            }
            return resultEmployee;
        }
    }

    // Sắp xếp nhân viên theo thứ tự lương tăng dần
    public static void sort(Employee[] employee){
        Employee temp;
        for (int i = 0 ; i < employee.length - 1 ; i++){
            if (employee[i].getSalary() > employee[i+1].getSalary()){
                temp = employee[i];
                employee[i] = employee[i+1];
                employee[i+1] = temp;
            }
        }
    }

}
