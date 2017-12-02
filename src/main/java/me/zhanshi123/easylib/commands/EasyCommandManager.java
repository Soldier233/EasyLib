package me.zhanshi123.easylib.commands;

import me.zhanshi123.easylib.exceptions.NameConflictException;

import java.util.HashMap;

public class EasyCommandManager {
    private static EasyCommandManager instance;
    public EasyCommandManager(){
        instance=this;
    }

    public static EasyCommandManager getInstance() {
        return instance;
    }

    private HashMap<String,EasyCommand> data=new HashMap<>();

    public void addCommand(EasyCommand command) throws NameConflictException {
        if(data.containsKey(command)){
            throw new NameConflictException("根命令冲突! 欲注册的根命令: "+command.getCommand());
        } else{
            data.put(command.getCommand(),command);
        }
    }
    public EasyCommand getCommand(String name){
        return data.get(name);
    }
}
