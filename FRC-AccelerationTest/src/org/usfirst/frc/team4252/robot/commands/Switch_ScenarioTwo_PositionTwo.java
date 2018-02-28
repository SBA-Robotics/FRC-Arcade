package org.usfirst.frc.team4252.robot.commands;

import static org.usfirst.frc.team4252.robot.RobotMap.driveSystem;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Switch_ScenarioTwo_PositionTwo extends InstantCommand {

    public Switch_ScenarioTwo_PositionTwo() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.driveSystem);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void initialize() {
    	driveSystem.driveEncodedStraight(40);
    	driveSystem.driveGyroSpin(45.0);
    	driveSystem.driveEncodedStraight(34);
    	driveSystem.driveGyroSpin(-45.0);
    	driveSystem.driveEncodedStraight(38);
    }

}
