import java.util.ArrayList;
import java.util.Scanner;
public class Film {
    //先定义一下关于电影信息的属性
    private String name;//片名
    private String director;//导演
    private String starring;//主演
    private String plotSummary;//剧情简介
    private String duration;//时长
    private int session;//场次
    private float price;//价格


    //声明一个电影的ArrayList表，以便进行电影信息的存储
    ArrayList<String> film = new ArrayList<>();

    //声明一个Scanner进行对用户的输入进行获取
    Scanner sc = new Scanner(System.in);


    //声明构造函数
    public  Film(){}
    public Film(String name, String director, String starring, String plotSummary, String duration, int session, float price) {
        this.name = name;
        this.director = director;
        this.starring = starring;
        this.plotSummary = plotSummary;
        this.duration = duration;
        this.session = session;
        this.price = price;
    }

    //get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getStarring() {
        return starring;
    }
    public void setStarring(String starring) {
        this.starring = starring;
    }
    public String getPlotSummary() {
        return plotSummary;
    }
    public void setPlotSummary(String plotSummary) {
        this.plotSummary = plotSummary;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public int getSession() {
        return session;
    }
    public void setSession(int session) {
        this.session = session;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    //添加影片的信息
    public void addFilm(){
        System.out.println("请输入影片的名字:");
        name = sc.next();
        film.add(name);
        setName(name);

        System.out.println("请输入影片的导演:");
        director = sc.next();
        film.add(director);
        setDirector(director);

        System.out.println("请输入影片的主演:");
        starring = sc.next();
        film.add(starring);
        setStarring(starring);

        System.out.println("请输入影片的剧情简介:");
        plotSummary = sc.next();
        film.add(plotSummary);
        setPlotSummary(plotSummary);

        System.out.println("请输入影片的时长:");
        duration = sc.next();
        film.add(duration);
        setDuration(duration);

        System.out.println("请输入影片的场次:");
        session = sc.nextInt();
        film.add(String.valueOf(session));
        setSession(session);

        System.out.println("请输入影片的价格:");
        price = sc.nextFloat();
        film.add(String.valueOf(price));

        setPrice(price);

        System.out.println("影片信息添加成功");
    }

    //修改影片的信息
    public void changeFilm(){
        System.out.println("请选择你要修改的电影的信息：1.电影的名字\n2.电影的导演\n3.电影的主演\n4.电影的剧情简介\n5.电影的时长");//没有修改场次和价格
        int chiceNum = sc.nextInt();
        switch (chiceNum){
            case 1:
                film.remove(name);
                System.out.println("请输入电影的名字：");
                name = sc.next();
                film.add(name);
                System.out.println("修改成功！");
                break;
            case 2:
                film.remove(director);
                System.out.println("请输入电影的导演：");
                director = sc.next();
                film.add(director);
                System.out.println("修改成功！");
                break;
            case 3:
                film.remove(starring);
                System.out.println("请输入电影的主演：");
                starring = sc.next();
                film.add(starring);
                System.out.println("修改成功！");
                break;
            case 4:
                film.remove(plotSummary);
                System.out.println("请输入电影的剧情简介：");
                plotSummary = sc.next();
                film.add(plotSummary);
                System.out.println("修改成功！");
                break;
            case 5:
                film.remove(duration);
                System.out.println("请输入电影的时长：");
                duration = sc.next();
                film.add(duration);
                System.out.println("修改成功！");
                break;
            default:
                System.out.println("这是一个无效的数字，请重新进行输入：\n");
                changeFilm();
                break;

        }
    }

    //删除影片的信息
    public void deleteFilm(){
        System.out.println("请输入删除的影片的名字：");
        String willDeleteFilm = sc.next();
        if (willDeleteFilm.equals(film.get(0))){
            film.clear();


            System.out.println("影片删除成功！");
        }else{
            System.out.println("输入的影片名并不存在，请重新输入");
            deleteFilm();
        }

    }

    //列出所有影片的信息
    public  void filmList(){
        System.out.println(film+"\n");
    }

}
