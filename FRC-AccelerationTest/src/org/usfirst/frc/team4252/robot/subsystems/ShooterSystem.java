package org.usfirst.frc.team4252.robot.subsystems;

import static org.usfirst.frc.team4252.robot.RobotMap.driveSystem;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSystem extends Subsystem 
{
	public static boolean activate = true;
	public void draw()
	{
		activate = false;
		RobotMap.intakeL.set(0.5);
		RobotMap.intakeR.set(-0.5);
	}
	
	public void stopDraw()
	{
		activate = true;
		RobotMap.intakeL.set(0);
		RobotMap.intakeR.set(0);
	}
	
	public void shoot()
	{
		activate = false;
		RobotMap.shooterL.set(0.5);
		RobotMap.shooterR.set(-0.5);
	}
	
	public void shootBack()
	{
		activate = false;
		RobotMap.shooterL.set(-0.5);
		RobotMap.shooterR.set(0.5);
	}
	
	public void stopShoot()
	{
		activate = true;
		RobotMap.shooterL.set(0);
		RobotMap.shooterR.set(0);
	}
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

