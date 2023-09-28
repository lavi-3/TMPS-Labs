package behavioral.command.functionality;

import behavioral.command.introduction.SimuFunctions;

public class SetMark implements Command {

    private SimuFunctions simuFunctions;

    public SetMark(SimuFunctions fs){
        this.simuFunctions =fs;
    }
    @Override
    public String execute() {
        return this.simuFunctions.setStudentMark();
    }

}