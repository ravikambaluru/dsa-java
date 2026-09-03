package prefixSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumArrayTest {
    private NumArray numArray;

    @Test
    void sumRange() {
        this.numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        this.numArray.sumRange(0, 2);
    }
}