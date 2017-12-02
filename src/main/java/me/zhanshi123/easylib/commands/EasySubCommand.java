package me.zhanshi123.easylib.commands;

public class EasySubCommand {
    private String subCommand;
    private CommandLogic logic;
    private EasyCommand easyCommand;

    public EasySubCommand(String subCommand, CommandLogic logic, EasyCommand easyCommand) {
        this.subCommand = subCommand;
        this.logic = logic;
        this.easyCommand = easyCommand;
    }

    public String getSubCommand() {
        return subCommand;
    }

    public void setSubCommand(String subCommand) {
        this.subCommand = subCommand;
    }

    public CommandLogic getLogic() {
        return logic;
    }

    public void setLogic(CommandLogic logic) {
        this.logic = logic;
    }

    public EasyCommand getEasyCommand() {
        return easyCommand;
    }

    public void setEasyCommand(EasyCommand easyCommand) {
        this.easyCommand = easyCommand;
    }
}
