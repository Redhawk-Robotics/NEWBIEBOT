// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import edu.wpi.first.wpilibj.CounterBase.EncodingType;
// import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  
   public XboxController driverController = new XboxController(0);
  
   public CANSparkMax leftMotor1 = new CANSparkMax(1, MotorType.kBrushless);
   public CANSparkMax leftMotor2 = new CANSparkMax(2, MotorType.kBrushless);
 
   // We got 2 right drive motors
   public CANSparkMax rightMotor1 = new CANSparkMax(3, MotorType.kBrushless);
   public CANSparkMax rightMortor2 = new CANSparkMax(4, MotorType.kBrushless);
 
   // We are grouping the 2 left drivetrain motors to one group
   public final MotorControllerGroup leftDrive = new MotorControllerGroup(leftMotor1, leftMotor2);
   // We are grouping the 2 right drivetrain motors to one group
   public final MotorControllerGroup rightDrive = new MotorControllerGroup(rightMotor1, rightMortor2);
 
   // Our whole drivetrain put together
   public final DifferentialDrive drivetrain = new DifferentialDrive(leftDrive, rightDrive);

  @Override
  public void robotInit() {
    leftMotor1.setIdleMode(IdleMode.kBrake);
    leftMotor2.setIdleMode(IdleMode.kBrake);
    rightMotor1.setIdleMode(IdleMode.kBrake);
    rightMortor2.setIdleMode(IdleMode.kBrake);
    
    leftDrive.setInverted(true);
    rightDrive.setInverted(false);

    drivetrain.setDeadband(.05);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    drivetrain.arcadeDrive(driverController.getLeftY() / 2, driverController.getRightX() / 2);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
