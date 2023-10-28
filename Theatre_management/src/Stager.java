import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Stager {
    private String Stager_USERNAME = "stager";
    private String Stager_PASSWORD = "ynuinfo#777";
    private String stagerTelephoneNumber = "1234567890";
    private String username;
    private String password;
    Scanner scanner = new Scanner(System.in);
    Main demo = new Main();
    Film film = new Film();
    ArrayList<String> list = new ArrayList<>();
    public Stager(){}

    public String getStagerTelephoneNumber() {
        return stagerTelephoneNumber;
    }

    public void setStagerTelephoneNumber(String stagerTelephoneNumber) {
        this.stagerTelephoneNumber = stagerTelephoneNumber;
    }

    public Stager(String username, String password) {
        this.username = username;
        this.password = password;
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



    //登录验证
    public boolean login(String username, String password) {

        if (username.equals(Stager_USERNAME) && password.equals(Stager_PASSWORD)) {
            System.out.println("登录成功！");
            return true;
        } else {
            System.out.println("用户名或密码错误，登录失败！");
            System.out.println("请重新进行输入");
            return false;
        }

    }

    //重置密码
    public void resetPassword() {
        System.out.println("请输入你的用户名");
        String stagerName = scanner.next();
        if (!stagerName.equals(Stager_USERNAME)) {
            System.out.println("用户名错误");
            System.out.println("请重试");
            resetPassword();
        }
        System.out.println("请输入你所绑定的手机号");
        String stagerTelephoneNumber = scanner.next();
        if (!stagerTelephoneNumber.equals(stagerTelephoneNumber)) {
            System.out.println("输入的手机号有误请重试");
            resetPassword();
        }
        if (stagerName.equals(Stager_USERNAME) && stagerTelephoneNumber.equals(stagerTelephoneNumber)) {
            System.out.println("请设置你的新密码");
            Stager_PASSWORD = scanner.next();
            list.remove(password);
            Stager_PASSWORD = password;
            list.add(password);
        }
    }

    //前台的登录界面
    public void stagerPage() {
        System.out.println("——————————————————————————");
        System.out.println("前台");
        System.out.println("——————————————————————————");
        System.out.println("请输入前台的名称：");
        String managerName = scanner.next();
        System.out.println("请输入前台的密码：");
        String password = scanner.next();
        if (login(managerName, password)) {
            System.out.println("前台登录成功！");
            stagerMenu();
        } else {
            System.out.println("密码错误请重试");
            stagerPage();
        }
    }

    //前台的操作界面
    public void stagerMenu() {
        System.out.println("——————————————————————————");
        System.out.println("前台操作菜单");
        System.out.println("——————————————————————————");
        System.out.println("1.登录\n2.影片管理\n3.退出\n");
        int choice = scanner.nextInt();
        switch (choice) {
            //登录管理
            case 1:
                stagerPage();
                break;
            case 2:
                System.out.println("1.列出所有正在上映的电影\n2.列出指定的电影信息\n3.售票\n4.返回");
                int filmChoice = scanner.nextInt();
                switch (filmChoice) {
                    //列出所有正在上映的电影
                    case 1:
                        film.filmList();
                        stagerMenu();
                        break;
                    //列出指定的电影信息
                    case 2:
                        System.out.println("请输入所需要查询的电影名：");
                        String filmName = scanner.next();
                        if (Objects.equals( filmName,film.getName())) {
                            film.filmList();
                        }
                        stagerMenu();
                        break;
                    //售票
                    case 3:
                        System.out.println("售票成功！");
                        stagerMenu();
                        break;
                    case 4:
                        stagerMenu();
                    default:
                        System.out.println("输入的序号无效！");
                        stagerMenu();
                }
                break;
            case 3:
                demo.menu();
                break;
            default:
                System.out.println("你输入的序号无效");
                stagerMenu();
        }


    }
}



