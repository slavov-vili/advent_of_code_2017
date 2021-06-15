package day02;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import day02.instructions.IntCodeInstruction;
import day02.instructions.IntCodeInstructionAddition;
import day02.instructions.IntCodeInstructionHalt;
import day02.instructions.IntCodeInstructionMultiplication;
import exceptions.InvalidArgumentException;
import exceptions.InvalidIntCodeException;

public class IntCodeInstructionProviderTest {

    @Test
    void addInstructionToEmptyProviderTest() {
        IntCodeInstruction instructionToAdd = new IntCodeInstructionAddition(1);
        IntCodeInstructionProvider provider = new IntCodeInstructionProvider(new IntCodeInstructionHalt(99));

        try {
            provider.addNewInstruction(instructionToAdd);
        } catch (Exception e) {
            fail("No exception should be thrown when adding to an empty provider!");
        }
    }

    @Test
    void addInstructionWithExistingCodeTest() {
        IntCodeInstruction existingInstruction = new IntCodeInstructionAddition(1);
        IntCodeInstructionProvider provider = new IntCodeInstructionProvider(new IntCodeInstructionHalt(99));

        try {
            provider.addNewInstruction(existingInstruction);
        } catch (Exception e) {
        }

        try {
            provider.addNewInstruction(existingInstruction);
            fail("Exception should be thrown, since this instruction code is already taken!");
        } catch (InvalidArgumentException e) {
            return;
        } catch (Exception e) {
            fail("Only InvalidArgumentException should be thrown!");
        }
    }

    @Test
    void getInstructionFromEmptyProviderTest() {
        int codeOfInstructionToGet = 1;
        IntCodeInstructionProvider provider = new IntCodeInstructionProvider(new IntCodeInstructionHalt(99));

        try {
            provider.getInstructionByOpCode(codeOfInstructionToGet);
            fail("An exception should be thrown, since the provider is empty!");
        } catch (InvalidIntCodeException e) {
            return;
        } catch (Exception e) {
            fail("Only InvalidIntCodeException should be thrown!");
        }
    }

    @Test
    void getInstructionByInvalidTest() {
        int codeOfInstructionToGet = 11;
        IntCodeInstructionProvider provider = new IntCodeInstructionProvider(new IntCodeInstructionHalt(99));

        try {
            provider.addNewInstruction(new IntCodeInstructionAddition(1));
            provider.addNewInstruction(new IntCodeInstructionMultiplication(2));
        } catch (Exception e) {
        }

        try {
            provider.getInstructionByOpCode(codeOfInstructionToGet);
            fail("An exception should be thrown, since the instruction code is unknown!");
        } catch (InvalidIntCodeException e) {
            return;
        } catch (Exception e) {
            fail("Only InvalidIntCodeException should be thrown!");
        }
    }
}
