package org.usfirst.frc.team4252.robot.commands;

import static org.usfirst.frc.team4252.robot.RobotMap.driveSystem;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class Switch_ScenarioOne_PositionOne extends InstantCommand {

    public Switch_ScenarioOne_PositionOne() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.driveSystem);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void initialize() {
    	driveSystem.driveEncodedStraight(134);
    	driveSystem.driveGyroSpin(90.0);
    }

}
