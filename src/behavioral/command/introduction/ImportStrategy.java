package behavioral.command.introduction;

import behavioral.strategy.IntroductionStrategy;

public class ImportStrategy implements IntroductionStrategy, SimuFunctions {

    private String name;
    private String source;
    private String dateOfStart;

    public ImportStrategy(String nm, String ccNum, String expiryDate){
        this.name=nm;
        this.source =ccNum;
        this.dateOfStart =expiryDate;
    }

    public ImportStrategy() {
    }

    @Override
    public void introduction(int nrStudents) {
        System.out.println(nrStudents +" introduced by Import File");
    }

    @Override
    public String studentTransfer() {
        return "Transfer students from file";
    }

    @Override
    public String setStudentMark() {
        return "Set student mark from file";
    }

    @Override
    public String setTeacher() {
        return "Set teacher from file";
    }
}
