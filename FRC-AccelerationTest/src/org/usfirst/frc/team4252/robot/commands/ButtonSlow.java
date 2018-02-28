package org.usfirst.frc.team4252.robot.commands;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ButtonSlow extends Command 
{

    public ButtonSlow() 
    {
        super();
    }
    
    @Override
    public void execute()
    {
    	RobotMap.robotDrive.setMaxOutput(1.0);
    }
    
    @Override
    public void end()
    {
    	RobotMap.robotDrive.setMaxOutput(0.6);
    }
    
    @Override
    public void interrupted()
    {
    	RobotMap.robotDrive.setMaxOutput(0.6);
    }
    
    @Override
    public boolean isFinished()
    {
    	return false;
    }
}
