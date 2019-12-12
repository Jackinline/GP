package ljb;

public class CloneTest3
{
    public static void main(String[] args) throws Exception
    {
        Student1 st0 = new Student1();
        st0.setName("St0");

        Student1 studentA = new Student1();
        studentA.setName("studentA");

        st0.setFriend(studentA);

        Student1 st1 = (Student1)st0.clone();
        //����ǵ���������Ǹ�������Ȼ�������������Clone��student
        System.out.println(st0);
        System.out.println(st1);
        System.out.println("---------ǳ����ֻ���Ƴ�Ա�����õ�ַ--st0 st1�й��е����� studentA----------");
    }
}

class Student3 implements Cloneable
{
    private String name;
    private Student1 friend;
    public Student1 getFriend() {
        return friend;
    }

    public void setFriend(Student1 friend) {
        this.friend = friend;
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
    public Object clone()
    {
        Object object =null;
        try {
            object = super.clone();
            Object cloneFriend = this.friend.clone();
        }catch (Exception e){

        }

        return object;
    }

    @Override
    public String toString() {
        return "Student1{" +
                ", name='" + name + '\'' +
                ", friend=" + friend +
                ", hashCode=" + this.hashCode() +
                '}';
    }
}
