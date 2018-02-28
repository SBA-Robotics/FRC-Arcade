package org.usfirst.frc.team4252.robot;

import org.usfirst.frc.team4252.robot.subsystems.ArmSystem;
import org.usfirst.frc.team4252.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4252.robot.subsystems.ShooterSystem;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	public static final Victor leftMotor, rightMotor;
	public static final BuiltInAccelerometer accelerometer = new BuiltInAccelerometer();
	public static final Victor shooterL, shooterR;
	public static final Victor intakeL, intakeR;
	public static final Victor armL, armR;

	public static final RobotDrive robotDrive;

	public static final Encoder encoder;
	public static final AnalogGyro analogGyro;

	/** Subsystems */
	public static final DriveSystem driveSystem;
	public static final ShooterSystem shooterSystem;
	public static final ArmSystem armSystem;

	static
	{
		rightMotor = new Victor(0);
		leftMotor = new Victor(1);

		shooterR = new Victor(2);
		shooterL = new Victor(7);

		intakeR = new Victor(6);
		intakeL = new Victor(3);

		armR = new Victor(4);
		armL = new Victor(5);
		encoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		analogGyro = new AnalogGyro(0);

		encoder.setDistancePerPulse(6 * Math.PI / 22);
		encoder.setMaxPeriod(0.1);
		encoder.setMinRate(10);
		encoder.setSamplesToAverage(20);
		
		analogGyro.calibrate();
		analogGyro.reset();

		robotDrive = new RobotDrive(leftMotor, rightMotor);

		driveSystem = new DriveSystem();
		shooterSystem = new ShooterSystem();
		armSystem = new ArmSystem();
	}
}
