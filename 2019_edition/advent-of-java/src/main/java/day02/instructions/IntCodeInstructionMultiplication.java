package day02.instructions;

import java.util.List;

import exceptions.InvalidArgumentCountException;

public class IntCodeInstructionMultiplication implements IntCodeInstruction {

	private int inputSize;
	private int instructionCode;

	public IntCodeInstructionMultiplication(int instructionCode, int inputSize) {
		this.instructionCode = instructionCode;
		this.inputSize = inputSize;
	}

	public int apply(List<Integer> inputValues) {
		if (inputValues.size() != this.inputSize)
			throw new InvalidArgumentCountException(this.inputSize + " arguments expected");

		int sum = 1;
		for (Integer value : inputValues)
			sum *= value;
		return sum;
	}

	public int getCode() {
		return this.instructionCode;
	}

	public int getInputSize() {
		return this.inputSize;
	}

}
