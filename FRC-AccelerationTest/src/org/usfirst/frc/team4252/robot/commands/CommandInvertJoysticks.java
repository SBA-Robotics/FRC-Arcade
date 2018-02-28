package org.usfirst.frc.team4252.robot.commands;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *	Inverts the axes on the joysticks
 */
public class CommandInvertJoysticks extends InstantCommand
{
	public CommandInvertJoysticks()
	{
		super();
	}

	protected void initialize()
	{
		RobotMap.driveSystem.invertJoystick = !RobotMap.driveSystem.invertJoystick;
	}
}
