package ljb;

public class CloneTest2
{
    public static void main(String[] args) throws Exception
    {
        Teacher teacher = new Teacher();
        teacher.setAge(40);
        teacher.setName("teacher zhang");
        Student2 student2 = new Student2();
        student2.setAge(14);
        student2.setName("lisi");
        student2.setTeacher(teacher);
        Student2 student3 = (Student2)student2.clone();
        //��������ƣ�������ʱ��Student2�е�teacher����teacher��������һ�����ƣ��ͺ�student3��student2��һ������
        //��������teacher.setNameֻ�Ƕ���ԭ�������������ģ����Ǹ��Ƶ��Ǹ���û�и���
        System.out.println(student3.getAge());
        System.out.println(student3.getName());
        System.out.println(student3.getTeacher().getAge());
        teacher.setName("teacher niesong");//�������κ�Ӱ��
        System.out.println(student3.getTeacher().getName());
    }
}
class Student2 implements Cloneable
{
    private int age;
    private String name;
    private Teacher teacher;
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Teacher getTeacher()
    {
        return teacher;
    }
    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        //��һ�����ص����student2��ֻ��һ��ǳ��¡��
        Student2 student2 = (Student2)super.clone();
        //Ȼ���¡�Ĺ����л�������¡��student2��Ȼ��������getTeacher����������õ����Teacher����Ȼ��ʵ�ֿ�¡�������õ����student2�е�Teacher��
        //����ʵ����˫���¡ʹ���Ǹ�teacher����Ҳ�õ��˸��ơ�
        student2.setTeacher((Teacher)student2.getTeacher().clone());
        //˫���¡ʹ���Ǹ�teacher����Ҳ�õ��˸���
        return student2;
    }
}
class Teacher implements Cloneable
{
    private int age;
    private String name;
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}