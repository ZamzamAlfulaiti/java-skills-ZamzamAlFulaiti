//Basic Java Programming
//Let's see my fundamental Java skills
public class UserInfo {
    private String name;
    private int age;
    private String email;
    private boolean isActive;

    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    //this method is to display user information
    public void displayInfo(){
        System.out.println("User Name:"+" "+getName());
        System.out.println("User Age:"+" "+getAge());
        System.out.println("User Email:"+" "+getEmail());
        if(isActive) {
            System.out.println("Active");
        }else{
            System.out.println("UnActive");
        }
    }
    public static void main(String[] args){
        // this is main method to test and run the code
        UserInfo user1 = new UserInfo("Zamzam",21,"zamzam@gmail.com",true);
        UserInfo user2 = new UserInfo("Maal",21,"maal@gmail.com",false);
        UserInfo user3 = new UserInfo("wissal",28,"wissal@gmail.com",true);
        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();
        System.out.println(user1.getEmail());
        user2.setAge(20);
        user3.setActive(false);
    }
}