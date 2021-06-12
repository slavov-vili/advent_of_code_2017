package day02;

import java.util.ArrayList;
import java.util.List;

public class IntCodeComputerState {

    private List<Integer> memory;
    private int curInstructionIdx;

    public IntCodeComputerState(List<Integer> memory, int curInstructionIdx) {
        this.memory = memory;
        this.curInstructionIdx = curInstructionIdx;
    }

    public List<Integer> getMemory() {
        return new ArrayList<>(this.memory);
    }

    public int getCurInstructionIdx() {
        return this.curInstructionIdx;
    }

}
