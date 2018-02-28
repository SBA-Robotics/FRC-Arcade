package org.usfirst.frc.team4252.robot.commands;

import static org.usfirst.frc.team4252.robot.RobotMap.driveSystem;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Switch_ScenarioOne_PositionTwo extends InstantCommand {

    public Switch_ScenarioOne_PositionTwo() {
     // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.driveSystem);
    }

    // Called once when the command executes
 // Called repeatedly when this Command is scheduled to run
    protected void initialize() {
    	driveSystem.driveEncodedStraight(41);
    	driveSystem.driveGyroSpin(-90.0);
    	driveSystem.driveEncodedStraight(61);
    	driveSystem.driveGyroSpin(90.0);
    	driveSystem.driveEncodedStraight(67);
    }

}
