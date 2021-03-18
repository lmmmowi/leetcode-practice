package readme;

/**
 * @Author: lmmmowi
 * @Date: 2019/7/18
 * @Description:
 */
public class SolutionItem implements Comparable<SolutionItem> {

    int num;
    String name;
    String url;
    String language;
    String solutionUrl;
    ProblemType problemType;

    public String getIdentifier() {
        String prefix = problemType.getPrefix();
        return prefix == null ? String.valueOf(num) : prefix + " " + num;
    }

    @Override
    public int compareTo(SolutionItem o) {
        if (problemType.ordinal() < o.problemType.ordinal()) {
            return -1;
        } else if (problemType.ordinal() > o.problemType.ordinal()) {
            return 1;
        } else {
            return num < o.num ? -1 : 1;
        }
    }
}