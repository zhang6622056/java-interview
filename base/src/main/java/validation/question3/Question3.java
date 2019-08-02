package validation.question3;


/**
 *
 * java 基础方法
 * @author Nero
 * @date 2019-08-02
 * *@param: null
 * @return 
 */
public class Question3 extends BaseQuestion3 implements Cloneable{

    private String username;
    private Integer password;
    private Computer computer;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Question3 question3 = new Question3();
        question3.setComputer(new Computer());
        question3.setUsername("nero");
        Question3 questionAno = (Question3) question3.clone();
        questionAno.setUsername("dante");



        System.out.println(questionAno.getUsername());
        System.out.println(question3.getUsername());


        System.out.println(questionAno == question3);
        System.out.println(questionAno.getComputer() == question3.getComputer());
        System.out.println(questionAno.getUsername() == question3.getUsername());
        System.out.println(questionAno.getPassword() == question3.getPassword());
    }
}
