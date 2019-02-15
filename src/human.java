public class human {
    //public: mọi đối tượng trong project đều có thể sử dụng biến/class/... này.
    public String name;
    public int age;
    public String phone;
    //hàm tạo:
    public human(){
        this.name = "No name";
        this.age = 10;
        this.phone = "0123456789";
    }
    public human(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    public void eat(){
        System.out.println("Eating...");
    }
    public void sleep(int duration){
        System.out.println("Sleeping in "+ duration + " hours...");
    }
}
