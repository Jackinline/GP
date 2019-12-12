package ljb;

public class CloneTest1 {
    public static void main(String[] args) throws Exception {
        Student1 st0 = new Student1();
        st0.setName("St0");

        Student1 studentA = new Student1();
        studentA.setName("studentA");

        st0.setFriend(studentA);

        Student1 st1 = (Student1) st0.clone();
        //这个是调用下面的那个方法，然后把这个这个对象Clone到student
        System.out.println(st0);
        System.out.println(st1);
        System.out.println("---------浅复制只复制成员的引用地址--st0 st1有共有的朋友 studentA----------");
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

    //第一种浅克隆
//    @Override
//    public Object clone() throws CloneNotSupportedException
//    {
//
//        Object object = super.clone();
//        return object;
//        //输出
////        Student1{, name='St0', friend=Student1{, name='studentA', friend=null, hashCode=1163157884}, hashCode=1956725890}
////        Student1{, name='St0', friend=Student1{, name='studentA', friend=null, hashCode=1163157884}, hashCode=356573597}
////        ---------浅复制只复制成员的引用地址--st0 st1有共有的朋友 studentA----------
//    }

    //第二种深克隆
    @Override
    public Object clone() throws CloneNotSupportedException {
        //第一种
        Student1 st = (Student1) super.clone();
        if (this.friend != null) {
            st.setFriend((Student1) this.friend.clone());
        }
        return st;
        //输出
//        Student1{, name='St0', friend=Student1{, name='studentA', friend=null, hashCode=1163157884}, hashCode=1956725890}
//        Student1{, name='St0', friend=Student1{, name='studentA', friend=null, hashCode=356573597}, hashCode=1735600054}
//        ---------浅复制只复制成员的引用地址--st0 st1有共有的朋友 studentA----------
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
