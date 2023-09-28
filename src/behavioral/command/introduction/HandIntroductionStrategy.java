package behavioral.command.introduction;

import behavioral.strategy.IntroductionStrategy;

public class HandIntroductionStrategy implements IntroductionStrategy, SimuFunctions {

    private String name;
    private String idnp;

    public HandIntroductionStrategy() {
    }

    public HandIntroductionStrategy(String name, String idnp) {
        this.name = name;
        this.idnp = idnp;
    }

    @Override
    public void introduction(int nrStudents) {
        System.out.println(nrStudents + " introduced manually.");
    }

    @Override
    public String studentTransfer() {
        return "Transfer students manually from one group to another";
    }

    @Override
    public String setStudentMark() {
        return "Set student mark manually";
    }

    @Override
    public String setTeacher() {
        return "Set student teacher manually";
    }
}
