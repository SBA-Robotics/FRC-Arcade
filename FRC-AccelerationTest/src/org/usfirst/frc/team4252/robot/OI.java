package org.usfirst.frc.team4252.robot;

import org.usfirst.frc.team4252.robot.commands.ArmBack;
import org.usfirst.frc.team4252.robot.commands.ArmForward;
import org.usfirst.frc.team4252.robot.commands.ButtonSlow;
import org.usfirst.frc.team4252.robot.commands.CommandArcadeDrive;
import org.usfirst.frc.team4252.robot.commands.CommandInvertJoysticks;
import org.usfirst.frc.team4252.robot.commands.CommandLoadShooter;
import org.usfirst.frc.team4252.robot.commands.ShootBack;
import org.usfirst.frc.team4252.robot.commands.ShootForward;
import org.usfirst.frc.team4252.robot.commands.StraightThenReturn;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	/** Controls */
	public static final Joystick joystick;

	public static final JoystickButton btnA;
	public static final JoystickButton btnB;
	public static final JoystickButton btnX;
	public static final JoystickButton btnY;
	public static final JoystickButton bumperL;
	public static final JoystickButton bumperR;
	public static final JoystickButton triggerL;
	public static final JoystickButton triggerR;
	public static final JoystickButton btnBack;
	public static final JoystickButton btnStart;
	public static final JoystickButton btnL;
	public static final JoystickButton btnR;

	/** Commands */
	public static final SendableChooser<Command> chooser;

	public static final CommandInvertJoysticks invertJoysticks;
	public static final CommandArcadeDrive arcadeDrive;
	public static final CommandLoadShooter loadShooter;
	public static final ShootForward shootForward;
	public static final ShootBack shootBack;
	public static final ArmForward armFw;
	public static final ArmBack armBk;
	public static final StraightThenReturn testOne;
	public static final ButtonSlow buttonSlow;

	static
	{
		joystick = new Joystick(0);

		btnX = new JoystickButton(joystick, 1);
		btnA = new JoystickButton(joystick, 2);
		btnB = new JoystickButton(joystick, 3);
		btnY = new JoystickButton(joystick, 4);
		bumperL = new JoystickButton(joystick, 5);
		bumperR = new JoystickButton(joystick, 6);
		triggerL = new JoystickButton(joystick,7);
		triggerR = new JoystickButton(joystick,8);
		btnBack = new JoystickButton(joystick, 9);
		btnStart = new JoystickButton(joystick, 10);
		btnL = new JoystickButton(joystick, 11);
		btnR = new JoystickButton(joystick, 12);

		chooser = new SendableChooser<Command>();

		invertJoysticks = new CommandInvertJoysticks();
		testOne = new StraightThenReturn();
		loadShooter = new CommandLoadShooter();
		shootForward = new ShootForward();
		shootBack = new ShootBack();
		armFw = new ArmForward();
		armBk = new ArmBack();
		arcadeDrive = new CommandArcadeDrive();
		buttonSlow = new ButtonSlow();
	}

	public static void registerCommands()
	{
		bumperR.whenPressed(invertJoysticks);
		bumperL.whileHeld(buttonSlow);
		btnX.whileHeld(loadShooter);
		triggerR.whileHeld(shootForward);
		triggerL.whileHeld(shootBack);
	}
}
