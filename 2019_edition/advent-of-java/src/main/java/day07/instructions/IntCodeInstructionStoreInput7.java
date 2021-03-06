package day07.instructions;

import java.util.List;

import day05.instructions.IntCodeInstructionWriting;
import day07.IntCodeComputer7;

public class IntCodeInstructionStoreInput7 extends IntCodeInstructionWithMissingInput
	implements IntCodeInstructionWriting {

	private int writeParamIndex;

	public IntCodeInstructionStoreInput7(Long opCode) {
		super(opCode, 1);
		this.writeParamIndex = 0;
	}

	@Override
	protected void applyWithInput(IntCodeComputer7 computer, List<Long> parameters, String userInput) {
		computer.setMemoryAddress(parameters.get(this.writeParamIndex), Long.parseLong(userInput));
	}

	@Override
	public int getWriteParamIndex() {
		return this.writeParamIndex;
	}

}
