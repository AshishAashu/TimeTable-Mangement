package bean;

import Use.ClassRoom;
import Use.Teacher;
import java.util.ArrayList;

public class Bean {
    public ArrayList t,c;

    public ArrayList<ClassRoom> getC() {
        return c;
    }

    public void setC(ArrayList<ClassRoom> c) {
        this.c = c;
    }

    public ArrayList<Teacher> getT() {
        return t;
    }

    public void setT(ArrayList<Teacher> t) {
        this.t = t;
    }
    
}
