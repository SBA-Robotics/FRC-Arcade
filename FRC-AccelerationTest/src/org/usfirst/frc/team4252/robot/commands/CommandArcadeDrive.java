package org.usfirst.frc.team4252.robot.commands;

import static org.usfirst.frc.team4252.robot.RobotMap.driveSystem;

import org.usfirst.frc.team4252.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class CommandArcadeDrive extends Command
{
	public CommandArcadeDrive()
	{
		requires(driveSystem);
	}

	protected void execute()
	{
		driveSystem.arcadeDriveWithJoystick(OI.joystick);
	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
		driveSystem.stop();
	}

	protected void interrupted()
	{
		driveSystem.stop();
	}
}
