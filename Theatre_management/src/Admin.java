import java.util.*;
public class Admin {
    String ADMIN_USERNAME = "admin";
    String ADMIN_PASSWORD = "ynuinfo#777";
    private String username;
    private String password;

    Scanner scanner = new Scanner(System.in);
    Main demo = new Main();
    Film film = new Film();
    ArrayList<String> list = new ArrayList<>();
    Manager manager = new Manager();
    Stager stager = new Stager();
    Consumer consumer = new Consumer();



    public boolean login(String username,String password) {

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("登录成功！");
            return true;
        } else {
            System.out.println("用户名或密码错误，登录失败！");
            System.out.println("请重新进行输入");
            return false;
        }

    }
    public void changePassword(){
        System.out.println("请输入原密码：");
        //定义一个变量来存储旧的密码
        String oldPassword = scanner.next();

        //对旧密码的正确性进行判断
        if (!password.equals(ADMIN_PASSWORD)) {
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
            //感觉这个地方的操作好像有问题
            list.remove(ADMIN_USERNAME);
            ADMIN_USERNAME = newPassword;
            list.add(ADMIN_USERNAME);
            System.out.println("修改成功");
        }


    }

    public void adminPage(){
        System.out.println("——————————————————————————");
        System.out.println("管理员");
        System.out.println("——————————————————————————");
        System.out.println("请输入管理员的名称：");
        String managerName=scanner.next();
        System.out.println("请输入管理员的密码：");
        String password = scanner.next();
        if(login(managerName,password)){
            System.out.println("管理员登录成功！");
            adminMenu();
        }else {
            System.out.println("密码错误请重试");
            adminPage();
        }
    }

    public void adminMenu(){
        System.out.println("----------------------------------------");
        System.out.println("欢迎来到管理员操作界面！");
        System.out.println("----------------------------------------");
        System.out.println("1.登录\n2.密码管理\n3.用户管理\n4.退出\n");
        int choice  = scanner.nextInt();
        switch (choice){
            case 1:
                //登录
                adminPage();
                break;
            case 2:
                //密码管理
                System.out.println("请选择你要进行的操作：");
                System.out.println("1.重置经理的密码\n2.重置前台的密码\n3.返回\n");
                int passwordChoice = scanner.nextInt();
                switch (passwordChoice){
                    case 1:
                        manager.resetPassword();
                        adminMenu();
                        break;
                    case 2:
                        stager.resetPassword();
                        adminMenu();
                        break;
                    case 3:
                        adminMenu();
                        break;
                    default:
                        System.out.println("请输入正确的序号");
                        adminMenu();

                }
                adminMenu();
                break;
            case 3:
                //用户管理
                System.out.println("请选择你要进行的操作：");
                System.out.println("1.列出所有影城方用户的信息\n2.查询所有影城方用户的信息\n3.删除影城方用户的信息\n4.修改影城方用户的信息\n5.返回\n");
                int messageChoice = scanner.nextInt();
                switch (messageChoice){
                    case 1:
                        System.out.println("经理");
                        System.out.println(manager.getUsername()+manager.getManagerTelephoneNumber());
                        System.out.println("前台");
                        System.out.println(stager.getUsername()+stager.getStagerTelephoneNumber());
                        adminMenu();
                        break;
                    case 2:
                        System.out.println("请输入需要查询的用户：");
                        System.out.println("1.经理\n2.前台\n");
                        //名字起不过来了
                        int unkownChoice = scanner.nextInt();
                        switch (unkownChoice){
                            case 1:
                                System.out.println("请输入用户名：");
                                String managerName =scanner.next();
                                if(managerName.equals(manager.getADMIN_USERNAME())){
                                    System.out.println(manager.getADMIN_USERNAME()+manager.getManagerTelephoneNumber());
                                }
                                adminMenu();
                                break;
                            case 2:
                                System.out.println("请输入用户名：");
                                String consumerName =scanner.next();
                                if(consumerName.equals(consumer.getUsername())){
                                    System.out.println(consumer.getUsername()+consumer.getConsumerTelephoneNumber());
                                }
                                adminMenu();

                                break;
                            default:
                                System.out.println();
                                adminMenu();

                        }
                        adminMenu();
                        break;
                    case 3:
                        //TODO 删除影城方用户的信息
                        adminMenu();
                        break;
                    case 4:
                        //TODO 修改影城方用户的信息
                        adminMenu();
                        break;
                    case 5:
                        adminMenu();
                    default:
                        System.out.println("请输入正确的序号");
                        adminMenu();
                }
                adminMenu();
                break;
            case 4:
                //退出
                demo.menu();
                break;
            default:
                System.out.println("输入的序号有问题，请重新输入");
                adminMenu();

        }

    }
    public void showConsumer(){
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // 清除换行符

        switch (choice) {
            case 1:
                //列出
                break;
            case 2:
                //删除
                break;
            case 3:
                //增加

                break;
            case 4:
                //查
            default:
                System.out.println("无效的选项，请重新选择！");
        }
    }

}
