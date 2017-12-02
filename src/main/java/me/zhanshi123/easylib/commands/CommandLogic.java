package me.zhanshi123.easylib.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class CommandLogic {
    CommandSender sender;
    Command command;
    String[] args;

    public CommandLogic() { }

    public String[] getArgs() {
        return args;
    }

    public CommandLogic setArgs(String[] args) {
        this.args = args;
        return this;
    }

    public CommandSender getSender() {
        return sender;
    }

    public CommandLogic setSender(CommandSender sender) {
        this.sender = sender;
        return this;
    }

    public Command getCommand() {
        return command;
    }

    public CommandLogic setCommand(Command command) {
        this.command = command;
        return this;
    }

    public abstract boolean run();
}
