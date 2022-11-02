package readme;

import java.io.File;

/**
 * @Author: lmmmowi
 * @Date: 2022/11/2
 * @Description:
 */
public class CppItemFinder extends ItemFinder {

    @Override
    protected String getLanguage() {
        return "cpp";
    }

    @Override
    protected String[] getPackagePath() {
        return new String[]{""};
    }

    @Override
    protected File locateSolutionFile(File solutionDir) {
        return new File(solutionDir, "Solution.cpp");
    }
}
