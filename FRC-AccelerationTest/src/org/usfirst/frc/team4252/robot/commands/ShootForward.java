package org.usfirst.frc.team4252.robot.commands;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootForward extends Command 
{
    public ShootForward() 
    {
        requires(RobotMap.shooterSystem);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	RobotMap.shooterSystem.shoot();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	RobotMap.shooterSystem.stopShoot();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	RobotMap.shooterSystem.stopShoot();
    }
}
