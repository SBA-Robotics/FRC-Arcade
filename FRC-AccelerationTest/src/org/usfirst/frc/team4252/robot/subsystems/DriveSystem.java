package org.usfirst.frc.team4252.robot.subsystems;

import static org.usfirst.frc.team4252.robot.RobotMap.analogGyro;
import static org.usfirst.frc.team4252.robot.RobotMap.encoder;
import static org.usfirst.frc.team4252.robot.RobotMap.robotDrive;

import org.usfirst.frc.team4252.robot.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem
{
	public static final double kAngleP = 0.03;
	public static final double kAngleD = -0.02;
	public static final double kSpeedP = 0.03;
	public static final double kSpeedD = 0.03;
	
	public boolean invertJoystick = true;

	public void driveEncodedStraight(int distance)
	{
		reset();

		double error = distance - encoder.getDistance();

		while(error > 20)
		{
			robotDrive.drive(0.25, -analogGyro.getAngle() * kAngleP);
			error = distance - encoder.getDistance();
		}

		while(error > 0)
		{
			error = distance - encoder.getDistance();
			robotDrive.drive(kSpeedD + (kSpeedP * error), -analogGyro.getAngle() * kAngleP);

			// This is what David Moss made as his forward autonomous, the bot should
			// correct its angle proportional to deviation
		}

		stop();
	}

	public void driveGyroSpin(double angle)
	{
		reset();

		double angleSpin = angle - analogGyro.getAngle();
		robotDrive.drive(0, angleSpin * kAngleP + kAngleD);
	}

	public void reset()
	{
		encoder.reset();
		analogGyro.reset();
	}
	
	public void stop()
	{
		robotDrive.drive(0, 0);
	}
	
	public void arcadeDriveWithJoystick(Joystick joystick)
	{
		if (ShooterSystem.activate)
		{
			double x = OI.joystick.getRawAxis(0), y = OI.joystick.getRawAxis(1);

			if(invertJoystick)
			{
				x = -x;
				y = -y;
			}

			robotDrive.arcadeDrive(Math.signum(y) * Math.sqrt(Math.abs(y)), Math.signum(x) * Math.sqrt(Math.abs(x)));
		}
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(OI.arcadeDrive);
	}
}
