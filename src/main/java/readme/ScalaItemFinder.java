package readme;

import java.io.File;

/**
 * @Author: lmmmowi
 * @Date: 2019/7/18
 * @Description:
 */
public class ScalaItemFinder extends ItemFinder {

    @Override
    protected String getLanguage() {
        return "scala";
    }

    @Override
    protected String[] getPackagePath() {
        return new String[]{"com/lmmmowi/leetcode/scala"};
    }

    @Override
    protected File locateSolutionFile(File solutionDir) {
        return new File(solutionDir, "Solution.scala");
    }
}
