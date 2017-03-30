package zzy.mz_dream.model;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/28 15:47
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class MsgeventModel {

    private String name;
    private int age;

    public MsgeventModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
