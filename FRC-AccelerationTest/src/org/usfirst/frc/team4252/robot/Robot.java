package org.usfirst.frc.team4252.robot;

import static org.usfirst.frc.team4252.robot.RobotMap.driveSystem;
import static org.usfirst.frc.team4252.robot.RobotMap.robotDrive;

import org.usfirst.frc.team4252.robot.commands.Switch_ScenarioOne_PositionOne;
import org.usfirst.frc.team4252.robot.commands.Switch_ScenarioOne_PositionThree;
import org.usfirst.frc.team4252.robot.commands.Switch_ScenarioOne_PositionTwo;
import org.usfirst.frc.team4252.robot.commands.Switch_ScenarioTwo_PositionOne;
import org.usfirst.frc.team4252.robot.commands.Switch_ScenarioTwo_PositionThree;
import org.usfirst.frc.team4252.robot.commands.Switch_ScenarioTwo_PositionTwo;
import org.usfirst.frc.team4252.robot.subsystems.ShooterSystem;

import calculus.lib.Function;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot
{
	private Command autonomousCommand;
	//SendableChooser OI.chooser;
	private Function ax, vx, omega;
	public static int time = 0;

	@Override
	public void robotInit()
	{
		robotDrive.setSafetyEnabled(false);
		robotDrive.setExpiration(0.5);//WAS 0.1
		robotDrive.setMaxOutput(0.6);
		
		OI.chooser.addDefault("Scen1Purple", new Switch_ScenarioOne_PositionOne());
		OI.chooser.addObject("Scen1Green", new Switch_ScenarioOne_PositionTwo());
		OI.chooser.addObject("Scen1Orange", new Switch_ScenarioOne_PositionThree());
		OI.chooser.addObject("Scen2Purple", new Switch_ScenarioTwo_PositionOne());
		OI.chooser.addObject("Scen2Green", new Switch_ScenarioTwo_PositionTwo());
		OI.chooser.addObject("Scen2Orange", new Switch_ScenarioTwo_PositionThree());
		SmartDashboard.putData("Autonomous Mode", OI.chooser);
		
		OI.registerCommands();
		
		CameraServer.getInstance().startAutomaticCapture();
		
		ax = new Function();
		vx = new Function();
		omega = new Function();
	}
	
	@Override
	public void robotPeriodic()
	{
		SmartDashboard.putNumber("Angle", RobotMap.analogGyro.getAngle());
		
		ax.addPoint(time * 20, (Math.round(RobotMap.accelerometer.getX() * 98) / 10.0 - 0.3) / 1000 / 1000 /* 3.937 * Math.pow(10, -5)*/);
		omega.addPoint(time * 20, Math.round(Math.sqrt(Math.abs(ax.at(time * 20) / (7 * 0.0254))) * 10) / 10.0);
		
		vx.addPoint(time * 20, Math.round(ax.area(0, time * 20, 20) * 10) / 10.0);
		
		SmartDashboard.putNumber("X", ax.at(time * 20) * 1000 * 1000);
		SmartDashboard.putNumber("Vx", vx.at(time * 20) * 1000);
		SmartDashboard.putNumber("Dx", Math.round(vx.area(0, time * 20, 20) * 10) / 10.0);
		SmartDashboard.putNumber("Angle", Math.round(omega.area(0, time * 20, 20)));
		
		time++;
	}

	@Override
	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit()
	{
		autonomousCommand = OI.chooser.getSelected();

		if(autonomousCommand != null) autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit()
	{
		if(autonomousCommand != null) autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();

		if(OI.joystick.getPOV(0) == 0) 
		{
			OI.armBk.cancel();
			OI.armFw.start();
		}
		else if(OI.joystick.getPOV(0) == 180)
		{
			OI.armFw.cancel();
			OI.armBk.start();
		}
		else
		{
			OI.armFw.cancel();
			OI.armBk.cancel();
		}
	}
	
	@Override
	public void disabledInit()
	{
		ax.clear();
		vx.clear();
		omega.clear();
		time = 0;
	}
}
