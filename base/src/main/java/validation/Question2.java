package validation;


import java.util.Objects;

public class Question2 {
    private String username;
    private String pwd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question2 question2 = (Question2) o;
        return Objects.equals(username, question2.username) &&
                Objects.equals(pwd, question2.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, pwd);
    }
}
