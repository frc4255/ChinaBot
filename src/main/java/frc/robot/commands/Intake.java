/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.FrontIntake;
import frc.robot.Robot;


public class Intake extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Conveyor m_conveyor;
  private final FrontIntake m_frontIntake;

  /**
   * Creates a new Test.
   */
  public Intake(final Conveyor conveyor, final FrontIntake frontIntake) {
    m_conveyor = conveyor;
    m_frontIntake = frontIntake;
    addRequirements(frontIntake); // here to declare subsystem dependencies.
    addRequirements(conveyor);
  }
  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_conveyor.setStopper(m_conveyor.close);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    m_frontIntake.setArm(m_frontIntake.down);
    m_conveyor.setMotors(0.7);
    m_frontIntake.setMotors(0.7);
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }
}