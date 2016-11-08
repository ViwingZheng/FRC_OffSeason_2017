package org.usfirst.frc.team321.subsystems;
 
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.utilities.MathUtil;

import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public SpeedController leftFront, leftMiddle, leftBack, rightFront, rightMiddle, rightBack;
	public Encoder leftEncoder, rightEncoder;
	
	private static final double MAX_POWER = 1.0;
	private static final double MIN_POWER = -1.0;
	
    public DriveTrain(){
    	 
        super("Drive Train");
 
            leftFront = new Talon(RobotMap.LEFT_FRONT_MOTOR);
            leftMiddle = new Talon(RobotMap.LEFT_MIDDLE_MOTOR);
            leftBack = new Talon(RobotMap.LEFT_BACK_MOTOR);
            
            rightFront = new Talon(RobotMap.RIGHT_FRONT_MOTOR);
            rightMiddle = new Talon(RobotMap.RIGHT_MIDDLE_MOTOR);
            rightBack = new Talon(RobotMap.RIGHT_BACK_MOTOR);
            
            leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_A, RobotMap.LEFT_ENCODER_B);
            rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B);
            
            leftEncoder.reset();
            rightEncoder.reset();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Makes the robot move
     * @param leftPower Sets the power to the left side of the robot
     * @param rightPower Sets the power to the right side of the robot
     */
    public void setMotorPower(double leftPower, double rightPower){
    	leftFront.set(normalizeMotorValue(leftPower, MIN_POWER, MAX_POWER));
    	leftMiddle.set(normalizeMotorValue(leftPower, MIN_POWER, MAX_POWER));
    	leftBack.set(normalizeMotorValue(leftPower, MIN_POWER, MAX_POWER));
    	
    	//Inverts the right motor
    	rightFront.set(-normalizeMotorValue(rightPower, MIN_POWER, MAX_POWER));
    	rightMiddle.set(-normalizeMotorValue(rightPower, MIN_POWER, MAX_POWER));
    	rightBack.set(-normalizeMotorValue(rightPower, MIN_POWER, MAX_POWER));
    }

	public double getLeftEncoderValue() {
		return leftEncoder.getRate();
	}

	public double getRightEncoderValue() {
		return rightEncoder.getRate();
	}   
	
	/**
	 * Returns a normalized value in between a range of numbers
	 * @param power The power to set the motor to
	 * @param minPower The minimum power
	 * @param maxPower The maximum power
	 * @return
	 */
	public double normalizeMotorValue(double power, double minPower, double maxPower){
		return MathUtil.squareKeepSign(MathUtil.clamp(power, minPower, maxPower));
	}
}