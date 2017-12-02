package me.zhanshi123.easylib.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EasyCommandExecutor implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String cmd=command.getName();
        EasyCommand easyCommand=EasyCommandManager.getInstance().getCommand(cmd);
        if(args.length==0){
            return easyCommand.getLogic().setCommand(command).setSender(sender).run();
        }
        else{
            EasySubCommand subCommand=easyCommand.getSubCommand(args[0]);
            if(subCommand==null){
                return false;
            }
            else{
                return subCommand.getLogic().setCommand(command).setSender(sender).setArgs(args).run();
            }
        }
    }
}
