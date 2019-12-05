package day02.instructions;

import java.util.List;

public class IntCodeInstructionMultiplication extends IntCodeInstructionAbstract {

    public IntCodeInstructionMultiplication(int instructionCode, int paramCount) {
        super(instructionCode, paramCount);
    }

    @Override
    public IntCodeInstructionResult apply(List<Integer> valuesIncludingOutput) {
        int outputValue = valuesIncludingOutput.stream().limit(valuesIncludingOutput.size() - 1).reduce(1,
                (a, b) -> a * b);
        int instructionJumpSize = valuesIncludingOutput.size();
        return new IntCodeInstructionResult(outputValue, instructionJumpSize);
    }

}
