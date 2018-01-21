/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Use;

/**
 *
 * @author AshishAashu
 */
public class ClassRoom {
    public String[][] classchart={{null,null,null,null,null,null,null},{null,null,null,null,null,null,null},{null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null},{null,null,null,null,null,null,null},{null,null,null,null,null,null,null}}; 
    public String rid,rdept,raf;
    public ClassRoom(String rid,String rdept,String raf){
        this.rid=rid;
        this.rdept=rdept;
        this.raf=raf;
    }

    public String getRid() {
        return this.rid;
    }
    public String getRaf(){
        return this.raf;
    }

    public String getRdept() {
        return this.rdept;
    }
}
