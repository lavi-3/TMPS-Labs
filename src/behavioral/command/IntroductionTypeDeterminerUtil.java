package behavioral.command;

import behavioral.command.introduction.SimuFunctions;
import behavioral.command.introduction.ImportStrategy;
import behavioral.command.introduction.HandIntroductionStrategy;

public class IntroductionTypeDeterminerUtil {

    public static SimuFunctions getIntroductionType(SimuFunctions simuFunctions) {
        if (simuFunctions.getClass().equals(ImportStrategy.class)) {
            return new ImportStrategy();
        } else {
            return new HandIntroductionStrategy();
        }
    }

}