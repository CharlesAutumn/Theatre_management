import java.util.*;
public class Consumer {

    private String username;//用户名
    private String password;
    private String consumerTelephoneNumber;
    private Date registrationTime;//用户注册时间
    private String email;//用户邮箱

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> list =new ArrayList<>();
    Film film = new Film();

    Main demo = new Main();

    public Consumer(){}

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
    public String getConsumerTelephoneNumber() {
        return consumerTelephoneNumber;
    }
    public void setConsumerTelephoneNumber(String consumerTelephoneNumber) {
        this.consumerTelephoneNumber = consumerTelephoneNumber;
    }
    public Date getRegistrationTime() {
        return registrationTime;
    }
    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //登录认证
    public boolean login(String username,String password) {

        if (username.equals(username) && password.equals(password)) {
            System.out.println("登录成功！");
            return true;
        } else {
            System.out.println("用户名或密码错误，登录失败！");
            System.out.println("请重新进行输入");
            return false;
        }

    }

    //用户注册
    public void consumerRegister(){
        System.out.println("请设置你的用户名（不少于5个字符）：");
        username = scanner.next();
        if(username.length()<5){
            System.out.println("用户名少于5个字符，请重试！");
            consumerRegister();
        }
        list.add(username);
        System.out.println("请设置您的密码（大于8个字符）：");
        password = scanner.next();
        if (password.length()<8){
            System.out.println("密码小于8个字符，请重新输入！");
            consumerRegister();
        }
        list.add(password);
        System.out.println("请输入你要绑定的手机号：");
        consumerTelephoneNumber = scanner.next();
        list.add(consumerTelephoneNumber);
        consumerMenuOne();
    }

    //用户登录
    public void consumerLogin(){
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        if (login(username,password)){
            System.out.println();
            consumerMenuTwo();
        }else {
            System.out.println("用户名有误");
            consumerMenuOne();
        }
    }
    //修改密码
    public void changePassword(){
        System.out.println("请输入原密码：");
        //定义一个变量来存储旧的密码
        String oldPassword = scanner.next();

        //对旧密码的正确性进行判断
        if (!password.equals(password)) {
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
            list.remove(username);
            username = newPassword;
            list.add(username);
            System.out.println("修改成功");
        }


    }

    //重置密码
    public void resetPassword() {
        System.out.println("请输入你的用户名");
        String stagerName = scanner.next();
        if (!stagerName.equals(username)) {
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
        if (stagerName.equals(username) && stagerTelephoneNumber.equals(stagerTelephoneNumber)) {
            System.out.println("请设置你的新密码");
            password = scanner.next();
            list.remove(password);
            list.add(password);

        }
    }

    //购票
    public void buy(){
        System.out.println("请选择你要进行的操作");
        System.out.println("1.列出所有影片信息\n2.查询指定电影\n3.购票\n4.取票\n5.查询购票历史\n");
        int ticketChoice = scanner.nextInt();
        switch (ticketChoice){
            case 1:
                film.filmList();
                consumerMenuTwo();
                break;
            case 2:
                System.out.println("请输入你要查询的电影名：");
                String filmName = scanner.next();
                if(Objects.equals(filmName,film.getName())){
                    film.filmList();
                }
                consumerMenuTwo();
                break;
            case 3:
                System.out.println("请输入你要购买几张票：");
                int num = scanner.nextInt();
                System.out.println("价格为：" + 32*num);
                break;
            case 4:
                System.out.println("取票成功！");
                consumerMenuTwo();

                break;
            case 5:
                //TODO 查询历史
                consumerMenuTwo();
                break;
            default:
                System.out.println("请输入正确的序号");
                buy();
        }
    }

    public void consumerMenuOne(){
        System.out.println("------------------------------");
        System.out.println("用户登录界面");
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("请选择你要进行的操作");
        System.out.println("1.注册\n2.登录\n3.密码管理\n4.退出\n");
        int numConsumer = scanner.nextInt();
        switch (numConsumer) {
            case 1:
                consumerRegister();
                consumerMenuOne();
                break;
            case 2:
                if(Objects.equals(username,null)){
                    System.out.println("您还没有进行注册请先注册");
                    consumerMenuOne();
                }
                consumerLogin();
                consumerMenuOne();
                break;
            case 3:
                if(Objects.equals(username,null)){
                    System.out.println("您还没有进行注册请先注册");
                    consumerMenuOne();
                }
                System.out.println("请选择你要进行的操作：");
                System.out.println("1.修改密码\n2.忘记密码\n3.返回\n");
                int num = scanner.nextInt();
                switch (num){
                    case 1:
                        changePassword();
                        consumerMenuOne();
                        System.out.println();
                        break;
                    case 2:
                        resetPassword();
                        System.out.println();
                        break;
                    case 3:
                        consumerMenuOne();
                        break;
                    default:
                        System.out.println("请输入正确的序号");
                        consumerMenuOne();

                }

                break;
            case 4:
                System.out.println("再见！！");
                demo.menu();
                break;

        }

    }
    public void consumerMenuTwo(){
        System.out.println("---------------------------------");
        System.out.println("请选择你要进行的操作：");
        System.out.println("1.购买电影票\n2.退出登录\n");
        System.out.println("---------------------------------");
        int num = scanner.nextInt();
        switch (num){
            case 1:
                buy();
                System.out.println();
                break;
            case 2:
                consumerMenuOne();
                break;
            default:
                System.out.println("请输入正确的序号");
                System.out.println();
                consumerMenuTwo();

        }

    }
}




