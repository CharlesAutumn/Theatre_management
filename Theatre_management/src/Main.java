// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class Main {

    public void menu(){

        Admin admin = new Admin();
        Manager manager = new Manager();
        Stager stager = new Stager();
        Consumer consumer = new Consumer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------");
        System.out.println("欢迎来到影城系统");
        System.out.println("1.管理员\n2.经理\n3.前台\n4.用户\n5.退出\n");
        System.out.println("-----------------");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                admin.adminPage();
                break;
            case 2:
                manager.managerPage();
                break;
            case 3:
                stager.stagerPage();
                break;
            case 4:
                consumer.consumerMenuOne();
                break;
            case 5:
                System.out.println("感谢使用！");
                break;
            default:
                System.out.println("请输入正确的序号");
                menu();
        }

    }
    public static void main(String[] args) {
        Main demo = new Main();
        demo.menu();
    }
}