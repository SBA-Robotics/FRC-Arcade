package org.usfirst.frc.team4252.robot.commands;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ArmBack extends Command 
{
	public ArmBack()
	{
		requires(RobotMap.armSystem);
	}
	
    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	RobotMap.armSystem.armsBack();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	RobotMap.armSystem.armsStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	RobotMap.armSystem.armsStop();
    }
}
