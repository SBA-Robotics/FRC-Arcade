package org.usfirst.frc.team4252.robot.subsystems;

import static org.usfirst.frc.team4252.robot.RobotMap.driveSystem;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSystem extends Subsystem 
{
	public void armsForward()
	{
		RobotMap.armL.set(0.5);
		RobotMap.armR.set(-0.5);
	}
	
	public void armsBack()
	{
		RobotMap.armL.set(-0.5);
		RobotMap.armR.set(0.5);
	}
	
	public void armsStop()
	{
		RobotMap.armL.set(0);
		RobotMap.armR.set(0);
	}

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

