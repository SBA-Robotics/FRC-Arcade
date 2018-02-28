package org.usfirst.frc.team4252.robot.commands;

import static org.usfirst.frc.team4252.robot.RobotMap.driveSystem;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StraightThenReturn extends InstantCommand {

    public StraightThenReturn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.driveSystem);
    }

    protected void execute() {
    	//driveSystem.driveEncodedStraight(50);
    	driveSystem.driveGyroSpin(180.0);
    	//driveSystem.driveEncodedStraight(50);
    }

}
