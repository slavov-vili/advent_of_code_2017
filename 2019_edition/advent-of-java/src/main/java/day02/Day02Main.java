package day02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import day02.instructions.IntCodeInstructionAddition;
import day02.instructions.IntCodeInstructionHalt;
import day02.instructions.IntCodeInstructionMultiplication;
import exceptions.InvalidArgumentException;
import exceptions.InvalidIntCodeException;
import utils.AdventOfCodeUtils;

public class Day02Main {

    public static void main(String[] args) {
        try {
            int solutionA = solveA();
            System.out.println("Solution A: " + solutionA);
            
            int solutionB = solveB(19690720);
            System.out.println("Solution B: " + solutionB);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    protected static int solveA() throws InvalidArgumentException, InvalidIntCodeException {
        IntCodeComputer computer = getComputer(initializeComputerState(getInputA()));
        return computer.run().getMemory().get(0);
    }
    
    protected static int solveB(int valueToFind) throws InvalidArgumentException, InvalidIntCodeException {
        int solutionNoun = 0;
        int solutionVerb = 0;
        IntCodeComputer computer = getComputer(initializeComputerState(getInputFor(solutionNoun, solutionVerb)));

        for (int valueNoun = 0; valueNoun < 100; valueNoun++)
            for (int valueVerb = 0; valueVerb < 100; valueVerb++) {
                try {
                    computer.resetState(initializeComputerState(getInputFor(valueNoun, valueVerb)));
                    int curSolution = computer.run().getMemory().get(0);
                    if (curSolution == valueToFind) {
                        solutionNoun = valueNoun;
                        solutionVerb = valueVerb;
                        break;
                    }
                } catch (InvalidIntCodeException e) {
                    continue;
                }
            }

        return (100 * solutionNoun) + solutionVerb;
    }

    protected static IntCodeComputer getComputer(IntCodeComputerState initialState) throws InvalidArgumentException {
        IntCodeInstructionProvider instructionProvider = new IntCodeInstructionProvider(new IntCodeInstructionHalt(99));
            instructionProvider.addNewInstruction(new IntCodeInstructionAddition(1, 3));
            instructionProvider.addNewInstruction(new IntCodeInstructionMultiplication(2, 3));

        return new IntCodeComputer(initialState, instructionProvider);
    }

    protected static IntCodeComputerState initializeComputerState(List<Integer> initialMemory) {
        return new IntCodeComputerState(initialMemory, 0);
    }

    protected static List<Integer> getInputA() {
        return getInputFor(12, 2);
    }
    
    protected static List<Integer> getInputFor(int valueAtPos1, int valueAtPos2) {
        List<Integer> inputCodes = getInput();
        inputCodes.set(1, valueAtPos1);
        inputCodes.set(2, valueAtPos2);

        return inputCodes;
    }

    protected static List<Integer> getInput() {
        String intCodesString = AdventOfCodeUtils.readClasspathFileLines(Day02Main.class, "input.txt").get(0);
        return Arrays.asList(intCodesString.split(",")).stream()
        		.map(Integer::parseInt)
        		.collect(Collectors.toList());
    }
}