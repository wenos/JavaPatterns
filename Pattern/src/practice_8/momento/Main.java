package practice_8.momento;

public class Main {
    public static void main(String[] args) {
        Project project = new Project();
        Repo r = new Repo();
        project.setVandD("1");
        System.out.println(project);
        r.setSave(project.save());
        project.setVandD("2");
        System.out.println(project);
        project.load(r.getSave());
        System.out.println(project);
    }
}
