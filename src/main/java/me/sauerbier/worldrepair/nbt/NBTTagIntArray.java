package me.sauerbier.worldrepair.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author Sauerbier | Jan
 * @Copyright 2017 by Jan Hof
 * All rights reserved.
 **/
public class NBTTagIntArray extends NBTBase {
    private int[] intArray;

    NBTTagIntArray() {
    }

    public NBTTagIntArray(int[] p_i45132_1_) {
        this.intArray = p_i45132_1_;
    }

    protected void write(DataOutput output) throws IOException{
        output.writeInt(this.intArray.length);
        int[] var2 = this.intArray;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int i = var2[var4];
            output.writeInt(i);
        }

    }

    protected void read(DataInput input, int depth, NBTSizeTracker sizeTracker) throws IOException {
        sizeTracker.read(192L);
        int i = input.readInt();
        sizeTracker.read((long)(32 * i));
        this.intArray = new int[i];

        for(int j = 0; j < i; ++j) {
            this.intArray[j] = input.readInt();
        }

    }

    public byte getId() {
        return 11;
    }

    public String toString() {
        String s = "[";
        int[] var2 = this.intArray;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int i = var2[var4];
            s = s + i + ",";
        }

        return s + "]";
    }

    public NBTTagIntArray copy() {
        int[] aint = new int[this.intArray.length];
        System.arraycopy(this.intArray, 0, aint, 0, this.intArray.length);
        return new NBTTagIntArray(aint);
    }

    public boolean equals(Object p_equals_1_) {
        return super.equals(p_equals_1_) ? Arrays.equals(this.intArray, ((NBTTagIntArray)p_equals_1_).intArray) : false;
    }

    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.intArray);
    }

    public int[] getIntArray() {
        return this.intArray;
    }
}