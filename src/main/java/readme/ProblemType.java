package readme;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/18
 * @Description:
 */
public enum ProblemType {

    NORMAL(null),
    OFFER("剑指 Offer");

    private String prefix;

    ProblemType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
