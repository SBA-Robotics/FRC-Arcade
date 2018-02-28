package org.usfirst.frc.team4252.robot.commands;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CommandLoadShooter extends Command
{
	@Override
	public void execute()
	{
		RobotMap.shooterSystem.draw();
	}
	
	@Override
	public void end()
	{
		RobotMap.shooterSystem.stopDraw();
	}
	
	@Override
	protected boolean isFinished() 
	{
		return false;
	}

}
