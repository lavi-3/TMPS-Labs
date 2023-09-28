package behavioral.command.functionality;

import behavioral.command.introduction.SimuFunctions;

public class GroupTransfer implements Command {

    private SimuFunctions simuFunctions;

    public GroupTransfer(SimuFunctions fs){
        this.simuFunctions =fs;
    }
    @Override
    public String execute() {
       return this.simuFunctions.studentTransfer();
    }

}