package behavioral.command.functionality;

import behavioral.command.introduction.SimuFunctions;

public class SetTeacher implements Command {

    private SimuFunctions simuFunctions;

    public SetTeacher(SimuFunctions fs){
        this.simuFunctions =fs;
    }
    @Override
    public String execute() {
        return this.simuFunctions.setTeacher();
    }

}
