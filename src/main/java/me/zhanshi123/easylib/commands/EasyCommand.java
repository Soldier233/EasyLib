package me.zhanshi123.easylib.commands;

import me.zhanshi123.easylib.exceptions.NameConflictException;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;

import java.util.ArrayList;
import java.util.List;

public class EasyCommand {
    private String command;
    private List<EasySubCommand> subCommands=new ArrayList<>();
    private EasyCommandExecutor executor=new EasyCommandExecutor();
    private CommandLogic logic;

    public EasyCommand(String command) {
        this.command = command;
        logic=new CommandLogic() {
            @Override
            public boolean run() {
                sender.sendMessage("未指定主命令logic!");
                return false;
            }
        };
    }

    public CommandLogic getLogic() {
        return logic;
    }
    public void setLogic(CommandLogic logic) {
        this.logic = logic;
    }
    public EasyCommand(String command, CommandLogic logic) {
        this.command = command;
        this.logic = logic;
    }

    public void addSubCommand(EasySubCommand subCommand) throws NameConflictException {
        if(exists(subCommand)){
            throw new NameConflictException("子命令名重复! 欲添加的子命令名:"+subCommand.getSubCommand());
        } else{
            subCommands.add(subCommand);
        }
    }

    public EasySubCommand getSubCommand(String name){
        EasySubCommand subCommand=null;
        for(EasySubCommand cmd:subCommands){
            if(cmd.getSubCommand().equals(name)){
                subCommand=cmd;
            }
        }
        return subCommand;
    }

    private boolean exists(EasySubCommand subCommand){
        boolean result=false;
        for(EasySubCommand cmd:subCommands){
            if(cmd.getSubCommand().equals(subCommand.getSubCommand())){
                result=true;
                break;
            }
        }
        return result;
    }

    public String getCommand() {
        return command;
    }

    public void register() throws NameConflictException {
        EasyCommandManager.getInstance().addCommand(this);
        Bukkit.getPluginCommand(command).setExecutor(executor);
    }
}
