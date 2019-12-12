package ljb;

public class CloneTest1 {
    public static void main(String[] args) throws Exception {
        Student1 st0 = new Student1();
        st0.setName("St0");

        Student1 studentA = new Student1();
        studentA.setName("studentA");

        st0.setFriend(studentA);

        Student1 st1 = (Student1) st0.clone();
        //����ǵ���������Ǹ�������Ȼ�������������Clone��student
        System.out.println(st0);
        System.out.println(st1);
        System.out.println("---------ǳ����ֻ���Ƴ�Ա�����õ�ַ--st0 st1�й��е����� studentA----------");
    }
}

class Student1 implements Cloneable {
    private String name;
    private Student1 friend;

    public Student1 getFriend() {
        return friend;
    }

    public void setFriend(Student1 friend) {
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //��һ��ǳ��¡
//    @Override
//    public Object clone() throws CloneNotSupportedException
//    {
//
//        Object object = super.clone();
//        return object;
//        //���
////        Student1{, name='St0', friend=Student1{, name='studentA', friend=null, hashCode=1163157884}, hashCode=1956725890}
////        Student1{, name='St0', friend=Student1{, name='studentA', friend=null, hashCode=1163157884}, hashCode=356573597}
////        ---------ǳ����ֻ���Ƴ�Ա�����õ�ַ--st0 st1�й��е����� studentA----------
//    }

    //�ڶ������¡
    @Override
    public Object clone() throws CloneNotSupportedException {
        //��һ��
        Student1 st = (Student1) super.clone();
        if (this.friend != null) {
            st.setFriend((Student1) this.friend.clone());
        }
        return st;
        //���
//        Student1{, name='St0', friend=Student1{, name='studentA', friend=null, hashCode=1163157884}, hashCode=1956725890}
//        Student1{, name='St0', friend=Student1{, name='studentA', friend=null, hashCode=356573597}, hashCode=1735600054}
//        ---------ǳ����ֻ���Ƴ�Ա�����õ�ַ--st0 st1�й��е����� studentA----------
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
