import bean.Bean;
import Use.Teacher;
import java.util.ArrayList;

public class A {
    public static void main(String []ags){
        ArrayList<Teacher> a=new ArrayList(); 
        ArrayList<Teacher> b=null;
        a.add(new Teacher("1"));
        a.add(new Teacher("2"));
        a.add(new Teacher("3"));
        a.add(new Teacher("4"));
        a.get(0).Teacherchart[0][0]="A";
        a.get(0).Teacherchart[0][1]="s";
        a.get(0).Teacherchart[0][2]="h";
        a.get(0).Teacherchart[0][3]="i";
        a.get(0).Teacherchart[0][4]="s";
        a.get(0).Teacherchart[0][5]="h";
        Bean be=new Bean();
        be.setT(a);
        b=be.getT();
        for(int i=0;i<6;i++)
        System.out.println(b.get(1).Teacherchart[0][i]);
    }    
}
