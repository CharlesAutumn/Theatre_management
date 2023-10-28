import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    //还是先定义经理的属性，并让经理的用户名不能修改，密码也是不能修改的
    private String ADMIN_USERNAME = "manager";
    private String ADMIN_PASSWORD = "ynuinfo#777";
    private String managerTelephoneNumber = "1234567890";
    private String username;
    private String password;

    //进行构造方法的实现
    //get set方法实现


    public String getADMIN_USERNAME() {
        return ADMIN_USERNAME;
    }

    public void setADMIN_USERNAME(String ADMIN_USERNAME) {
        this.ADMIN_USERNAME = ADMIN_USERNAME;
    }

    public String getADMIN_PASSWORD() {
        return ADMIN_PASSWORD;
    }

    public void setADMIN_PASSWORD(String ADMIN_PASSWORD) {
        this.ADMIN_PASSWORD = ADMIN_PASSWORD;
    }

    public Manager(){}
    public Manager(String managerTelephoneNumber, String username, String password) {
        this.managerTelephoneNumber = managerTelephoneNumber;
        this.username = username;
        this.password = password;
    }

    public String getManagerTelephoneNumber() {
        return managerTelephoneNumber;
    }

    public void setManagerTelephoneNumber(String managerTelephoneNumber) {
        this.managerTelephoneNumber = managerTelephoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //new一下一个Scanner，以用来接收用户的输入
    Scanner scanner = new Scanner(System.in);

    //ArrayList一个list来进行数据的简单存储
    ArrayList<String> list =new ArrayList<>();

    //new 一个电影类
    Film film = new Film();

    //new 一个用户类
    Consumer consumer= new Consumer();

    //new 一个测试类
    Main demo = new Main();

    //登录验证
    public boolean login(String username,String password) {

        //if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            if (username.equals(ADMIN_USERNAME)) {
            System.out.println("登录成功！");
            return true;
        } else {
            System.out.println("用户名或密码错误，登录失败！");
            System.out.println("请重新进行输入");
            return false;
        }

    }

    //密码修改
    public void changePassword(){
        System.out.println("请输入原密码：");
        //定义一个变量来存储旧的密码
        String oldPassword = scanner.next();

        //对旧密码的正确性进行判断
        if (!ADMIN_PASSWORD.equals(oldPassword)) {
            System.out.println("密码错误，登录失败！");
            System.out.println("请重新进行输入");
            changePassword();
        }

        //获取新密码
        System.out.println("请输入新的密码：");
        String newPassword = scanner.next();
        System.out.println("请再次输入新密码：");
        String newPasswordAgain = scanner.next();

        //进行新密码的确认操作
        if(newPassword.equals(newPasswordAgain)){


            list.remove(ADMIN_PASSWORD);
            ADMIN_PASSWORD = newPasswordAgain;

            list.add(ADMIN_PASSWORD);
            System.out.println("修改成功");
        }


    }

    //重置密码
    public void resetPassword() {
        System.out.println("请输入你的用户名");
        String managerName = scanner.next();
        if (!managerName.equals(ADMIN_USERNAME)) {
            System.out.println("用户名错误");
            System.out.println("请重试");
            resetPassword();
        }

        System.out.println("请输入你所绑定的手机号");
        String managerTelephoneNumberNew = scanner.next();
        if (!managerTelephoneNumberNew.equals(managerTelephoneNumber)) {
            System.out.println("输入的手机号有误请重试");
            resetPassword();
        }

            System.out.println("请设置你的新密码");
            ADMIN_PASSWORD = scanner.next();
            list.remove(password);
            password = ADMIN_PASSWORD;
            list.add(password);
        System.out.println("重置成功");
        managerMenu();

    }

    //经理的登录界面
    public void managerPage(){
        System.out.println("——————————————————————————");
        System.out.println("经理");
        System.out.println("——————————————————————————");
        System.out.println("请输入经理的名称：");
        String managerName=scanner.next();
        System.out.println("请输入经理的密码：");
        String password = scanner.next();
        if(login(managerName,password)){
            System.out.println("经理登录成功！");
            managerMenu();
        }else {
            System.out.println("密码错误请重试");
            managerPage();
        }
    }

    public void managerMenu(){
        System.out.println("——————————————————————————");
        System.out.println("经理操作菜单");
        System.out.println("——————————————————————————");
        System.out.println("1.密码管理\n2.影片管理\n3.用户管理\n4.排片管理\n5.退出\n");
        int choice = scanner.nextInt();
        switch (choice){
            //密码管理
            case 1:
                System.out.println("1.修改密码\n2.重置密码\n3.返回");
                int passwordChoice =scanner.nextInt();
                switch (passwordChoice){
                    //修改密码
                    case 1:
                        changePassword();
                        managerMenu();
                        break;
                    case 2:
                        resetPassword();
                        break;
                    case 3:
                        managerMenu();
                    default:
                        System.out.println("输入的序号无效！");
                        managerMenu();
                }
                break;
            //影片管理
            case 2:
                System.out.println("1.列出所有影片信息\n2.添加影片信息\n3.修改影片信息\n4.删除影片信息\n5.查询影片信息\n6.返回");
                int filmChoice =scanner.nextInt();
                switch (filmChoice){
                    case 1:
                        film.filmList();
                        managerMenu();
                        break;
                    case 2:
                        film.addFilm();
                        managerMenu();
                        break;
                    case 3:
                        film.changeFilm();
                        managerMenu();
                        break;
                    case 4:
                        film.deleteFilm();
                        managerMenu();
                        break;
                    case 5:
                        System.out.println("请输入你要查询的电影名称：");
                        String filmName = scanner.next();
                        if(film.getName().equals(filmName)){
                            System.out.println(film.getName() +film.getDirector() +film.getStarring() +film.getPlotSummary() +film.getDuration() +film.getPrice());
                        }else {
                            System.out.println("并没有你要查找的电影");
                        }
                        managerMenu();
                        break;
                    case 6:
                        managerMenu();
                        break;
                    default:
                        System.out.println("请输入有效的数字");
                        managerMenu();

                }
                break;
            //用户管理
            case 3:
                System.out.println("1.列出所有用户信息\n2.查询用户信息\n3.返回");
                int consumerChoice = scanner.nextInt();
                switch (consumerChoice){
                    case 1:
                        //此处功能不全 不太会
                        System.out.println(consumer.getUsername()+consumer.getConsumerTelephoneNumber());
                        managerMenu();
                        break;
                    case 2:
                        System.out.println("请输入需要查询的用户名称：");
                        String consumerName = scanner.next();
                        if(consumerName.equals(consumer.getUsername())){
                            System.out.println(consumer.getUsername()+consumer.getConsumerTelephoneNumber());
                            managerMenu();
                        }
                        break;
                    case 3:
                        managerMenu();
                        break;
                    default:
                        System.out.println("请输入有效数据");
                        managerMenu();
                }
                break;
            //排片管理
            case 4:
                System.out.println("请选择你要进行的操作：");
                System.out.println("1.增加场次\n2.修改场次\n3.删除场次\n4.列出所有场次信息\n5.返回");
                int filmSortChoice = scanner.nextInt();
                switch (filmSortChoice){
                    case 1:
                        //TODO 实现增加场次的操作
                        System.out.println("增加场次成功！");
                        managerMenu();
                        break;
                    case 2:
                        //TODO 实现修改场次的操作
                        System.out.println("修改场次成功！");
                        managerMenu();
                        break;
                    case 3:
                        //TODO 实现删除场次的操作
                        System.out.println("删除场次成功!");
                        managerMenu();
                        break;
                    case 4:
                        //TODO 实现列出所有场次信息
                        System.out.println("列出所有哦场次信息");
                        managerMenu();
                        break;
                    case 5:
                        managerMenu();
                        break;
                    default:
                        System.out.println("请输入正确的数字");
                        break;

                }
                break;
            case 5:
                demo.menu();
                break;
            default:
                System.out.println("请重新输入");
                managerMenu();
                break;



        }
    }

}
