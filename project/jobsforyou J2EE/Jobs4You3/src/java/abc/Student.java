package abc;


public class Student
{   
   public String name,skill;
   public int id;
   public double graduationmarks,tenthmarks,twelvethmarks;
    public Student(int id,String name,double graduationmarks, double tenthmarks, double twelvethmarks,String skill)
    {
        this.id = id;
        this.name = name;
        this.skill = skill;
        this.graduationmarks = graduationmarks;
        this.tenthmarks = tenthmarks;
        this.twelvethmarks = twelvethmarks;
    }
}
